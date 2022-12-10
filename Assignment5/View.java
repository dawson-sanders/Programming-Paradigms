//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
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
		for(int i = 0; i < model.sprites.size(); i++)
		{
			Iterator<Sprite> itr = model.sprites.iterator();
			if(itr.hasNext())
				model.sprites.get(i).draw(g, scrollPos);
		}
	}	
}

