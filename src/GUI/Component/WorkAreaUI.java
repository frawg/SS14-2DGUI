package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class WorkAreaUI extends JPanel {
	private WorkPanel work = null;
	private JScrollPane scroll = null;
	
	public WorkAreaUI(){
		this.setLayout(new BorderLayout());
		work = new WorkPanel();
		work.setPreferredSize(new Dimension(1600,1200));
//		work.setMinimumSize(new Dimension(1600,1200));
		work.setBackground(Color.WHITE);
		
		scroll = new JScrollPane(work);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setPreferredSize(new Dimension(800, 600));
		add(scroll, BorderLayout.CENTER);
	}
	
	public void setSelected(GUI.Component.Labels.JLabel temp) { work.setSelected(temp); }
}
