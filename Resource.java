
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
			resources.put("COAL", Type.COAL);
			resources.put("OIL", Type.OIL);
			resources.put("TRASH", Type.TRASH);
			resources.put("URANIUM", Type.URANIUM);
		}

		if (reverseResources.size() == 0)
		{
			reverseResources.put(Type.COAL, "COAL");
			reverseResources.put(Type.OIL, "OIL");
			reverseResources.put(Type.TRASH, "TRASH");
			reverseResources.put(Type.URANIUM, "URANIUM");
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
		if(type.equals(Type.OIL))
			try {
				return ImageIO.read(getClass().getResource("/img/oil.png")); //gotta download an oil image
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(type.equals(Type.TRASH))
			try {
				return ImageIO.read(getClass().getResource("/img/trash.png")); //gotta download a trash image
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(type.equals(Type.COAL))
			try {
				return ImageIO.read(getClass().getResource("/img/coal.png")); //gotta download a coal image
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(type.equals(Type.URANIUM))
			try {
				return ImageIO.read(getClass().getResource("/img/uranium.png")); //gotta download an uranium image
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
}
