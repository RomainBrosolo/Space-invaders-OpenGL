import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserKeyboard implements KeyListener
{
	
	private GLHandler events;
	
	public UserKeyboard(GLHandler events)
	{
		this.events = events;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyChar() == 'q')
			this.events.goLeft();
		if (e.getKeyChar() == 'd')
			this.events.goRight();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}