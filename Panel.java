import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
public class Panel extends JPanel implements MouseListener{
	

boolean notFirstClick = false;	
public Panel() {
	
	BufferedImage background = null;
	addMouseListener(this);
	 try{
		//we are going to make miscelanious images here
	   background = ImageIO.read(Panel.class.getResource("/GUI Images/StartScreenImage.png")); 
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }
	
	
							 
	/* This is a copyable template to use. Once everyone has learned how to use the DisplayElement Class, just delete the above demo
	 * 
	 * exampleScreen.add 
	(
			new DisplayElement(BufferedImage image,boolean clickable ,boolean displayable ,Rectangle bounds, Integer layer)
																			 
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

	TreeSet<DisplayElement> startScreen = new TreeSet<DisplayElement>(); //The screen with the start button
	TreeSet<DisplayElement> regionSelectScreen = new TreeSet<DisplayElement>();
	TreeSet<DisplayElement> biddingScreen = new TreeSet<DisplayElement>(); //Get to this screen by clicking the start button

	startScreen.add
	(
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// START BUTTON
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		new DisplayElement(null,true,true,new Rectangle(400,900,200,100),1) 
		{
			@Override  
			public void draw(Graphics2D g) 
			{
				g.setColor(Color.BLACK);
				g.fillRect(x(this.x),y(this.y),x(this.width),y(this.height));
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial",Font.BOLD,x(50)));
				g.drawString("Start", x(this.x+25), y(this.y+75));
			}
			
			public void click(MouseEvent e) //code for the start button
			{
				Manager.setGame(); 
				Manager.setCities();
				Manager.setPlayers();
				Manager.setResources();
				setScreen(biddingScreen); 
			}
		}
	);
	
	
	startScreen.add
	(
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// Background for the start screen
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		new DisplayElement(background,true,true,new Rectangle(0,0,1000,1000),0)
		{

			@Override
			public void draw(Graphics2D g) 
			{
				g.drawImage(this.i,x(this.x),y(this.y),x(this.width),y(this.height),null);	
			}

			public void click(MouseEvent e) //code for the start button
			{
				Manager.setGame();
				Manager.setCities();
				Manager.setPlayers();
				Manager.setResources();
				setScreen(regionSelectScreen); 
			}
		}
	);
	setScreen(startScreen);

	
	LinkedList<DisplayElement> listOfRegions = new LinkedList<DisplayElement>();
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// teal region			continue this pattern for the rest of the regions
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	DisplayElement tealRegion = new DisplayElement(null,true ,true ,new Rectangle(0,0,100,100), 0)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					if(clickable) 
						g.setColor(Color.green);
					else
						g.setColor(Color.red);

					g.drawRect(x(this.x),y(this.y),x(this.width),y(this.y));
				}
				
				public void click(MouseEvent e)
				{
					clickable = false;
					if(notFirstClick && listOfRegions.contains(this))
					{
				/* 		listOfRegions.add(brownRegion);  
					listOfRegions.add(redRegion);
					listOfRegions.add(yellowRegion);*/
					}	
						
					notFirstClick = true;	
					
					
				}
			};
	

/* 
	regionSelectScreen.add
	(
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// Map background
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	new DisplayElement( map ,false ,true ,new Rectangle(0,0,1000,1000), 0)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.drawimage(this.i,x(this.x),y(this.y),x(this.width).y(this.height));
				}
				
				public void click(MouseEvent e)
				{
					
				}
			}
	);
 */

	//Add all of the regions
	
	
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

	TreeSet<DisplayElement> currentScreen = new TreeSet<DisplayElement>();	
	
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
DisplayElement ptr = new DisplayElement(null,false,false,null,0);
Iterator<DisplayElement> it = currentScreen.iterator();
while(it.hasNext())
{
ptr = it.next();
if(ptr.contains(x,y))
ptr.click(e);
}

repaint();
}

public TreeSet<DisplayElement> setScreen(TreeSet<DisplayElement> in)
{
TreeSet<DisplayElement> out = currentScreen;
currentScreen = in;
return out;
}
}