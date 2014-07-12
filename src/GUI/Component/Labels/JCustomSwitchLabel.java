package GUI.Component.Labels;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class JCustomSwitchLabel extends JLabel {
	private int width, height = 65;

	public JCustomSwitchLabel(){
		super("Switch", JLabel.CENTER);
		this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/switch.png"), "Switch").getImage().getScaledInstance(50, 50, 0)));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setPreferredSize(new Dimension(width, height));
		this.setMinimumSize(this.getPreferredSize());
	}
	
	public JCustomSwitchLabel(int i){
		super("Switch"+i, JLabel.CENTER);
		this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/switch.png"), "Switch").getImage().getScaledInstance(50, 50, 0)));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setPreferredSize(new Dimension(width, height));
	}

	public Point getPosition(){ return this.getLocation(); }
	public int getCHeight(){ return height; }
	public int getCWidth(){ return width; }
}
