//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 9/29/22
// Description: The java file holds the View class and is the window 
// that the user is currently looking at and sees
//----------------------------------------------------------------
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;

class View extends JPanel
{
	//Member variables
	BufferedImage pipe_image;
	Model model;
	int scrollPos;

	// View Constructor 
	View(Controller c, Model m)
	{
		c.setView(this);
		model = m; //initializing reference variable m
		//scrollPos = 0; not strictly necessary to set this variable in java but like in C++ this is necessary
		
		// Reads pipe image into a memory slot
		try
		{
    		this.pipe_image = ImageIO.read(new File("pipe.png"));
		}		
		catch(Exception e) 
		{
    		e.printStackTrace(System.err);
    		System.exit(1);
		}
	}

	// Method that paints the background of the window cyan blue and draws the pipes 
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());

		for(int i = 0; i < model.pipes.size(); i++)
		{
			Pipe p = model.pipes.get(i);
			g.drawImage(pipe_image, p.x - scrollPos, p.y, p.w, p.h, null);	
		} 
	}	
}
