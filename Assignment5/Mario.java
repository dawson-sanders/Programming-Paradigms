//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: Container class that holds info about mario in the world 
//----------------------------------------------------------------
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Mario extends Sprite
{
    BufferedImage[] mario_images;
    int currentImage;
    int numFramesInAir = 0;
    boolean rightFacing = true;

    // Mario Constructor
    public Mario(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.w = 60;
        this.h = 95;
        mario_images = new BufferedImage[5];  
        currentImage = 0;
        
        for (int i = 0; i < mario_images.length; i++)
            mario_images[i] = View.loadImage("mario" + (i + 1) + ".png");
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

    // Method to keep track of what mario image we are at
    void changeImageState()
    {
        currentImage++;
        if(currentImage > 4)
            currentImage = 0;
    }

    public boolean update()
    {
        vert_velocity += 2; //this is gravity 
        y += vert_velocity; //update position 
        numFramesInAir++; 

        if(y > 450 - h)
        {
            y = 450 - h;
            vert_velocity = 0;
            numFramesInAir = 0;
        }    
        return true;
    }

    public void draw(Graphics g, int scrollPos)
    {
        if(rightFacing)
            g.drawImage(mario_images[currentImage], x - scrollPos, y, w, h, null);
		else
            g.drawImage(mario_images[currentImage], x - scrollPos + w, y, -w, h, null);
    }

    // Method to get mario out of pipes if he collides with them
    public void getOutOfPipeMario(Sprite pipe)
    {
        if(pipe.isPipe() == true)
        {
            // Left collision fixing
            if(x + w >= pipe.x && prev_x + w <= pipe.x)
                x = pipe.x - w;
            
            // Right collision fixing
            if(x >= pipe.x && prev_x >= pipe.x + pipe.w)
                x = pipe.x + pipe.w;
    
            // Top collision fixing
            if(prev_y + prev_h <= pipe.y)
            {
                vert_velocity = 0;
                numFramesInAir = 0;
                y = pipe.y - h;
            }

            // Bottom collision fix
            if(prev_y >= pipe.y + pipe.h) 
                y = pipe.y + pipe.h;
        }
    }

    // Method that sets marios previous position
    public void setPreviousPositionMario()
    {
        prev_x = x;
        prev_y = y;
        prev_w = w;
        prev_h = h;
    }

    // Method that allows mario to jump
    boolean checkJump()
    {
        if(numFramesInAir < 6)
        {
            vert_velocity = -28;
            return true;
        }
        else
            return false;
    }

    public boolean isPipe()
    {
        return false;
    }
    
    @Override
    public boolean isMario()
    {
        return true;
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
	    return "Mario (x,y) = (" + x + ", " + y + "), width = " + w + ", height = " + h;
    }
}    
