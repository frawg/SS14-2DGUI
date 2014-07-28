package GUI.Component.Labels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import static java.lang.Math.abs;
import javax.swing.JComponent;

public class Connection{
	 float EPSILON = 0.001f;
	JLabel jlStart, jlEnd = null;
	Point end = null;
	ArrayList<Point> list = new ArrayList<Point>();
	
	public Connection(JLabel start, Point e)
	{
		jlStart = start;
		end = e;
	}
	
	public JLabel getJLEnd(){ return jlEnd; }
	public void setJLEnd(JLabel jend){ jlEnd = jend; end = null; }
	public JLabel getJLStart(){ return jlStart; }
	public void setEnd(Point p){ this.end = p; }
	public Point returnJLEnd(){return jlEnd.getLocation();}
	public Point returnJLStart(){return jlStart.getLocation();}
	
	
	public boolean contains(Point e)
	{
		Line2D temp = new Line2D.Float(jlStart.getLocation(), jlEnd.getLocation());
		if (temp.ptLineDist(e) <= 10)
			{return true;}
		return false;
	}
	
	public boolean contains(int x, int y)
	{
		 return contains(new Point(x, y));
	}
	
	public void paint(Graphics g) 
	{	
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2.setColor(Color.BLACK);
		
		if (jlEnd != null)
			{g2.drawLine((int)jlStart.getMiddleOfIcon().getX(), (int)jlStart.getMiddleOfIcon().getY(), (int)jlEnd.getMiddleOfIcon().getX(), (int)jlEnd.getMiddleOfIcon().getY());}
		else if (jlEnd == null)
		{
			g2.drawLine((int)jlStart.getMiddleOfIcon().getX(), (int)jlStart.getMiddleOfIcon().getY(), (int)end.getX(), (int)end.getY());
		g2.dispose();
		}
	}
	
	public JLabel getStart()
	{
		return jlStart;
	}
	
	public JLabel getEnd()
	{
		return jlEnd;
	}
}

