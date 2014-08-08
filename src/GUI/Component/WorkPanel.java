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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
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

import GUI.Component.Edit.ComputerProperties;
import GUI.Component.Edit.RouterProperties;
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
	private boolean isDevicePropertiesOpen = false;
	
	private double scale;
	private Point scalePoint = null;
	
	private JButton savebtn = new JButton("Save");
	
	public WorkPanel()
	{
		super();
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
		
		scale = 1;
		
		menuEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ 
				if(isDevicePropertiesOpen == false)
				{
					Globals.Element element = new Globals.Element();
					element = Globals.Parser.getSelectedElement();
					if (element.type == Globals.Globals.Type.COMPUTER) { 
						System.out.println("Edit menu for computer");
						Nodes.COMPUTER c = Globals.Globals.computerList.get(element.index);
						new ComputerProperties(c).addWindowListener(new WindowAdapter() {
							@Override
						    public void windowOpened(WindowEvent we) { resetSelects(); }
							@Override
						    public void windowClosed(WindowEvent we) { getThis().requestFocus(); }
						});
					}
					else if (element.type == Globals.Globals.Type.ROUTER) {
						System.out.println("Edit menu for router");
						Nodes.ROUTER r = Globals.Globals.routerList.get(element.index);
						new RouterProperties(r).addWindowListener(new WindowAdapter() {
							@Override
						    public void windowOpened(WindowEvent we) { resetSelects(); }
							@Override
						    public void windowClosed(WindowEvent we) { getThis().requestFocus(); }
						});
					}
				}
			}
		});
		
		menuDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				deleteItem(selected.getLocation());
				repaint();
			}
		});
		
	}
	public void setSelected(JLabel temp) { this.selected = temp; this.seltype = SelectedType.DEVICE; }
	public void setLine(JToggleButton t){ this.selected = null; this.seltype = SelectedType.LINE; toolToReset = t; }
	public void setDelete(JToggleButton u){this.selected = null; this.seltype = SelectedType.DELETE; toolToReset = u; }
	public void setZoomIn(JToggleButton t){ this.selected = null; this.seltype = SelectedType.ZOOMIN; toolToReset = t; }
	public void setZoomOut(JToggleButton t){ this.selected = null; this.seltype = SelectedType.ZOOMOUT; toolToReset = t; }
	public void setZoom(JToggleButton t){ this.selected = null; this.seltype = SelectedType.ZOOMORIGIN; toolToReset = t; }
	public void cancelTool(){ 
		this.selected = null; 
		this.drawLine = null; 
		this.seltype = SelectedType.NOTHING;
		if (toolToReset != null)
			toolToReset.setSelected(false); 
		toolToReset = null; 
	}
	
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
		Graphics2D g2 = (Graphics2D)g.create();
		if (scalePoint != null)
		{
			System.out.println("scalePoint != null");
			scalePoint = null;
		};
		g2.scale(scale, scale);
		super.paint(g2);
		g2.dispose();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
				
		if(SwingUtilities.isRightMouseButton(e) && seltype == SelectedType.NOTHING)
		{			
			showPopup(e);
		}
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if(seltype==SelectedType.DELETE) deleteItem(e.getPoint());
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
	
	// methods inside handles scaling
	private void deleteItem(Point e)
	{
		selectItem(e);
		if (selected != null)
		{
			connections.remove(selectLine((int)selected.getMiddleOfIcon().getX(), (int)selected.getMiddleOfIcon().getY()));
			items.remove(selected);
			remove(selected);
			selected = null;
			repaint();
		}
	}
	
	// input must be scaled
	private Connection selectLine(int x, int y)
	{		
		for (Connection c:connections)
			if (c.contains(new Point(x, y)))
				return c;
		return null;
		
	}
	
	@Override // handles scaling
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Mouse entered.");
		if (selected != null && seltype == SelectedType.DEVICE && selected.getParent() != this)
		{
			selected.setSolidity(0.5f);
			selected.setLocation(scaleInt(e.getX()) - (32), scaleInt(e.getY()) - (32));
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
			System.out.println("Item removed");
			remove(selected);
		}
		
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{	
		if (SwingUtilities.isRightMouseButton(e))
		{		
			showPopup(e);
		}
		if (SwingUtilities.isLeftMouseButton(e))
		{
		
			if (seltype != SelectedType.DEVICE) // not new item
			{
			
				if (selected == null)  // Assume not in any image.
				{	
					selectItem(e.getPoint());			
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
						drawLine = new Connection(selected, new Point(scaleInt(e.getX()), scaleInt(e.getY())));
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
	
	// handles scaling
	private void selectItem(Point e)
	{
		//for (int crd=items.size()-1; crd>=0; crd--) //... Find card image this is in.  Check from top down.
//		for (int crd = 0; crd < items.size(); crd++)
		for (int crd = 0; crd < getComponents().length; crd++)
		{
			if (getComponents()[crd] instanceof JLabel)
			{
				JLabel testCard = (JLabel)getComponents()[crd];//items.get(crd);
				if (testCard.contains(scaleInt((int)e.getX()), scaleInt((int)e.getY())))
				{
					//... Found, remember this card for dragging.
					_dragFromX = scaleInt((int)e.getX()) - testCard.getX();  // how far from left
					_dragFromY = scaleInt((int)e.getY()) - testCard.getY();  // how far from top
					selected = testCard;  // Remember what we're dragging.
					break;	
				}
			}
		}
	}
	
	// handles scaling
	private void placeNewItem(MouseEvent e)
	{
		seltype = SelectedType.NOTHING;
		selected.setLocation(scaleInt(e.getX()) - (32), scaleInt(e.getY()) - (32));
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

	@Override // handles scaling
	public void mouseMoved(MouseEvent e) {
		if (seltype == SelectedType.NOTHING)
		{
			if (mouseOver != null && !mouseOver.contains(scaleInt(e.getX()), scaleInt(e.getY())))
			{
				invalidateMouseOver();
			}
			if (selected == null && mouseOver == null)
			{
				selectItem(e.getPoint());
				if (selected != null)
				{
					_initX = _dragFromX;
					_initY = _dragFromY;
					doMouseOver();
				}
			}
		}
		if (seltype == SelectedType.DEVICE)
			if (selected != null)
				moveItem(e);
		if (seltype == SelectedType.LINE && drawLine != null)
		{
			drawLine.setEnd(new Point(scaleInt(e.getX()), scaleInt(e.getY())));
		}
		repaint();
	}
	
	private void doMouseOver()
	{
		mouseOver = selected;
		
		Globals.Globals.Type t = mouseOver.getType();
        int id = mouseOver.getID();
        int index=Globals.Parser.getIndexByID(t, id);            
        int nodeId = Globals.Parser.getIDByIndexAndType(t, index);
        
        if (t == Globals.Globals.Type.COMPUTER) {
        	System.out.println("Computer" + nodeId + " selected");
        	Globals.Globals.computerList.get(index).setSelected();
        	devtip = new DeviceToolTip(Globals.Globals.computerList.get(index));
        	devtip.AddRowForComputer(Globals.Globals.computerList.get(index));
        	devtip.refreshSize();
        	add(devtip, 0);
        	devtip.revalidate();
        }
        else if (t == Globals.Globals.Type.HUB){
        	System.out.println("Hub" + nodeId + " selected");
        	Globals.Globals.hubList.get(index).setSelected();
        } 
        else if (t == Globals.Globals.Type.SWITCH){
          System.out.println("Switch" + nodeId + " selected");
          Globals.Globals.switchList.get(index).setSelected();
        }  
        else if (t == Globals.Globals.Type.ROUTER){
          System.out.println("Router" + nodeId + " selected");
          Globals.Globals.routerList.get(index).setSelected();
        }  
		
        if (devtip != null)
	    {
        	int newX = (int)selected.getX() + _initX;
	        int newY = (int)selected.getBottomRightOfIcon().getY();// + _initY;
	        
	        //--- Don't move the image off the screen sides
	        newX = Math.max(newX, 0);
	        newX = Math.min(newX, scaleInt(getParent().getWidth()) - devtip.getWidth() - selected.getWidth());
	        
	        //--- Don't move the image off top or bottom
	        newY = Math.max(newY, 0);
	        newY = Math.min(newY, scaleInt(getParent().getHeight()) - devtip.getHeight() - selected.getHeight());
			
			devtip.setLocation(newX, newY);
        }
        else
        	mouseOver = null;
		selected = null;
	}
	
	private void invalidateMouseOver()
	{
		Globals.Element element = new Globals.Element();
		element = Globals.Parser.getSelectedElement();
        if (element.type == Globals.Globals.Type.COMPUTER)
        {
        	System.out.println("unselecting computer");
        	Nodes.COMPUTER c = Globals.Globals.computerList.get(element.index);
        	c.setUnSelected();
        	remove(devtip);
        	devtip = null;
        } else if (element.type == Globals.Globals.Type.ROUTER)
        {
        	System.out.println("unselecting router");
        	Nodes.ROUTER c = Globals.Globals.routerList.get(element.index);
        	c.setUnSelected();
        } else if (element.type == Globals.Globals.Type.HUB)
        {
        	System.out.println("unselecting hub");
        	Nodes.HUB c = Globals.Globals.hubList.get(element.index);
        	c.setUnSelected();
        } else if (element.type == Globals.Globals.Type.SWITCH)
        {
        	System.out.println("unselecting switch");
        	Nodes.SWITCH c = Globals.Globals.switchList.get(element.index);
        	c.setUnSelected();
        }              
        mouseOver = null;
		repaint();
	}
	
	// handles scaling
	private void moveItem(MouseEvent e)
	{
		if (selected != null) {   // Non-null if pressed inside card image.
            
            int newX = scaleInt(e.getX()) - _dragFromX;
            int newY = scaleInt(e.getY()) - _dragFromY;
            
            //--- Don't move the image off the screen sides
            newX = Math.max(newX, 0);
            newX = Math.min(newX, scaleInt(getParent().getWidth()) - selected.getWidth());
            
            //--- Don't move the image off top or bottom
            newY = Math.max(newY, 0);
            newY = Math.min(newY, scaleInt(getParent().getHeight()) - selected.getHeight());
            selected.setLocation(newX, newY);
            remove(selected);
            add(selected, 0);
		}
	}
	
	// apparently no need to scale
	private void showPopup(MouseEvent e)
	{
		selectItem(e.getPoint());
		popupMenu.show(e.getComponent(), e.getX(), e.getY());
	}
	
	public void keyPressed(KeyEvent key)
	{
		if(key.getKeyCode()==KeyEvent.VK_DELETE)
		{
			//System.out.println("delete key pressed");
		}
	}
	
	@Override
	public void keyReleased(KeyEvent key) {
		if(key.getKeyChar()==KeyEvent.VK_DELETE)
		{
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_DELETE)
		{
		}
	}
	
	public static ArrayList<JLabel> getItemsList() { return items; }
	
	public static ArrayList<Connection> getConnList() { return connections; }
	
	
	private void scaleOrigin() { scale = 1; cancelTool(); }
	private void scaleMinus() { 
		if (scale > 0.81)
			scale -= 0.02;
		else
			cancelTool();
	}
	private void scalePlus() { 
		if (scale < 1.21) 
			scale += 0.02;
		else
			cancelTool();
	}
	
	// handles scaling
	private Point checkFocus(Point t)
	{
		int newX = scaleInt((int)t.getX());
		int newY = scaleInt((int)t.getY());

        //--- Don't move focus off the screen sides
        newX = Math.max(newX, 0);
        newX = Math.min(newX, scaleInt(getParent().getWidth()) / 2);
        
        //--- Don't move focus off top or bottom
        newY = Math.max(newY, 0);
        newY = Math.min(newY, scaleInt(getParent().getHeight()) / 2);
		
		return new Point(newX, newY);
	}
	
	private int scaleInt(int i)
	{ return (int)Math.round(i / scale); }
	private int unscaleInt(int i)
	{ return (int)Math.round(i * scale); }
	private WorkPanel getThis() { return this; }
	
	public void resetSelects()
	{
		invalidateMouseOver();
		selected = null;
	}
}
