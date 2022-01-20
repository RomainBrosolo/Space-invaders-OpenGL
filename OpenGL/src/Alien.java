import com.jogamp.opengl.GL2;

public class Alien extends Shape3D
{
	private GLHandler events;
	private boolean movementTop;
	private boolean movementRight;
	private float posx;
	private float posy;
	private final static float translate = 0.01f;
	
	public Alien(float x, float y, float z, float size, boolean movementRight, GLHandler events)
	{
		this.x = x; this.y = y; this.z = z;
		this.size = size;
		this.events = events;
		
		this.posy = y;
		
		if (movementRight) {
			this.posx = 2;
		} else {
			this.posx = -2;
		}
		this.movementTop = true;
		this.movementRight = movementRight;
	}
	
	public void display(GL2 gl)
	{
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 10, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(1, 0, 1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(-1, 1, 1);
		// Rear
		gl.glColor3d(1, 1, 1);
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		// Left
		gl.glColor3d(1, 1, 1);
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(-1, 1,  1);
		gl.glVertex3d(-1, 1, -1);
		// Right
		gl.glColor3d(1, 1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1,  1);
		gl.glVertex3d(1, 1, -1);
		// Bottom
		gl.glColor3d(1, 1, 1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(-1, -1, -1);
		// Up
		gl.glColor3d(1, 1, 1);
		gl.glVertex3d(-1, 1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		gl.glEnd();	
		gl.glPopMatrix();
		
		
		if ( this.y <= this.posy ) {
			if ( this.x <= this.posx ) {
				if ( this.movementTop && !this.movementRight ) {
					this.posy -= 1f;
					this.movementTop = false;
				} else {
					this.x += Alien.translate;
				}
			} else if ( this.x >= this.posx ) {
				if ( this.movementTop && this.movementRight ) {
					this.posy -= 1f;
					this.movementTop = false;
				} else {
					this.x -= Alien.translate;
				}
			}
		} else if ( this.y >= this.posy ) {
			this.y -= Alien.translate;
			
			if (this.y <= posy && !this.movementTop ) {
				this.posx = -this.posx;
				this.movementTop = true;
				this.movementRight = !this.movementRight;
			}
		}
		if (this.y <= -1.5f) {
			System.out.println("Game Over !");
			this.events.gameOver();
		}
	}
}