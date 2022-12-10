//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: Container class that holds info about the pipes in the world
//----------------------------------------------------------------
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Pipe extends Sprite
{
    //Memeber variables/instance variables
    BufferedImage pipe_image;

    // Pipe Constructor
	Pipe(int x, int y)
	{
        this.x = x;
        this.y = y;
        this.w = 55;
        this.h = 400;

        // Lazy loading pipes
        if(pipe_image == null)
            pipe_image = View.loadImage("pipe.png");
	}

    // Method that marshals object to into a JSON node
    public Json marshal()
    {
        Json ob = Json.newObject();
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);

        return ob;
    }

    // Unmarshaling Constructor
    public Pipe(Json ob)
    {
        x = (int)ob.getLong("x");
        y = (int)ob.getLong("y");
        w = 55;
        h = 400;
        if(pipe_image == null)
            pipe_image = View.loadImage("pipe.png");
    }

    // Method to draw pipes in the world
    public void draw(Graphics g, int scroll)
    {
        g.drawImage(pipe_image, x - scroll, y, w, h, null);
    }

    public boolean update()
    {
        return true;
    }

    @Override
    public boolean isPipe()
    {
        return true;
    }
    
    public boolean isMario()
    {
        return false;
    }

    public boolean isGoomba()
    {
        return false;
    }

    public boolean isFireball()
    {
        return false;
    }

    @Override 
    public String toString()
    {
	    return "Pipe (x,y) = (" + x + ", " + y + "), width = " + w + ", height = " + h;
    }
}