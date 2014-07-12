package GUI.Component.Labels;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JCustomHubLabel extends JLabel{
	private int width, height = 65;

	public JCustomHubLabel(){
		super("Hub", JLabel.CENTER);
		this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/hub.gif"), "Switch").getImage().getScaledInstance(50, 50, 0)));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setPreferredSize(new Dimension(width, height));
		this.setMinimumSize(this.getPreferredSize());
	}
	
	public JCustomHubLabel(int i){
		super("Hub"+i, JLabel.CENTER);
		this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/hub.gif"), "Switch").getImage().getScaledInstance(50, 50, 0)));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setPreferredSize(new Dimension(width, height));
	}

	public Point getPosition(){ return this.getLocation(); }
	public int getCHeight(){ return height; }
	public int getCWidth(){ return width; }

}
