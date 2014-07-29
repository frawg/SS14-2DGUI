package GUI.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
	public enum SelectedType
	{
		NOTHING, LINE, DEVICE, DELETE
	};
	private static ArrayList<JLabel> items = null;
	private JLabel selected, mouseOver = null;
	private int _dragFromX, _dragFromY, _initX, _initY;
	private SelectedType seltype;
	private Connection drawLine = null;
	private static ArrayList<Connection> connections = null;
	private JToggleButton toolToReset = null;
	//private WorkAreaUI pui = null;
	//private PalateUI palate = null;
	private DeviceToolTip devtip = null;
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem menuEdit = new JMenuItem("Edit");
	private JMenuItem menuDelete = new JMenuItem("Delete");
	public boolean checkMouseOverItem = false;
	private boolean isDevicePropertiesOpen = false;
	private Point pointOfClick = new Point();
	private static final int HIT_BOX_SIZE = 35;
	
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
		
		menuEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ 
				if(isDevicePropertiesOpen == false)
				{
				DeviceProperties dp = new DeviceProperties();
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
	public void setSelected(JLabel temp) { this.selected = temp; this.seltype = SelectedType.DEVICE/* System.out.println(temp.getText() + " clicked"); System.out.println(selected.getPreferredSize())*/; }
	public void setLine(JToggleButton t,boolean b){ this.selected = null; this.seltype = SelectedType.LINE; toolToReset = t; /*System.out.println("selected");*/ }
	public void deleteLine(JToggleButton u, boolean b){this.selected = null; this.seltype = SelectedType.DELETE; toolToReset = u; /*System.out.println("delete line selected")*/;}
	public void cancelLine(boolean b){ this.selected = null; this.drawLine = null; this.seltype = SelectedType.NOTHING; toolToReset = null; repaint(); }
	public void cancelDelete(boolean b){this.selected = null; this.seltype=SelectedType.NOTHING; toolToReset = null;/*System.out.println("cancel delete line")*/;}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (drawLine != null)
			drawLine.paint(g);
		for (Connection c : connections)
			c.paint(g);
		//g.dispose();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		boolean checkClickLine = checkRightClickLine(e.getX(),e.getY());
		pointOfClick = e.getPoint();
		
		if(checkClickLine == true && SwingUtilities.isRightMouseButton(e) )
		{			
			showPopup(e);
		}
		
		if(seltype==SelectedType.DELETE)
		{
			  getClickedLine(e.getX(),e.getY());
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
			
			//System.out.println(items.size()+"item size");
		
			//System.out.println(crd+ " crd");
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
			//selected.setForeground(new Color(0, 0, 0, .5f));
			selected.setSolidity(0.5f);
//			selected.setBounds(e.getX() - (32), e.getY() - (32), (int)selected.getPreferredSize().getWidth(), (int)selected.getPreferredSize().getHeight());
			selected.setLocation(e.getX() - (32), e.getY() - (32));
			_dragFromX = 32;
			_dragFromY = 32;
	//		System.out.println(selected.getBounds() + "\t" + e.getPoint());
			this.add(selected, 0);
//			this.add(selected);
			repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println("Mouse exit.");
		if (seltype == SelectedType.DEVICE)
		{
			remove(selected);
		}
	//	System.out.println(seltype);
	//	seltype = SelectedType.NOTHING;
	//	selected = null;
		
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{	
		if (SwingUtilities.isRightMouseButton(e) && checkMouseOverItem ==true)
		{		
			//	System.out.println("Right Click");
				showPopup(e);
		}
			if (SwingUtilities.isLeftMouseButton(e))
		{
	//		System.out.println(getParent().getWidth() + ", " + getParent().getHeight() + "\t\t" + e.getX() + ", " + e.getY());
		//	System.out.println(e.getX() + ", " + e.getY());
		
			if (seltype != SelectedType.DEVICE) // not new item
			{
			
			//	System.out.print("\tNot new item");
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
						//System.out.print("new drawLine: ");
						drawLine = new Connection(selected, e.getPoint());
						selected = null;
						repaint();
					}
				}
				
			}
			else if (seltype == SelectedType.DEVICE)
			{
			//	System.out.println("place item");
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
//		System.out.println("\tNew item: " + selected.getText() + ".");
//		selected.setBounds(e.getX() - (32), e.getY() - (32), (int)selected.getPreferredSize().getWidth(), (int)selected.getPreferredSize().getHeight());
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
		//System.out.println(e.getPoint());
		//if (newItem)
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
		popupMenu.show(e.getComponent(),e.getX(),e.getY());
	}
	
	public void keyPressed(KeyEvent key)
	{
		//System.out.println("delete key pressed");
		if(key.getKeyCode()==KeyEvent.VK_DELETE)
		{
			//System.out.println("delete key pressed");
		}
	}
	
	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub

		if(key.getKeyChar()==KeyEvent.VK_DELETE)
		{
		//	System.out.println("delete key pressed");
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub

		if(key.getKeyCode()==KeyEvent.VK_DELETE)
		{
	//		System.out.println("delete key pressed");
		}
	}
	
	public static ArrayList<JLabel> getItemsList()
	{
		return items;
	}
	
	public static ArrayList<Connection> getConnList()
	{
		return connections;
	}
	
}
