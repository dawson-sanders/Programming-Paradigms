//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/13/22
// Description: The java file holds the Controller class allows the user to control
// scrolling/clicking to add pipes and control mario in the world
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
	boolean editMap;
	boolean spaceBar;

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
	} 

	public void mousePressed(MouseEvent e)
	{
		// Adds a pipe when the mouse is pressed when in edit mode
		if(editMap == true)
			model.addPipe(e.getX() + view.scrollPos, e.getY()); 
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
			case KeyEvent.VK_SPACE: spaceBar = true; break;
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
			case KeyEvent.VK_SPACE: spaceBar = false; break;
		}

		// Exits game when esc key is pressed
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
		
		// Initializing local variable char c
		char c = Character.toLowerCase(e.getKeyChar());

		// Statement to quit game upon releasing q
		if(c == 'q' || c == 'Q')
			System.exit(0);

		// Statement to save game upon releasing s
		if(c == 's' || c == 'S')
		{
			Json saveObject = model.marshal();
			saveObject.save("map.json");
			System.out.println("File is Saved");
		}

		// Statement to load game upon releasing l
		if(c == 'l' || c == 'L')
		{
			Json j = Json.load("map.json");
			model.unmarshal(j);
			System.out.println("File is Loaded");
		} 

		// Statement to enter edit map mode upon releasing e
		if(c == 'e' || c == 'E')
		{
			editMap = true;
			System.out.println("You are currently in edit map mode");
		}  

		// Statement to enter play mode upon releasing p
		if(c == 'p' || c == 'P')
		{
			editMap = false;
			System.out.println("You are currently in play mode");
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	// Method that updates the scroll 
	void update()
	{
		model.mario.setPreviousPosition();
		
		// Statement to control the right arrow key and updates mario
		if(keyRight) 
		{
			model.mario.rightFacing = true;
			model.mario.x += 10;
			model.mario.changeImageState();
		}
		
		// Statement to control the left arrow key and updates mario
		if(keyLeft) 
		{
			model.mario.rightFacing = false;
			model.mario.x -= 10; 
			model.mario.changeImageState();
		}  

		// Statement to control mario jumping by the spacebar
		if(spaceBar)
		{
			model.mario.checkJump();
		}
	}  
} 
