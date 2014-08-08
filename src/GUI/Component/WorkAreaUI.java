package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import GUI.Component.WorkPanel.SelectedType;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WorkAreaUI extends JPanel {
	private WorkPanel work = null;
	private JScrollPane scroll = null;
	
	public WorkAreaUI(){
		this.setLayout(new BorderLayout());
		work = new WorkPanel();
		work.setPreferredSize(new Dimension(1600,1200));
		work.setBackground(Color.WHITE);
		
		scroll = new JScrollPane(work);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.setPreferredSize(new Dimension(800, 600));
		add(scroll, BorderLayout.CENTER);
	}
	
	public void setSelected(GUI.Component.Labels.JLabel temp) { work.setSelected(temp); }
	public void setLine(JToggleButton t){ work.setLine(t); }
	public void cancelTool(){ work.cancelTool(); }
	public void deleteLine(JToggleButton u){ work.setDelete(u); }
	
	public void zoomIn(JToggleButton t) { work.setZoomIn(t); }
	public void zoomOut(JToggleButton t) { work.setZoomOut(t); }
	public void zoom(JToggleButton t) { work.setZoom(t); }
}
