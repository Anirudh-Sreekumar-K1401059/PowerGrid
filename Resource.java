
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Resource 
{
	private Type type;
	private HashMap <String, Type> resources = new HashMap <String, Type> ();
	private HashMap <Type, String> reverseResources = new HashMap <Type, String> ();

	public Resource (String t)
	{
		if (resources.size() == 0)
		{
			resources.put("COAL", Type.Coal);
			resources.put("OIL", Type.Oil);
			resources.put("TRASH", Type.Trash);
			resources.put("URANIUM", Type.Uranium);
		}

		if (reverseResources.size() == 0)
		{
			reverseResources.put(Type.Coal, "COAL");
			reverseResources.put(Type.Oil, "OIL");
			reverseResources.put(Type.Trash, "TRASH");
			reverseResources.put(Type.Uranium, "URANIUM");
		}
		
		type = resources.get(t);
	}
	
	public Type getType ()
	{
		return type;
	}
	
	public String toString ()
	{
		return reverseResources.get(type);
	}
	public BufferedImage getPic()
	{
		if(type.equals(Type.Oil))
			try {
				return ImageIO.read(getClass().getResource("/img/oil.png")); //gotta download an oil image
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(type.equals(Type.Trash))
			try {
				return ImageIO.read(getClass().getResource("/img/trash.png")); //gotta download a trash image
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(type.equals(Type.Coal))
			try {
				return ImageIO.read(getClass().getResource("/img/coal.png")); //gotta download a coal image
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(type.equals(Type.Uranium))
			try {
				return ImageIO.read(getClass().getResource("/img/uranium.png")); //gotta download an uranium image
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
}
