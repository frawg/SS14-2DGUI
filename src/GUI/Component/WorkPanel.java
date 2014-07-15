package GUI.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import javax.swing.SwingUtilities;

//import javax.swing.JLabel;
import GUI.Component.Labels.JLabel;

import javax.swing.JPanel;

public class WorkPanel extends JPanel implements MouseListener, MouseMotionListener {
	public enum SelectedType
	{
		NOTHING, LINE, DEVICE
	};
	private ArrayList<JLabel> items = null;
	private JLabel selected, mouseOver = null;
	private int _dragFromX, _dragFromY, _initX, _initY;
	private SelectedType seltype;
	
	public WorkPanel()
	{
		seltype = SelectedType.NOTHING;
		items = new ArrayList<JLabel>();
		this.setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void setSelected(JLabel temp) { this.selected = temp; this.seltype = SelectedType.DEVICE; System.out.println(temp.getText() + " clicked"); System.out.println(selected.getPreferredSize()); }
	public void setLine(){ this.selected = null; this.seltype = SelectedType.LINE; }
	
	@Override
	public void mouseClicked(MouseEvent e) {
//		for (JLabel j : items)
//			if (j.contains(e.getPoint()))
//				line = new Line(j);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered.");
		if (selected != null && seltype == SelectedType.DEVICE && selected.getParent() != this)
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
		if (seltype == SelectedType.DEVICE)
		{
			remove(selected);
		}

		seltype = SelectedType.NOTHING;
		selected = null;
		
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		System.out.println(getParent().getWidth() + ", " + getParent().getHeight() + "\t\t" + e.getX() + ", " + e.getY());
		System.out.print(e.getX() + ", " + e.getY());
		
		if (seltype == SelectedType.NOTHING) // not new item
		{
			System.out.print("\tNot new item");
			if (selected == null)  // Assume not in any image.
			{
				selectItem(e);
			}
		}
		else if (seltype == SelectedType.DEVICE)
		{
			placeNewItem(e);
		}	
	}
	
	private void selectItem(MouseEvent e)
	{
		System.out.println("\tSelected is null.");
		for (int crd=items.size()-1; crd>=0; crd--) //... Find card image this is in.  Check from top down.
//		for (int crd = 0; crd < items.size(); crd++)
		{
			JLabel testCard = items.get(crd);
			if (testCard.contains(e.getX(), e.getY())) {
				//... Found, remember this card for dragging.
				_dragFromX = e.getX() - testCard.getX();  // how far from left
				_dragFromY = e.getY() - testCard.getY();  // how far from top
				selected = testCard;  // Remember what we're dragging.
					if (SwingUtilities.isRightMouseButton(e))
						System.out.println(selected.getText() + " right click.");
				break;        // Stop when we find the first match.
			}	
		}
	}
	
	private void placeNewItem(MouseEvent e)
	{
		System.out.println("\tNew item: " + selected.getText() + ".");
//		selected.setBounds(e.getX() - (32), e.getY() - (32), (int)selected.getPreferredSize().getWidth(), (int)selected.getPreferredSize().getHeight());
		selected.setLocation(e.getX() - (32), e.getY() - (32));
		selected.setSolidity(1.0f);
		_dragFromX = 32;
		_dragFromY = 32;
		this.add(selected, 0);
		items.add(selected);
		seltype = SelectedType.NOTHING;
		this.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		selected = null;
		seltype = SelectedType.NOTHING;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		moveItem(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (selected == null)
			for (JLabel j : items)
				if (j.contains(e.getPoint()) && mouseOver != j)
				{
					mouseOver = j;
					System.out.println(j.getText() + " mouse over.");
					break;
				}
		if (mouseOver != null)
			if (!mouseOver.contains(e.getPoint()))
				mouseOver = null;
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
            remove(selected);
            add(selected, 0);
            items.remove(selected);
            items.add(selected);
            
            this.repaint(); // Repaint because position changed.
		}
	}
}
