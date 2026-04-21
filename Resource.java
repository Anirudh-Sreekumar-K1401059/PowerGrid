import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Resource extends DisplayElement 
{

    public Type type;
	public String location;
	Resource(Type type)
	{
		super(null,false,true,new Rectangle(0,0,20,20),2);
		this.type = type;
	}

	public void draw(Graphics2D g)
	{
		switch (type)
		{
            case COAL:
                g.setColor(new Color(107,62,10));//brown
            case OIL:
                g.setColor(Color.BLACK);
            case GARBAGE:
                g.setColor(Color.YELLOW);
            case URANIUM:
                g.setColor(Color.RED);
        }

		g.fillOval(Frame.panel.x(x),Frame.panel.y(y),Frame.panel.x(width),Frame.panel.y(height));	
	}

	
	
	
	
}
