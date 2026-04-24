import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

public class Resource extends DisplayElement 
{

    public Type type;
	public String location;
	Resource(Type type)
	{
		super(null,false,true,new Rectangle(0,0,20,20),2);
		this.type = type;
	}

	Resource(Type type,BufferedImage i, boolean c, boolean d, Rectangle bounds, Integer l)
	{
		super(i,c,d,bounds,l);
		this.type = type;
	}

	public void draw(Graphics2D g)
	{
		switch (type)
		{
            case Type.COAL:
                g.setColor(new Color(107,62,10));//brown
            case Type.OIL:
                g.setColor(Color.BLACK);
            case Type.GARBAGE:
                g.setColor(Color.YELLOW);
            case Type.URANIUM:
                g.setColor(Color.RED);
        }

		g.fillOval(Frame.panel.x(x),Frame.panel.y(y),Frame.panel.x(width),Frame.panel.y(height));	
	}

	public void click(MouseEvent e)
	{
		boolean validBid = true;
		String inputString = "weed eater";
					while(!inputString.matches("\\d+")&&validBid)
					{
					inputString = JOptionPane.showInputDialog("How much "+type.toString()+" are you buying?");
					validBid = Manager.purchaseRes(type,Integer.decode(inputString));	
					}
		
	}
	
}
