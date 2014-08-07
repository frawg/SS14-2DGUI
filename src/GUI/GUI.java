package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
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
	public GUI() {
	}
	JLayeredPane mainPanel;
	private PalateUI palate = null;
	private PDUPanel stats = null;
	private MenuBarUI menu = null;
	private WorkAreaUI work = null;
	
	public void init(){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JApplet app = GUI.this;
				

				int bottomBar = 0;//24;
				//this.setResizable(false);
				app.setPreferredSize(new Dimension(1024, 720));
				app.setSize(app.getPreferredSize());
				app.setMinimumSize(app.getPreferredSize());
				
				mainPanel = new JLayeredPane();
				//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
				mainPanel.setLayout(null);
				
				menu = new MenuBarUI();
				menu.setBounds(0, 0, app.getPreferredSize().width, menu.getPreferredSize().height);
				
				stats = new PDUPanel();
				stats.setBounds(0, app.getPreferredSize().height - stats.getPreferredSize().height - bottomBar, stats.getPreferredSize().width, stats.getPreferredSize().height);
				
				work = new WorkAreaUI();
				work.setBounds(0, menu.getPreferredSize().height, app.getPreferredSize().width, app.getPreferredSize().height - stats.getPreferredSize().height - menu.getPreferredSize().height);
				
				palate = new PalateUI(work);
				//palate.setBounds(0, menu.getPreferredSize().height, palate.getPreferredSize().width, this.getPreferredSize().height - menu.getPreferredSize().height - stats.getPreferredSize().height); //palate.getPreferredSize().height);
//				palate.setBounds(0, menu.getPreferredSize().height + 65, palate.getPreferredSize().width, palate.getPreferredSize().height);
//				palate.setBounds(app.getPreferredSize().width - palate.getPreferredSize().width, app.getPreferredSize().height - palate.getPreferredSize().height, palate.getPreferredSize().width, palate.getPreferredSize().height);
				palate.setBounds(stats.getPreferredSize().width, app.getPreferredSize().height - palate.getPreferredSize().height, app.getPreferredSize().width - stats.getPreferredSize().width, palate.getPreferredSize().height);
				
				mainPanel.add(menu);
				mainPanel.add(palate, JLayeredPane.PALETTE_LAYER);
				mainPanel.add(stats);
				mainPanel.add(work, JLayeredPane.DEFAULT_LAYER);
				
				app.setContentPane(mainPanel);
			}
		});
	}
}
