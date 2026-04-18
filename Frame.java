import javax.swing.*;
public class Frame extends JFrame{

	public static final int WIDTH = 1600;
	public static final int HEIGHT = 960;
	public static Panel panel;
	
	public Frame(String title)
	{
		super(title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel();
		add(panel);
		setVisible(true);	
	}

	public static int x(int in)
	{
		return panel.x(in);
	}

	public static int y(int in)
	{
		return panel.y(in);
	}
}
