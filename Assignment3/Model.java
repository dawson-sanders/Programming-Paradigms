//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 9/29/22
// Description: This java file holds the Model class and is the entire "window" 
// or "map" of the game 
//----------------------------------------------------------------
import java.util.ArrayList; // import the ArrayList class

public class Model 
{
	// Member variables
	ArrayList<Pipe> pipes;

	// Model Constructor
	Model()
	{
		pipes = new ArrayList<Pipe>();
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
 
	/*public void update()
	{
	} */

}
