package GUI.Component.Labels;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	private int transparency;

	private void setCommon(ImageIcon icon){
		transparency = 100;
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
				falseOpaque();
				repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				trueOpaque();
				repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) { setBorder(null); }
			
			@Override
			public void mouseEntered(MouseEvent e) { setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)); }
			
			@Override
			public void mouseClicked(MouseEvent e) { }
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
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)((double)transparency / (double)100)));
		super.paint(g2);
		g2.dispose();
	}

	public Point getPosition(){ return this.getLocation(); }
	public int getCHeight(){ return height; }
	public int getCWidth(){ return width; }
	private void setColor(Color c){ this.setBackground(c); }
	private void falseOpaque() { this.setOpaque(false); opaque = false; }
	private void trueOpaque() { this.setOpaque(true); opaque = true; }
	
	public void setTransparency(int i) { this.transparency = i; }
	public int getTransparency() { return transparency; }
}
