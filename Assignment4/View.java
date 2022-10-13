//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/13/22
// Description: The java file holds the View class and is the window 
// that the user is currently looking at and sees
//----------------------------------------------------------------
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.util.Iterator;

class View extends JPanel
{
	//Member variables
	Model model;
	int scrollPos;

	// View Constructor 
	View(Controller c, Model m)
	{
		c.setView(this);
		model = m; //initializing reference variable m
	}

	// Method that loads images 
	static BufferedImage loadImage(String filename)
	{
		BufferedImage im = null;

		try
		{
    		im = ImageIO.read(new File(filename));
		}		
		catch(Exception e) 
		{
    		e.printStackTrace(System.err);
    		System.exit(1);
		}
		return im;
	}

	// Method that paints the background of the window cyan blue and draws pipes and mario
	public void paintComponent(Graphics g)
	{
		scrollPos = model.mario.x - 100;
		g.setColor(new Color(128, 255, 255));
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.gray);
		g.drawLine(0, 450, 2000, 450);
		
		// Loop that iterates over the arraylist of pipes and loads them into memory
		for(int i = 0; i < model.pipes.size(); i++)
		{
			Iterator<Pipe> itr = model.pipes.iterator();
			if(itr.hasNext())
				model.pipes.get(i).drawPipe(g, scrollPos);
		}

		// Statement to draw mario depending on which direction he is facing
		if(model.mario.rightFacing)
			g.drawImage(model.mario.mario_images[model.mario.currentImage], model.mario.x - scrollPos, model.mario.y, model.mario.w, model.mario.h, null);
		else
			g.drawImage(model.mario.mario_images[model.mario.currentImage], model.mario.x - scrollPos + model.mario.w, model.mario.y, -model.mario.w, model.mario.h, null);	
	}	
}
