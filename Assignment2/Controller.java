//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 9/15/22
// Description: The java file holds the Controller class allows the user to control
// the turtle by clicking the mouse or using the arrow keys
//----------------------------------------------------------------
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener, KeyListener
{
	//Member variables
	View view;
	Model model;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;

	// Controller Constructor
	Controller(Model m)
	{
		model = m;
	}

	// Method that sets the view
	void setView(View v)
	{
    	view = v;
	}

	public void actionPerformed(ActionEvent e)
	{
		view.removeButton();
	}

	public void mousePressed(MouseEvent e)
	{
		model.setDestination(e.getX(), e.getY());
	}

	public void mouseReleased(MouseEvent e) 
	{    
	}
	
	public void mouseEntered(MouseEvent e) 
	{    
	}
	
	public void mouseExited(MouseEvent e) 
	{   
	}
	
	public void mouseClicked(MouseEvent e) 
	{    
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	// Method that updates how when the turtle moves based on the key pressed
	void update()
	{
		if(keyRight) model.dest_x+=4;
		if(keyLeft) model.dest_x-=4;
		if(keyDown) model.dest_y+=4;
		if(keyUp) model.dest_y-=4;
	}
}
