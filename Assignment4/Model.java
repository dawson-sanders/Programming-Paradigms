//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/13/22
// Description: This java file holds the Model class and is the entire "window" 
// or "map" of the game 
//----------------------------------------------------------------
import java.util.ArrayList;

public class Model 
{
	// Member variables/Instance variables
	ArrayList<Pipe> pipes;
	Mario mario;

	// Model Constructor
	Model()
	{
		pipes = new ArrayList<Pipe>();
		mario = new Mario(100, 355);
	}

	// Method that adds/removes pipes depending on where the user clicks
	public void addPipe(int x, int y)
	{
		boolean foundPipe = false;
		
		for(int i = 0; i < pipes.size(); i++)
		{
			if(pipes.get(i).detectPipe(x,y) == true) //this means there is a pipe where I clicked
			{
				foundPipe = true;
				pipes.remove(i);
			}
		} 

		if(!foundPipe)  
			pipes.add(new Pipe(x,y));  
		}

	// Method that marshals object to into a JSON node
	Json marshal()
	{
		Json ob = Json.newObject();
		Json tmpList = Json.newList();
		ob.add("pipes", tmpList);
		for(int i = 0; i < pipes.size(); i++)
			tmpList.add(pipes.get(i).marshal());
        return ob;
	}

	// Unmarshaling constructor
	void unmarshal(Json ob)
	{
		pipes = new ArrayList<Pipe>();
		Json tmpList = ob.get("pipes");
		for(int i = 0; i < tmpList.size(); i++)
			pipes.add(new Pipe(tmpList.get(i)));
	}
 
	public void update()
	{
		mario.update();

		// Loop through pipes to check if there was a collision
		for(int i = 0; i < pipes.size(); i++)
		{
			if(isThereACollision(pipes.get(i)))
			{
				// Calling getoutofpipe method in case there was a collsion
				mario.getOutOfPipe(pipes.get(i));
			}
		}
	} 

	// Method to detect if there is a collision between mario and a pipe
	boolean isThereACollision(Pipe p)
	{
		// If he is not colliding 
		if(mario.x + mario.w < p.x) 
			return false;
		if(mario.x > p.x + p.w)
			return false;
		if(mario.y + mario.h < p.y)
			return false;
		if(mario.y > p.y + p.h)
			return false;
		
		// If he is NOT not colliding ---> meaning he is colliding
		return true;
	} 
}
