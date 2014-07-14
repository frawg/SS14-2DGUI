package GUI.Component.Labels;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class JLabel extends javax.swing.JLabel{
	
	private float solidity;
	
	public JLabel() {
		super();
		solidity = 1.0f;
	}
	public JLabel(java.lang.String arg0, int arg1)
	{
		super(arg0, arg1);
		solidity = 1.0f;
	}
	public JLabel(java.lang.String arg0)
	{
		super(arg0);
		solidity = 1.0f;
	}
	public JLabel(javax.swing.Icon arg0, int arg1)
	{
		super(arg0, arg1);
		solidity = 1.0f;
	}
	public JLabel(javax.swing.Icon arg0)
	{
		super(arg0);
		solidity = 1.0f;
	}
	public JLabel(java.lang.String arg0, javax.swing.Icon arg1, int arg2)
	{
		super(arg0, arg1, arg2);
		solidity = 1.0f;
	}
	
	public float getSolidity() {
		return solidity;
	}

	public void setSolidity(float solidity) {
		this.solidity = solidity;
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, solidity));
		super.paint(g2);
		g2.dispose();
	}
	
	public void setLocation(Point p)
	{
		this.setLocation((int)p.getX(), (int)p.getY());
	}
	
	public void setLocation(int x, int y)
	{
		super.setBounds(x, y, (int)getPreferredSize().getWidth(), (int)getPreferredSize().getHeight());
	}
	
	public boolean contains(int x, int y)
	{
			return (getLocation().getX() < (double)x && (getLocation().getX() + (double)getWidth()) > (double)x 
					&& getLocation().getY() < (double)y && (getLocation().getY() + (double)getHeight()) > (double)y);
	}
	
	public Point getMiddleOfIcon()
	{
		return new Point(getX() + 25 , getY() + 25);
	}
}
