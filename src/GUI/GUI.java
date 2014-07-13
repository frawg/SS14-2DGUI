package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.Component.MenuBarUI;
import GUI.Component.PDUPanel;
import GUI.Component.PalateUI;
import GUI.Component.WorkAreaUI;

public class GUI extends JApplet {
	JLayeredPane mainPanel;
	private PalateUI palate = null;
	private PDUPanel stats = null;
	private MenuBarUI menu = null;
	private WorkAreaUI work = null;
	
	public GUI(){
		int bottomBar = 0;//24;
		//this.setResizable(false);
		this.setPreferredSize(new Dimension(1024, 720));
		this.setSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		
		mainPanel = new JLayeredPane();
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setLayout(null);
		
		menu = new MenuBarUI();
		menu.setBounds(0, 0, this.getPreferredSize().width, menu.getPreferredSize().height);
		
		work = new WorkAreaUI();
		work.setBounds(0, menu.getPreferredSize().height, this.getPreferredSize().width, this.getPreferredSize().height - menu.getPreferredSize().height - bottomBar);
		
		stats = new PDUPanel();
		stats.setBounds(0, this.getPreferredSize().height - stats.getPreferredSize().height - bottomBar - 2, stats.getPreferredSize().width, stats.getPreferredSize().height);
		
		palate = new PalateUI(work);
		//palate.setBounds(0, menu.getPreferredSize().height, palate.getPreferredSize().width, this.getPreferredSize().height - menu.getPreferredSize().height - stats.getPreferredSize().height); //palate.getPreferredSize().height);
		palate.setBounds(0, menu.getPreferredSize().height + 65, palate.getPreferredSize().width, palate.getPreferredSize().height);
		
		mainPanel.add(menu);
		mainPanel.add(palate, JLayeredPane.PALETTE_LAYER);
		mainPanel.add(stats);
		mainPanel.add(work, JLayeredPane.DEFAULT_LAYER);
		
		this.setContentPane(mainPanel);
	}
}
