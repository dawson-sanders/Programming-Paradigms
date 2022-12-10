//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: The java file holds the fireball class and is the container class
// for the fireball sprite
//----------------------------------------------------------------
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Fireball extends Sprite
{
    // Instance variables
    BufferedImage fireball_image;
    int bufferCounter = 5;

    // Fireball Constructor
    Fireball(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.w = 47;
        this.h = 47;
 
        // Lazy loading goombas
        if(fireball_image == null)
            fireball_image = View.loadImage("fireball.png");
    }

    // Method to draw fireballs in the world
    public void draw(Graphics g, int scrollPos)
    {
        g.drawImage(fireball_image, x - scrollPos, y, w, h, null);
    }

    public boolean update()
    {
        vert_velocity += 2; //this is gravity 
        y += vert_velocity; //update position vertically
        x += horizontal_velocity; //update position horizontally

        if(y > 450 - h)
        {
            horizontal_velocity = 5;
            vert_velocity = -24;
            y = 450 - h;
        }  

        return true;
    }

    public boolean isPipe()
    {
        return false;
    }

    public boolean isMario()
    {
        return false;
    }

    public boolean isGoomba()
    {
        return false;
    }

    @Override
    public boolean isFireball()
    {
        return true;
    }

    @Override 
    public String toString()
    {
        return "Fireball (x,y) = (" + x + ", " + y + "), width = " + w + ", height = " + h;
    }
}
