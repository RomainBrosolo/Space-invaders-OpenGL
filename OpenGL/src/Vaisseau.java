import com.jogamp.opengl.GL2;

public class Vaisseau extends Shape3D
{
	
	public Vaisseau(float x, float y, float z, float size)
	{
		this.x = x; this.y = y; this.z = z;
		this.size = size;
	}
	
	public void display(GL2 gl)
	{
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(size * 10, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-2, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 0.1f, 1);
		gl.glVertex3d(-2, 0.1f, 1);
		// Rear
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-2, -1, -1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, 0.1f, -1);
		gl.glVertex3d(-2, 0.1f, -1);
		// Left
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-2, -1, -1);
		gl.glVertex3d(-2, -1, 1);
		gl.glVertex3d(-2, 0.1f,  1);
		gl.glVertex3d(-2, 0.1f, -1);
		// Right
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 0.1f,  1);
		gl.glVertex3d(1, 0.1f, -1);
		// Bottom
		gl.glColor3d(15, 109, 0);
		gl.glVertex3d(-2, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(-2, -1, -1);
		// Up
		gl.glColor3d(15, 200, 95);
		gl.glVertex3d(-2, 0.1f, 1);
		gl.glVertex3d(1, 0.1f, 1);
		gl.glVertex3d(1, 0.1f, -1);
		gl.glVertex3d(-2, 0.1f, -1);
		gl.glEnd();	
		gl.glPopMatrix();
	}

}