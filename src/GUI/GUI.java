package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuBar;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.Component.MenuBarUI;
import GUI.Component.PDUPanel;
import GUI.Component.PalateUI;
import GUI.Component.WorkAreaUI;

public class GUI extends JApplet {
	private JPanel mainPanel, secPanel, sidePanel = null;
	private PalateUI palate = null;
	private PDUPanel stats = null;
	private MenuBarUI menu = null;
	private WorkAreaUI work = null;
	
		public GUI(){
		//this.setResizable(false);
		this.setPreferredSize(new Dimension(1024, 720));
		this.setSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		
		mainPanel = new JPanel();
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setLayout(null);
		
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.setOpaque(false);
		
		secPanel = new JPanel();
		secPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		menu = new MenuBarUI();
		menu.setBounds(0, 0, this.getPreferredSize().width, menu.getPreferredSize().height);
		
		work = new WorkAreaUI();
		work.setBounds(0, menu.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height - menu.getPreferredSize().height);
		//this.getPreferredSize().width - work.getPreferredSize().width - 7
		
		stats = new PDUPanel();
		stats.setBounds(2, this.getPreferredSize().height - stats.getPreferredSize().height - 2, stats.getPreferredSize().width, stats.getPreferredSize().height);
		
		palate = new PalateUI();
		palate.setBounds(2, menu.getPreferredSize().height + 30, palate.getPreferredSize().width, palate.getPreferredSize().height);
		
//		sidePanel.add(palate, Component.RIGHT_ALIGNMENT);
//		sidePanel.add(stats, Component.LEFT_ALIGNMENT);
//		
//		secPanel.add(sidePanel, BorderLayout.LINE_START);
//		secPanel.add(work, BorderLayout.CENTER);
		
		mainPanel.add(menu);
		mainPanel.add(palate);
		mainPanel.add(stats);
		mainPanel.add(work);
		
		this.setContentPane(mainPanel);
	}
}
