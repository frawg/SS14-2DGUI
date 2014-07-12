package GUI.Component.Labels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class JCustomBtnLabel extends JLabel {
	private int width, height = 65;
	private boolean opaque;

	private void setCommon(ImageIcon icon){
		//this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/hub.gif"), "Switch").getImage().getScaledInstance(50, 50, 0)));
		this.setIcon(new ImageIcon(icon.getImage().getScaledInstance(50, 50, 0)));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setPreferredSize(new Dimension(width, height));
		this.setMinimumSize(this.getPreferredSize());
		this.setOpaque(false);
		opaque = false;
		this.setColor(Color.LIGHT_GRAY);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				falseOpaque();
				repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				trueOpaque();
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//setColor(Color.LIGHT_GRAY);
			}
		});
	}
	
	public JCustomBtnLabel(String text, ImageIcon icon){
		super(text, JLabel.CENTER);
		setCommon(icon);
	}
	
	public JCustomBtnLabel(String text, int i, ImageIcon icon){
		super(text+i, JLabel.CENTER);
		setCommon(icon);
	}

	public Point getPosition(){ return this.getLocation(); }
	public int getCHeight(){ return height; }
	public int getCWidth(){ return width; }
	private void setColor(Color c){ this.setBackground(c); }
	private void falseOpaque() { this.setOpaque(false); opaque = false; }
	private void trueOpaque() { this.setOpaque(true); opaque = true; }
}
