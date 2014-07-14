package GUI.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

//import javax.swing.JLabel;
import GUI.Component.Labels.JLabel;

import javax.swing.JPanel;

public class WorkPanel extends JPanel implements MouseListener, MouseMotionListener {
	private ArrayList<JLabel> items = null;
	private JLabel selected = null;
	private int _dragFromX, _dragFromY, _initX, _initY;
	private boolean newItem;
	
	public WorkPanel()
	{
		items = new ArrayList<JLabel>();
		newItem = false;
		this.setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void setSelected(JLabel temp) { this.selected = temp; newItem = true; System.out.println(temp.getText() + " clicked"); System.out.println(selected.getPreferredSize()); }
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered.");
		if (selected != null && newItem && selected.getParent() != this)
		{
			//selected.setForeground(new Color(0, 0, 0, .5f));
			selected.setSolidity(0.5f);
//			selected.setBounds(e.getX() - (32), e.getY() - (32), (int)selected.getPreferredSize().getWidth(), (int)selected.getPreferredSize().getHeight());
			selected.setLocation(e.getX() - (32), e.getY() - (32));
			_dragFromX = 32;
			_dragFromY = 32;
			System.out.println(selected.getBounds() + "\t" + e.getPoint());
			this.add(selected, 0);
//			this.add(selected);
			repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse exit.");
		if (newItem)
		{
			remove(selected);
		}

		newItem = false;
		selected = null;
		
		this.repaint();
	}

	private boolean compareLocation(JLabel temp, int tx, int ty)
	{
		return (temp.getLocation().getX() < (double)tx && (temp.getLocation().getX() + (double)temp.getWidth()) > (double)tx 
				&& temp.getLocation().getY() < (double)ty && (temp.getLocation().getY() + (double)temp.getHeight()) > (double)ty);
	}
	
	@Override
	public void mousePressed(MouseEvent e) { 
		System.out.println(getParent().getWidth() + ", " + getParent().getHeight() + "\t\t" + e.getX() + ", " + e.getY());
		int x = e.getX();   // Save the x coord of the click
		int y = e.getY();   // Save the y coord of the click
		System.out.print(x + ", " + y);
		//... Find card image this is in.  Check from top down.
		
		if (!newItem) // not new item
		{
			System.out.print("\tNot new item");
			if (selected == null)  // Assume not in any image.
			{
				System.out.println("\tSelected is null.");
				for (int crd=items.size()-1; crd>=0; crd--)
//				for (int crd = 0; crd < items.size(); crd++)
				{
					JLabel testCard = items.get(crd);
//					if (compareLocation(testCard, x, y)) {
					if (testCard.contains(x, y)) {
						//... Found, remember this card for dragging.
						_dragFromX = x - testCard.getX();  // how far from left
						_dragFromY = y - testCard.getY();  // how far from top
						selected = testCard;  // Remember what we're dragging.
						break;        // Stop when we find the first match.
					}	
				}
			}
		}
		else
		{
			System.out.println("\tNew item: " + selected.getText() + ".");
//			selected.setBounds(e.getX() - (32), e.getY() - (32), (int)selected.getPreferredSize().getWidth(), (int)selected.getPreferredSize().getHeight());
			selected.setLocation(e.getX() - (32), e.getY() - (32));
			selected.setSolidity(1.0f);
			_dragFromX = 32;
			_dragFromY = 32;
			this.add(selected, 0);
			items.add(selected);
			newItem = false;
			this.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		selected = null;
		newItem = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		moveItem(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getPoint());
		//if (newItem)
			if (selected != null)
				moveItem(e);
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
            //selected.setLocation(e.getX(), e.getY());
            
            this.repaint(); // Repaint because position changed.
		}
	}
}
