package GUI.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import GUI.Component.Labels.Connection;
//import javax.swing.JLabel;
import GUI.Component.Labels.JLabel;

import javax.swing.JPanel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class WorkPanel extends JPanel implements MouseListener, MouseMotionListener,KeyListener{
	public enum SelectedType { NOTHING, LINE, DEVICE, DELETE, ZOOMIN, ZOOMOUT, ZOOMORIGIN };
	private static ArrayList<JLabel> items = null;
	private JLabel selected, mouseOver = null;
	private int _dragFromX, _dragFromY, _initX, _initY;
	private SelectedType seltype;
	private Connection drawLine = null;
	private static ArrayList<Connection> connections = null;
	private JToggleButton toolToReset = null;
	private DeviceToolTip devtip = null;
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem menuEdit = new JMenuItem("Edit");
	private JMenuItem menuDelete = new JMenuItem("Delete");
	public boolean checkMouseOverItem = false;
	private boolean isDevicePropertiesOpen = false;
	private Point pointOfClick = new Point();
	private static final int HIT_BOX_SIZE = 35;
	
	private double scale;
	private Point scalePoint = null;
	
	private JButton savebtn = new JButton("Save");
	
	public WorkPanel()
	{
		super();
		checkMouseOverItem = false;
		seltype = SelectedType.NOTHING;
		items = new ArrayList<JLabel>();
		connections = new ArrayList<Connection>();
		this.setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		popupMenu.add(menuEdit);
		popupMenu.add(menuDelete);
		setFocusable(true);
		
		scale = 1.0;
		
		menuEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ 
				if(isDevicePropertiesOpen == false)
				{
					DeviceProperties dp = new DeviceProperties(selected.getText());
					selected = null;
				}
			}
		});
		
		menuDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				getClickedLine(pointOfClick.getX(),pointOfClick.getY());
				repaint();
			}
		});
		
	}
	public void setSelected(JLabel temp) { this.selected = temp; this.seltype = SelectedType.DEVICE; }
	public void setLine(JToggleButton t){ this.selected = null; this.seltype = SelectedType.LINE; toolToReset = t; }
	public void deleteLine(JToggleButton u){this.selected = null; this.seltype = SelectedType.DELETE; toolToReset = u; }
	public void setZoomIn(JToggleButton t){ this.selected = null; this.seltype = SelectedType.ZOOMIN; toolToReset = t; }
	public void setZoomOut(JToggleButton t){ this.selected = null; this.seltype = SelectedType.ZOOMOUT; toolToReset = t; }
	public void setZoom(JToggleButton t){ this.selected = null; this.seltype = SelectedType.ZOOMORIGIN; toolToReset = t; }
	public void cancelLine(){ this.selected = null; this.drawLine = null; this.seltype = SelectedType.NOTHING; toolToReset = null; }
	public void cancelDelete(){this.selected = null; this.seltype = SelectedType.NOTHING; toolToReset = null;}
	public void cancelZoom(){ this.selected = null; this.seltype = SelectedType.NOTHING; toolToReset = null; }
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (drawLine != null)
			drawLine.paint(g);
		for (Connection c : connections)
			c.paint(g);
	}
	
	@Override
	public void paint(Graphics g)
	{
//		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D)g.create();
		if (scalePoint == null)
		{
			super.paint(g);
		}
		else
		{
			System.out.println("scalePoint != null");
//			AffineTransform back = g2.getTransform()
			//super.paintComponent(g2);
			scalePoint = null;
		};
		g2.scale(scale, scale);
		super.paint(g2);
		g2.dispose();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		boolean checkClickLine = checkRightClickLine(e.getX(),e.getY());
		pointOfClick = e.getPoint();
		
		if(checkClickLine == true && SwingUtilities.isRightMouseButton(e) && seltype == SelectedType.NOTHING)
		{			
			showPopup(e);
		}
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if(seltype==SelectedType.DELETE)
			{
				  getClickedLine(e.getX(),e.getY());
			}
			else if (seltype == SelectedType.ZOOMIN)
			{
				scalePoint = checkFocus(e.getPoint());
				scalePlus();
				System.out.println("Zoom in");
			}
			else if (seltype == SelectedType.ZOOMOUT)
			{
				scalePoint = checkFocus(e.getPoint());
				scaleMinus();
				System.out.println("Zoom Out");
			}
			else if (seltype == SelectedType.ZOOMORIGIN)
			{
				scalePoint = checkFocus(e.getPoint());
				scaleOrigin();
				System.out.println("Zoom default");
			}
			repaint();
		}
	}
	
	private boolean checkRightClickLine(int x, int y)
	{		
		boolean a = false;
	
		for (Connection c:connections)
		{
			a = c.contains(new Point(x, y));
			if (a)
				return a;
		}
		return a;
		
	}
	
	private void getClickedLine(double x, double y) {
		// TODO Auto-generated method stub
		
		double boxX = x - HIT_BOX_SIZE;
		double boxY = y - HIT_BOX_SIZE;
		boolean a = false;
		int width = HIT_BOX_SIZE;
		int height = HIT_BOX_SIZE;
		int count = 0;
		//System.out.println(boxX+","+boxY+","+width+","+height);
		for (Connection c:connections)
		{
			Line2D line = new Line2D.Float();
			line.setLine(c.returnJLStart().getX(),c.returnJLStart().getY(),c.returnJLEnd().getX(),c.returnJLEnd().getY());
			
			if(line.intersects(boxX,boxY,width,height))
			{
				
				connections.remove(count);
				break;
			}	
			System.out.println("testing");
		}
		for (int crd=0; crd<items.size(); crd++) 
		{
			JLabel testCard = items.get(crd);
			if (testCard.contains((int)x, (int)y))
			{
				remove(testCard);
				items.remove(testCard);
				break;
			}
		}
		count ++;	
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Mouse entered.");
		if (selected != null && seltype == SelectedType.DEVICE && selected.getParent() != this)
		{
			selected.setSolidity(0.5f);
			selected.setLocation(e.getX() - (32), e.getY() - (32));
			_dragFromX = 32;
			_dragFromY = 32;
			this.add(selected, 0);
			repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (seltype == SelectedType.DEVICE)
		{
			remove(selected);
		}
		
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{	
		if (SwingUtilities.isRightMouseButton(e) && checkMouseOverItem ==true)
		{		
			showPopup(e);
		}
		if (SwingUtilities.isLeftMouseButton(e))
		{
		
			if (seltype != SelectedType.DEVICE) // not new item
			{
			
				if (selected == null)  // Assume not in any image.
				{	
					selectItem(e);			
					if (seltype == SelectedType.LINE && drawLine != null && selected != null)
					{
						if (drawLine.getJLStart() != selected)
						{
							drawLine.setJLEnd(selected);
							connections.add(drawLine);
							drawLine = null;
							seltype = SelectedType.NOTHING;
							toolToReset.setSelected(false);
							repaint();
						}
						selected = null;
					}
					else if (seltype == SelectedType.LINE && drawLine == null && selected != null)
					{
						drawLine = new Connection(selected, e.getPoint());
						selected = null;
						repaint();
					}
				}
				
			}
			else if (seltype == SelectedType.DEVICE)
			{
				placeNewItem(e);
			}
		}
	}
	
	private void selectItem(MouseEvent e)
	{
		
		for (int crd=items.size()-1; crd>=0; crd--) //... Find card image this is in.  Check from top down.
//		for (int crd = 0; crd < items.size(); crd++)
		{
			JLabel testCard = items.get(crd);
			if (testCard.contains(e.getX(), e.getY()))
			{
				//... Found, remember this card for dragging.
				_dragFromX = e.getX() - testCard.getX();  // how far from left
				_dragFromY = e.getY() - testCard.getY();  // how far from top
				selected = testCard;  // Remember what we're dragging.
				break;	
			}	
		}
		
	}
	
	private void placeNewItem(MouseEvent e)
	{
		seltype = SelectedType.NOTHING;
		selected.setLocation(e.getX() - (32), e.getY() - (32));
		selected.setSolidity(1.0f);
		_dragFromX = 32;
		_dragFromY = 32;
		remove(selected);
		add(selected, 0);
		items.add(selected);
		selected = null;
		this.repaint();
	//	DeviceProperties dp = new DeviceProperties();	
		}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if(seltype == SelectedType.NOTHING)
			{
				selected = null;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (seltype == SelectedType.NOTHING && SwingUtilities.isLeftMouseButton(e))
		{
				moveItem(e);
			if (devtip != null)
				invalidateMouseOver();
				repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (seltype == SelectedType.NOTHING)
		{
			if (mouseOver != null)
				{checkMouseOverItem = true;
				if (!mouseOver.contains(e.getPoint()))
				{
					invalidateMouseOver();
				}
				}
			if (selected == null && mouseOver == null)
				checkMouseOverItem = false;
				for (JLabel j : items)
					if (j.contains(e.getPoint()) && mouseOver ==  null)
					{
						doMouseOver(j);
						break;
					}
		}
		if (seltype == SelectedType.DEVICE)
			if (selected != null)
				moveItem(e);
		if (seltype == SelectedType.LINE && drawLine != null)
		{
			drawLine.setEnd(e.getPoint());
		}
		repaint();
	}
	
	private void doMouseOver(JLabel j)
	{
		mouseOver = j;
		devtip = new DeviceToolTip(j.getText(), "Device");
		devtip.setLocation(j.getMiddleRightOfIcon());
		devtip.Add();
		devtip.Add();
		devtip.refreshSize();
		add(devtip, 0);
		devtip.revalidate();
	}
	
	private void invalidateMouseOver()
	{
		mouseOver = null;
		remove(devtip);
		devtip = null;
		repaint();
	}
	
	private void moveItem(MouseEvent e)
	{
		if (selected != null) {   // Non-null if pressed inside card image.
            
            int newX = e.getX() - _dragFromX;
            int newY = e.getY() - _dragFromY;
            
            //--- Don't move the image off the screen sides
            newX = Math.max(newX, 0);
            newX = Math.min(newX, getWidth() - selected.getWidth());
            
            //--- Don't move the image off top or bottom
            newY = Math.max(newY, 0);
            newY = Math.min(newY, getHeight() - selected.getHeight());
            selected.setLocation(newX, newY);
            remove(selected);
            add(selected, 0);
         //   items.remove(selected);
         //   items.add(selected);
		}
	}
	private void showPopup(MouseEvent e)
	{
		selectItem(e);
		popupMenu.show(e.getComponent(),e.getX(),e.getY());
	}
	
	public void keyPressed(KeyEvent key)
	{
		//System.out.println("delete key pressed");
		if(key.getKeyCode()==KeyEvent.VK_DELETE)
		{
		}
	}
	
	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyChar()==KeyEvent.VK_DELETE)
		{
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyCode()==KeyEvent.VK_DELETE)
		{
		}
	}
	
	public static ArrayList<JLabel> getItemsList() { return items; }
	
	public static ArrayList<Connection> getConnList() { return connections; }
	
	
	private void scaleOrigin() { scale = 1; }
	private void scaleMinus() { if (scale > 0) scale -= 0.1; }
	private void scalePlus() { if (scale < 2) scale += 0.1; }
	
	private Point checkFocus(Point t)
	{
		int newX = (int)t.getX();
		int newY = (int)t.getY();

        //--- Don't move focus off the screen sides
        newX = Math.max(newX, 1024 / 2);
        newX = Math.min(newX, getWidth() / 2);
        
        //--- Don't move focus off top or bottom
        newY = Math.max(newY, 720 / 2);
        newY = Math.min(newY, getHeight() / 2);
		
		return new Point(newX, newY);
	}
}
