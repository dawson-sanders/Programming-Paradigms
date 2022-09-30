//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 9/29/22
// Description: Container class that holds info about the pipes in the world
//----------------------------------------------------------------
public class Pipe 
{
    //Memeber variables/instance variables
    int x;
    int y;
    int w;
    int h;

    // Pipe Constructor
	Pipe(int x, int y)
	{
       this.x = x;
       this.y = y;
       this.w = 55;
       this.h = 400;
	}

    // Detects if user is clicking on a pipe
    boolean detectPipe(int mouseX, int mouseY)
    {
        // Note: in graphics positive y goes down the screen
        if(mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h) 
            return true;
        else       
            return false;    
    } 

    // Method that marshals object to into a JSON node
    Json marshal()
    {
        Json ob = Json.newObject();
        ob.add("x", x);
        ob.add("y", y);
        return ob;
    }

    // Unmarshaling Constructor
    public Pipe(Json ob)
    {
        x = (int)ob.getLong("x");
        y = (int)ob.getLong("y");
        w = 55;
        h = 400;
    }

}
