import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.*;


public class DisplayElement extends Rectangle implements Comparable<DisplayElement>
 {
	
protected BufferedImage i;
protected boolean clickable,displayable;
protected Integer layer;
public DisplayElement()
{
	super(new Rectangle());
	i = null;
	clickable = false;
	displayable = false;
	layer = 0;
}


public DisplayElement(BufferedImage image, boolean clickable, boolean displayable,Rectangle bound, Integer layer) {
	super(bound != null ? bound : new Rectangle());
setImage(image);
setClickable(clickable);
setDisplayable(displayable);
}
	
public void click(MouseEvent e)
{
	 
}

public void draw(Graphics2D g)
 {
	if(i==null)
	 g.drawString("Make sure to use @Override in Panel",(int)this.getX(),(int)this.getY());
	else
		g.drawImage(i,x,y,width,height, null);
 }


public BufferedImage getImage() {
	return i;
}

public void setImage(BufferedImage i) {
	this.i = i;
}

public boolean getClickable() {
	return clickable;
}

public void setClickable(boolean c) {
	this.clickable = c;
}

public boolean getDisplayable() {
	return displayable;
}

public void setDisplayable(boolean d) {
	this.displayable = d;
}



public String toString()
{
	return " clickable: "+clickable+" displayable: "+displayable+" "+super.toString();
}

public Integer getLayer()
{
	if(layer!=null)
		return layer;
	else
	return -1;
}
public void setLayer(Integer layer)
{
	this.layer = layer;
}
@Override
public int compareTo(DisplayElement o) {
	return this.getLayer().compareTo(o.getLayer());
}

/*public boolean equals(DisplayElement o)
{
	return this.intersects(o);
		
}


public int compareTo(DisplayElement o) {
	//if(this.intersects(o))
	//	return 0;
	//else 
		if(this.getCenterX()+(this.getCenterY()/1000)<o.getCenterX()+(o.getCenterY()/1000))
		return 1;
	return -1;
}*/
}
