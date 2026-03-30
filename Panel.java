import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
public class Panel extends JPanel implements MouseListener{
	

	
public Panel() {
	
	addMouseListener(this);
	
	ArrayList<DisplayElement> exampleScreen = new ArrayList<DisplayElement>();//This is the tutorial screen
	
	exampleScreen.add // Add a displayElement to the screen we want to make
	(
			new DisplayElement(null,true,true,new Rectangle(100,100,100,100))// We set the bounds by making a new Rectangle. 
																			 // We do not scale the values going into the object
			{
				@Override //Only this object will paint and click like this 
				public void draw(Graphics2D g) //Copy the exact signature of the method from the class
				{
					g.setColor(Color.red);
					g.fillRect(x(x),y(y),x(width),y(height));//x() and y() scale the objects to the screen
				}
				
				public void click(MouseEvent e)//runs when this object is clicked and clickable==true
				{
					
					System.out.println("clicked");
					setLocation(x+100,y); //One can use variables that are from Rectangle, DisplayElement, and the Rectangle class directly
				}
			}
	);//this is the closed bracket of the .add()
	
	
	setScreen(exampleScreen);// After making the screen, we need to set the currentScreen to the one we made
							 
	/* This is a copyable template to use. Once everyone has learned how to use the DisplayElement Class, just delete the above demo
	 * 
	 * exampleScreen.add 
	(
			new DisplayElement(BufferedImage image,boolean clickable ,boolean displayable ,Rectangle bounds)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					
				}
				
				public void click(MouseEvent e)
				{
					
				}
			}
	);
	
	
	setScreen(ArrayList<DisplayElement> desired screen); 
	 * */
}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void addNotify() {
	    super.addNotify();
	    requestFocus();
	    repaint();
	}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Don't touch the code below
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	ArrayList<DisplayElement> currentScreen = new ArrayList<DisplayElement>();	
	
public void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2 = (Graphics2D) g;

for (DisplayElement d : currentScreen)
if (d.displayable)
d.draw(g2);
}
public int x(int in) { return (int)((getWidth() * in) / 1000.0); }
public int y(int in) { return (int)((getHeight() * in) / 1000.0); }

public void mouseClicked(MouseEvent e) {
int x = (int)(e.getX() * 1000.0 / getWidth());
int y = (int)(e.getY() * 1000.0 / getHeight());
DisplayElement ptr = new DisplayElement(null,false,false,null);
for(int i=0;i<currentScreen.size();i++)
{
ptr = currentScreen.get(i);
if(ptr.contains(x,y))
ptr.click(e);
}

repaint();
}

public ArrayList<DisplayElement> setScreen(ArrayList<DisplayElement> in)
{
ArrayList<DisplayElement> out = currentScreen;
currentScreen = in;
return out;
}
}