//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 9/15/22
// Description: The java file holds the View class and is the window 
// that the user is currently looking at and sees
//----------------------------------------------------------------
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	//Member variables
	JButton b1;
	BufferedImage turtle_image;
	Model model;

	// View Constructor 
	View(Controller c, Model m)
	{
		b1 = new JButton("Don't push me");
		b1.addActionListener(c);
		this.add(b1);
		c.setView(this);
		model = m; //initializing reference variable m

		try
		{
    		this.turtle_image = ImageIO.read(new File("turtle.png"));
		}		
		
		catch(Exception e) 
		{
    		e.printStackTrace(System.err);
    		System.exit(1);
		}
	}

	// Method that removes the button once it is pressed
	void removeButton()
	{
    	this.remove(b1);
    	this.repaint();
	}

	// Method that paints the background of the window cyan blue 
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.turtle_image, model.turtle_x, model.turtle_y, null);
	}	
}
