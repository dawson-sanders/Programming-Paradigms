//---------------------------------------------------------------
// Name: Dawson Sanders
// Date: 10/31/22
// Description: This java file holds the Model class and is the entire "window" 
// or "map" of the game 
//----------------------------------------------------------------
import java.util.ArrayList;

public class Model 
{
	// Member variables/Instance variables
	ArrayList<Sprite> sprites;
	Mario mario;

	// Model Constructor
	Model()
	{
		sprites = new ArrayList<Sprite>();
		mario = new Mario(100, 355);
	}

	// Method that adds/removes pipes depending on where the user clicks
	public void addPipe(int x, int y)
	{
		boolean foundPipe = false;
		for(int i = 0; i < sprites.size(); i++)
		{
			if(sprites.get(i).isPipe())
			{
				if(sprites.get(i).detectSprite(x,y) == true)
				{
					foundPipe = true;
					sprites.remove(i);
				}
			}
		} 
		if(!foundPipe)  
			sprites.add(new Pipe(x,y));
	}

	// Method that adds/removes goombas depending on where the user clicks
	public void addGoomba(int x, int y)
	{
		boolean foundGoomba = false;
		for(int i = 0; i < sprites.size(); i++)
		{
			if(sprites.get(i).isGoomba())
			{
				if(sprites.get(i).detectSprite(x,y) == true)
				{
					foundGoomba = true;
					sprites.remove(i);
				}
			}
		} 
		if(!foundGoomba)  
			sprites.add(new Goomba(x,y));
	}

	// Method that adds/removes goombas depending on where the user clicks
	public void addFireball(int x, int y)
	{
		sprites.add(new Fireball(x,y));
	}

	// Method that marshals object to into a JSON node
	public Json marshal()
	{
		Json ob = Json.newObject();
		Json tmpListPipes = Json.newList();
		ob.add("pipes", tmpListPipes);
		Json tmpListGoombas = Json.newList();
		ob.add("goombas", tmpListGoombas);
		for(int i = 0; i < sprites.size(); i++)
		{
			if (sprites.get(i).isPipe())
				tmpListPipes.add(((Pipe)sprites.get(i)).marshal()); //downcasting pipes
			if (sprites.get(i).isGoomba())
				tmpListGoombas.add(((Goomba)sprites.get(i)).marshal()); //downcasting goombas
		}
        return ob;
	}

	// Unmarshaling constructor
	public void unmarshal(Json ob)
	{
		sprites = new ArrayList<Sprite>();
		sprites.add(mario);
		Json tmpListPipes = ob.get("pipes");
		Json tmpListGoombas = ob.get("goombas");
		for(int i = 0; i < tmpListPipes.size(); i++)
			sprites.add(new Pipe(tmpListPipes.get(i)));
		for(int i = 0; i < tmpListGoombas.size(); i++)
			sprites.add(new Goomba(tmpListGoombas.get(i)));
	}
 
	public void update()
	{
		// Loop through pipes/goombas/fireballs to check if there was a collision
		for(int i = 0; i < sprites.size(); i++)
		{
			if (sprites.get(i).update() == false) 
			{
				sprites.remove(i); 
				break;
			}

			sprites.get(i).update();
			boolean checkMarioCollision = isThereACollision(sprites.get(i), mario);
			if(checkMarioCollision == true)
				mario.getOutOfPipeMario(sprites.get(i));
			
			if(sprites.get(i).isGoomba())
			{ 
				for(int j = 0; j < sprites.size(); j++)
				{
					if(sprites.get(j).isPipe())
					{
						if(isThereACollision((sprites.get(i)), sprites.get(j)))
						{
							((Goomba)sprites.get(i)).getOutOfPipeGoomba(sprites.get(j));
							((Goomba)sprites.get(i)).changeDirection();
						}	
						
						for(int k = 0; k < sprites.size(); k++)
						{
							if(sprites.get(k).isFireball())
							{
								if(isThereACollision((sprites.get(i)), sprites.get(k)))
									((Goomba)sprites.get(i)).isOnFire = true;	
							}
						}
					}
				}
			}
		}	
	} 

	public boolean isThereACollision(Sprite a, Sprite b)
	{
		// If sprite is not colliding 
		if(a.x + a.w < b.x) 
			return false;
		if(a.x > b.x + b.w)
			return false;
		if(a.y + a.h < b.y)
			return false;
		if(a.y > b.y + b.h)
			return false;
		
		// If sprite is NOT not colliding ---> meaning he is colliding
		return true;
	}
}
