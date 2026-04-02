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
	 try{
		//we are going to make miscelanious images here
	     
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }
	
	
							 
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

	ArrayList<DisplayElement> startScreen = new ArrayList<DisplayElement>(); //The screen with the start button
	ArrayList<DisplayElement> biddingScreen = new ArrayList<DisplayElement>(); //Get to this screen by clicking the start button
	startScreen.add
	(
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// START BUTTON
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		new DisplayElement(null,true,true,new Rectangle(400,400,200,100))
		{
			@Override  
			public void draw(Graphics2D g) 
			{
				g.setColor(Color.BLUE);
				g.fillRect(x(400),y(400),x(200),y(100));
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial",Font.BOLD,x(50)));
				g.drawString("Start", x(425), y(475));
			}
			
			public void click(MouseEvent e) //code for the start button
			{
				
				setScreen(biddingScreen); 
			}
		}
	);
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