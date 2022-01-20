import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class GLHandler implements GLEventListener
{
	private JFrame frame;
	private GLU glu;
	private float angle;
	private float posX, posY;
	private ArrayList<Shape3D> aliens;
	private Shape3D vaisseau;
	private Shape3D missile;
	
	public GLHandler(JFrame frame){
		this.frame = frame;
		this.glu = new GLU();
		this.angle = 0;
		
		this.aliens = new ArrayList<Shape3D>();
		this.aliens.add(new Alien(-2, 1.5f, -5, 0.15f, true, this)); //(x,y,profondeur,taille)
		this.aliens.add(new Alien(-1, 1.5f, -5, 0.15f, true, this)); 
		this.aliens.add(new Alien(0, 1.5f, -5, 0.15f, true, this)); 
		this.aliens.add(new Alien(1, 1.5f, -5, 0.15f, true, this));
		this.aliens.add(new Alien(2, 1.5f, -5, 0.15f, true, this));
		this.aliens.add(new Alien(-2.2f, 1f, -5, 0.15f, true, this)); 
		this.aliens.add(new Alien(-1.2f, 1f, -5, 0.15f, true, this)); 
		this.aliens.add(new Alien(0.2f, 1f, -5, 0.15f, true, this)); 
		this.aliens.add(new Alien(1.2f, 1f, -5, 0.15f, true, this));
		this.aliens.add(new Alien(2.2f, 1f, -5, 0.15f, true, this));
		
		this.vaisseau = new Vaisseau(0, -1.5f, -5, 0.15f);
		this.missile = new Missile(0, -1.5f, -5, 0.15f);
	}

	@Override
	public void init(GLAutoDrawable draw) {
		GL2 gl = draw.getGL().getGL2();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);	
	}
	
	@Override
	public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
		GL2 gl = draw.getGL().getGL2();
		// -- SCREEN
		float aspect = (float)width / height;
		gl.glViewport(0, 0, width, height);
		// -- CAMERA
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// FOCAL, ASPECT, Zmin, Zmax
		this.glu.gluPerspective(45.0, aspect, 0.1, 100);
		// -- OBJECTS ?
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void display(GLAutoDrawable draw) 
	{
		// DESSIN ???
		GL2 gl = draw.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(this.posX, this.posY, -0.01f);
		
		for (Shape3D s : this.aliens)
			s.display(gl);
		
		vaisseau.display(gl);
		gl.glRotatef(angle, 1.0f, 0.0f, 0.0f);
		missile.display(gl);
		// Update properties
		this.angle += 0.5;	
	}

	public void goRight() { 
		if (vaisseau.x < 2.4f) {
			vaisseau.x += 0.1f;
		} 
		
	}
	public void goLeft() {
		if (vaisseau.x > -2.3f) {
			vaisseau.x -= 0.1f; 
		}
	}
	
	public void gameOver() {
		this.frame.dispose();
		System.exit(0);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub	
	}


}