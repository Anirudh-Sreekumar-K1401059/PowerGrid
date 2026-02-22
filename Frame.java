import javax.swing.*;
public class Frame extends JFrame{

	public static final int WIDTH = 1600;
	public static final int HEIGHT = 960;
	
	public Frame(String title)
	{
		super(title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Panel());
		setVisible(true);	
	}
}
