package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuBar;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Component.MenuBarUI;
import GUI.Component.PDUPanel;
import GUI.Component.PalateUI;
import GUI.Component.WorkAreaUI;

public class GUI extends JFrame {
	private JPanel mainPanel, secPanel, sidePanel = null;
	private PalateUI palate = null;
	private PDUPanel stats = null;
	private MenuBarUI menu = null;
	private WorkAreaUI work = null;
	
	public GUI(){
		//this.setResizable(false);
		//this.setPreferredSize(new Dimension(1024, 720));
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		secPanel = new JPanel();
		secPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		menu = new MenuBarUI();
		
		work = new WorkAreaUI();
		
		stats = new PDUPanel();
		
		palate = new PalateUI();
		
		sidePanel.add(palate);
		sidePanel.add(stats);
		
		mainPanel.add(menu, BorderLayout.PAGE_START);
		secPanel.add(sidePanel, BorderLayout.LINE_END);
		secPanel.add(work, BorderLayout.CENTER);
		mainPanel.add(secPanel);
		
		this.setContentPane(mainPanel);
	}
}
