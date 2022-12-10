//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: The java file holds the Game class and is the driver of the game.
//----------------------------------------------------------------
import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	//Memeber variables
	Model model;
	View view;
	Controller controller;

	public Game()
	{
		model = new Model();
		controller = new Controller(model);
		view = new View(controller, model);
		this.setTitle("A5 - Side Scroller");
		this.setSize(500, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		view.addMouseListener(controller);
		this.addKeyListener(controller);
	}

	// Method that runs the game
 	public void run()
	{
		// Loads the previous saved map into the game once game starts
		Json j = Json.load("map.json");
		model.unmarshal(j);

		while(true)
		{
			controller.update();
			model.update();
			view.repaint(); // Indirectly calls View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for 40 milliseconds
			try
			{
				Thread.sleep(40);
			} 	
			catch(Exception e) 
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
	} 

	// Main Method
	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
}



