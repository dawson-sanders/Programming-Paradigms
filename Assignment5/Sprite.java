//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: This java file holds the abstact sprite class that updates information
// about the different sprites in the game. This is essentially a super class of the 
// charcaters/images in the game
//----------------------------------------------------------------
import java.awt.Graphics;

public abstract class Sprite 
{
    // Member variables
    int x, y, w, h, prev_x, prev_y, prev_w, prev_h;
    double vert_velocity = 1.2;
    double horizontal_velocity = 2.0;

    // Decalring abstract methods
    public abstract boolean update();
    public abstract void draw(Graphics g, int scrollPos);


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

    public boolean isFireball()
    {
        return false;
    }

    // Detects if user is clicking on a pipe or a goomba
    boolean detectSprite(int mouseX, int mouseY)
    {
        if(mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h) 
            return true;
        else       
            return false;    
    } 

    @Override 
    public String toString()
    {
        return "Sprite (x,y) = (" + x + ", " + y + "), width = " + w + ", height = " + h;
    }
}
