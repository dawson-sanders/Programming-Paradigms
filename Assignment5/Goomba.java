//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: The java file holds the Goomba class and is the container class
// for the goomba characters
//----------------------------------------------------------------
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Goomba extends Sprite
{
    // Instance variables
    BufferedImage goomba_image, goombafire_image;
    int onFireCounter = 47;
    boolean isOnFire = false;

     // Goomba Constructor
    Goomba(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.w = 45;
        this.h = 37;
 
        // Lazy loading goombas
        if(goomba_image == null)
            goomba_image = View.loadImage("goomba.png");
        if(goombafire_image == null)
            goombafire_image = View.loadImage("goomba_fire.png");
    }

    // Unmarshaling Constructor
    public Goomba(Json ob)
    {
        x = (int)ob.getLong("x");
        y = (int)ob.getLong("y");
        w = 45;
        h = 37;
        if(goomba_image == null)
            goomba_image = View.loadImage("goomba.png");
        if(goombafire_image == null)
            goombafire_image = View.loadImage("goomba_fire.png");
    }

    // Method that marshals object into a JSON node
    public Json marshal()
    {
        Json ob = Json.newObject();
        ob.add("x", x);
        ob.add("y", y);
        ob.add("w", w);
        ob.add("h", h);
        return ob;
    }

    // Method to draw goombas in the world
    public void draw(Graphics g, int scrollPos)
    {
        if(!isOnFire)
            g.drawImage(goomba_image, x - scrollPos, y, w, h, null);
        else
            g.drawImage(goombafire_image, x - scrollPos, y, w, h, null);
    }

    // Method to update Goomba in the world
    public boolean update()
    {
        if(isOnFire == false)
        {
            setPreviousPositionGoomba();
            x += horizontal_velocity; //update position horizontally
            vert_velocity += 1; //this is gravity 
            y += vert_velocity; //update position vertically
    
            if(y > 450 - h)
            {
                y = 450 - h;
                vert_velocity = 0;
            }  
        }

        if(isOnFire == true)
        {
            onFireCounter -= 1;
        }

        if(onFireCounter <= 0) 
        {
            horizontal_velocity = 0;
            return false;
        }

        return true;
    }
    
    public void changeDirection()
    {
        horizontal_velocity *= -1;
    }

    // Method to get goombas out of pipes if they collide with them
    public void getOutOfPipeGoomba(Sprite pipe) 
    {
        if(pipe.isPipe() == true)
        {
            // Left collision fixing
            if(x + w >= pipe.x && prev_x + w <= pipe.x)
                x = pipe.x - w;
    
            // Right collision fixing
            if(x <= pipe.x + pipe.w && prev_x >= pipe.x + pipe.w)
                x = pipe.x + pipe.w;
        
           // Top collision fixing
           if(prev_y <= pipe.y)
           {
               vert_velocity = 0;
               horizontal_velocity = -2;
               y = pipe.y - h;
           }
        }
    }

    // Method that sets goombas previous position
    public void setPreviousPositionGoomba()
    {
        prev_x = x;
        prev_y = y;
        prev_w = w;
        prev_h = h;
    }

    public boolean isPipe()
    {
        return false;
    }

    public boolean isMario()
    {
        return false;
    }

    @Override
    public boolean isGoomba()
    {
        return true;
    }

    public boolean isFireball()
    {
        return false;
    }

    @Override 
    public String toString()
    {
        return "Goomba (x,y) = (" + x + ", " + y + "), width = " + w + ", height = " + h;
    }
}
