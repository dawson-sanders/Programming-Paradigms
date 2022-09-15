//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 9/15/22
// Description: The java file holds the Model class and is entire "window" 
// or "map" of the game and updates the moves of the turtle
//----------------------------------------------------------------
public class Model 
{
	// Member variables
    int turtle_x;
	int turtle_y;
	int dest_x;
	int dest_y;

	// Model Constructor
	Model()
	{
	}

	// Method that moves the turtle 
	public void update()
	{
		// Move the turtle
		if(this.turtle_x < this.dest_x)
			turtle_x += Math.min(4, dest_x - turtle_x); //Moves the turtle to the right 4 pixels at a time
		else if(this.turtle_x > this.dest_x)
			turtle_x -= Math.min(4, turtle_x - dest_x); //Moves the turtle to the left 4 pixels at a time
		if(this.turtle_y < this.dest_y)
			turtle_y += Math.min(4, dest_y - turtle_y); //Moves the turtle up 4 pixels at a time
		else if(this.turtle_y > this.dest_y)
			turtle_y -= Math.min(4, turtle_y - dest_y);  //Moves the turtle down 4 pixels at a time
	}

	// Method that sets the destination
	public void setDestination(int x, int y)
	{
		this.dest_x = x;
		this.dest_y = y;
	}
}
