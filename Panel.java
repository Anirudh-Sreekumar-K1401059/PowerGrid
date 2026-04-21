import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
public class Panel extends JPanel implements MouseListener{
	
public static int scaleX, scaleY;
boolean notFirstClick = false, firstRound = true;
Iterator<Player> playerIterator, secondaryPlayerIterator;
LinkedList<DisplayElement> listOfRegions = new LinkedList<DisplayElement>();
LinkedList<String> activeRegions = new LinkedList<String>();
String bidInpuString = "weed eater";
boolean autoPass = false;
int j=1;


DisplayElement tealRegion;
DisplayElement redRegion;
DisplayElement brownRegion;
DisplayElement yellowRegion;
DisplayElement blueRegion;
DisplayElement purpleRegion;

TreeSet<DisplayElement> startScreen = new TreeSet<DisplayElement>(); //The screen with the start button
TreeSet<DisplayElement> regionSelectScreen = new TreeSet<DisplayElement>(); //Get to this screen by clicking the start button
TreeSet<DisplayElement> biddingScreen = new TreeSet<DisplayElement>(); //Get to this screen by having 4 passes in a row
TreeSet<DisplayElement> replacePlantScreen = new TreeSet<DisplayElement>(); //Screen that replaces the Player's powerplants

public Panel() {
	
	BufferedImage background = null;
	BufferedImage map = null;
	addMouseListener(this);
	 try{
		//we are going to make miscelanious images here
	   background = ImageIO.read(Panel.class.getResource("/GUI Images/StartScreenImage.png")); 
	   map = ImageIO.read(Panel.class.getResource("/GUI Images/Map.png"));
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }
	
	
							 
	/* This is a copyable template to use.
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

	DisplayElement currentPlayer = new DisplayElement(null,false ,true,new Rectangle(10,0,200,50), 1)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.drawString("Current Player: "+Manager.currPlayer.getColor(),x(this.x),y(this.y));
				}
				
			};

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
				//Add setup code here
				Manager.setGame();
				setScreen(biddingScreen); 
				playerIterator = Manager.playerOrder.iterator();
				secondaryPlayerIterator = Manager.playerOrder.iterator();
				Manager.currPlayer = secondaryPlayerIterator.next();
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

		}
	);
	setScreen(startScreen);

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// teal region			continue this pattern for the rest of the regions
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	tealRegion = new DisplayElement(null,true ,true ,new Rectangle(0,0,100,100), 0)
																			 
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
					if((notFirstClick || listOfRegions.contains(this))&& playerIterator.hasNext())
					{
						playerIterator.next();
				listOfRegions.add(brownRegion);  
					listOfRegions.add(redRegion);
					listOfRegions.add(yellowRegion);
					activeRegions.add("teal");
					}	

					if(!playerIterator.hasNext())
					{
						Manager.setCities(activeRegions);
						setScreen(regionSelectScreen);
						playerIterator = Manager.playerOrder.iterator();
					}	
					notFirstClick = true;	
					
					
				}
			};
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// red region			continue this pattern for the rest of the regions
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	redRegion = new DisplayElement(null,true ,true ,new Rectangle(100,100,100,100), 0)
																			 
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
					if((notFirstClick || listOfRegions.contains(this))&& playerIterator.hasNext())
					{
				 		listOfRegions.add(tealRegion);  
					listOfRegions.add(yellowRegion);
					listOfRegions.add(blueRegion);
					activeRegions.add("red");
					
					}	
						if(!playerIterator.hasNext())
					{
						Manager.setCities(activeRegions);
					}	
					notFirstClick = true;	
					
					
				}
			};

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// brown region			continue this pattern for the rest of the regions
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	brownRegion = new DisplayElement(null,true ,true ,new Rectangle(200,200,100,100), 0)
																			 
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
					if((notFirstClick || listOfRegions.contains(this))&& playerIterator.hasNext())
					{
					listOfRegions.add(tealRegion);  
					listOfRegions.add(yellowRegion);
					activeRegions.add("brown");
					
					}	
						if(!playerIterator.hasNext())
					{
						Manager.setCities(activeRegions);
					}	
					notFirstClick = true;	
					
					
				}
			};

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// yellow region			continue this pattern for the rest of the regions
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	yellowRegion = new DisplayElement(null,true ,true ,new Rectangle(400,400,100,100), 0)
																			 
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
					if((notFirstClick || listOfRegions.contains(this))&& playerIterator.hasNext())
					{
						listOfRegions.add(tealRegion);  
					listOfRegions.add(redRegion);
					listOfRegions.add(blueRegion);
					listOfRegions.add(brownRegion);
					listOfRegions.add(purpleRegion);
					activeRegions.add("yellow");
					
					}	
						if(!playerIterator.hasNext())
					{
						Manager.setCities(activeRegions);
					}	
					notFirstClick = true;	
					
					
				}
			};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// blue region			continue this pattern for the rest of the regions
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	blueRegion = new DisplayElement(null,true ,true ,new Rectangle(500,500,100,100), 0)
																			 
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
					if((notFirstClick || listOfRegions.contains(this))&& playerIterator.hasNext())
					{
						listOfRegions.add(yellowRegion);  
					listOfRegions.add(redRegion);
					listOfRegions.add(purpleRegion);
					activeRegions.add("blue");
					
					}	
						if(!playerIterator.hasNext())
					{
						Manager.setCities(activeRegions);
					}	
					notFirstClick = true;	
					
					
				}
			};

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// purple region			continue this pattern for the rest of the regions
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	purpleRegion = new DisplayElement(null,true ,true ,new Rectangle(600,600,100,100), 0)
																			 
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
					if((notFirstClick || listOfRegions.contains(this))&& playerIterator.hasNext())
					{
						listOfRegions.add(yellowRegion);  
					listOfRegions.add(blueRegion);
					activeRegions.add("purple");
					
					}	
					if(!playerIterator.hasNext())
					{
						Manager.setCities(activeRegions);
					}	
					notFirstClick = true;	
					
					
				}
			};

	regionSelectScreen.add
	(
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// Map background
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	new DisplayElement( map ,false ,true ,new Rectangle(0,0,1000,1000), -1)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.drawImage(this.i,x(this.x),y(this.y),x(this.width),y(this.height),null);
				}
				
				public void click(MouseEvent e)
				{
					playerIterator.next();
				}
			}
	);
 
	regionSelectScreen.addAll(Arrays.asList(tealRegion,redRegion,brownRegion,yellowRegion,blueRegion,purpleRegion));
	
	
	//Add all of the regions
	
	/*  
				public void draw(Graphics2D g) 
				{
					g.rotate(Math.toRadians(90), x(this.x + this.width/2), y(this.y + this.height/2));
					g.drawImage(this.i,x(this.x),y(this.y),x(this.width),y(this.height),null);
				}
			*/
	
	DisplayElement passButton = new DisplayElement(null,true ,true ,new Rectangle(300,800,200,100),1)
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// Pass button
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////													 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.setColor(Color.BLACK);
				g.fillRect(x(this.x),y(this.y),x(this.width),y(this.height));
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial",Font.BOLD,x(50)));
				g.drawString("Pass", x(this.x+25), y(this.y+75));
				
				//this.clickable = true;
				if(Manager.currPlayer.pass) {autoPass = true; this.click(null);}
				
				}

				public void click(MouseEvent e)
				{
					Manager.bid(0);//make sure that numpasses does not get handled in Manager
					if(!autoPass) Manager.numPasses++;	autoPass = false;
					Manager.currPlayer.pass = true;
					
					if(Manager.numPasses > 2 )
					{
						if(Manager.currPlayer.getMyPlants().size()>2)
							setScreen(replacePlantScreen);
						else
							Manager.highestBidder.getMyPlants().add(Manager.currentAuctionPlant);
						Manager.highestBidder.canChooseAuctionPlant = false;
						
						Manager.updateMarket();
						Manager.currentAuctionPlant = null;

						int i=0;
						for(Player p : Manager.playerOrder)
						{
							p.pass = false;
							if(!p.canChooseAuctionPlant) i++;
						}
						Manager.highestBidder.pass = true;
						Manager.cost = 0;
						Manager.highestBidder = null;
						Manager.numPasses = i;
						Manager.highestBidder.updateElektros(-Manager.cost);
						Manager.highestBidder = null;
						Manager.currPlayer = secondaryPlayerIterator.next();
						playerIterator = Manager.playerOrder.listIterator(Manager.playerOrder.indexOf(Manager.currPlayer));
					
						
						if((firstRound&&i==Manager.playerOrder.size())||(Manager.numPasses==4))
						{ 
							if(firstRound) Manager.determineOrder();
							setScreen(Manager.playerOrder.get(0).playerScreen);
							for(Player p : Manager.playerOrder) p.canChooseAuctionPlant = true;
							Manager.numPasses = 0; 
							

						}
						
					return;
					} //player with the highest bid earns the next power plant, and if no player can choose plant for auction, move on
					if(playerIterator.hasNext())
					Manager.currPlayer = playerIterator.next();
					else
					playerIterator = Manager.playerOrder.iterator();
				
				}
			};
	biddingScreen.add(passButton);

	
	biddingScreen.add 
	(
			new DisplayElement(null,false ,true ,new Rectangle(300,600,200,100),1)
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// Bid button
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////													 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
				g.setColor(Color.BLACK);
				g.fillRect(x(this.x),y(this.y),x(this.width),y(this.height));
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial",Font.BOLD,x(50)));
				g.drawString("Bid", x(this.x+25), y(this.y+75));

				for(DisplayElement d : Manager.powerPlantMarket) if(d.displayable) d.draw(g);
				this.clickable = Manager.currentAuctionPlant!=null;

				}

				public void click(MouseEvent e)
				{
					boolean validBid = true;
					while(!bidInpuString.matches("\\d+")&&validBid)
					{
					bidInpuString = JOptionPane.showInputDialog("How much are you bidding?");
					validBid = Manager.bid(Integer.decode(bidInpuString));	
					}
					bidInpuString = "weed eater";
					if(Manager.highestBidder!=Manager.currPlayer) return;
					if(playerIterator.hasNext())
					Manager.currPlayer = playerIterator.next();
					else
					playerIterator = Manager.playerOrder.iterator();

				}
			}
	);

	DisplayElement sideMap = new DisplayElement(map,false,true ,new Rectangle(300,0,700,1000), 1)														 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.rotate(Math.toRadians(90), x(this.x + this.width/2), y(this.y + this.height/2));
					g.drawImage(this.i,x(this.x),y(this.y),x(this.width),y(this.height),null);
				}
				
				public void click(MouseEvent e)
				{
					
				}
			};

	
		
	while(j<4)
	{
		replacePlantScreen.add 
	(
			new DisplayElement(null,true ,true,new Rectangle(j*250,450,100,100), j++)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					i = Manager.currPlayer.getMyPlants().get(layer).i;
					g.drawImage(i,x(this.x),y(this.y),null);
				}
				
				public void click(MouseEvent e)
				{
					Manager.highestBidder.getMyPlants().set(layer,Manager.currentAuctionPlant);
					setScreen(biddingScreen);
				}
			}
	);

		Manager.playerOrder.get(j).playerScreen.add 
	(
			new DisplayElement(null,true ,true,new Rectangle(60,0,0,0), j++)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.drawString("Phase: "+Manager.phase+"\nStep: "+Manager.step+"\nElectro: "+Manager.currPlayer.getElektros()+"\n\tPowerplants:/n/n/n/n/n/nResources:",x(this.x),y(this.y));
				}
				
			}
	);

	}
	replacePlantScreen.add 
	(
			new DisplayElement(null,false ,true,new Rectangle(450,20,0,0), 1)
																			 
			{
				@Override  
				public void draw(Graphics2D g) 
				{
					g.drawString("REPLACE POWER PLANT",x(this.x),y(this.y));
				}
				
			}
	);
	

	

	/*
	To do list: 
		
		4. Manager
			4.1 make int currentBid
		5. Create the Player Screens
	*/
	
	
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
{
ptr.click(e);
System.out.println(ptr+" "+x+" "+y);
}
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