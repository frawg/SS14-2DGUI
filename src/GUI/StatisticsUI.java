package GUI;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Component;


public class StatisticsUI extends JTabbedPane {

	JPanel history = null;
	JPanel simDev = null;
	JLabel dev1SelLab = null;
	JComboBox dev1Select = null;
	JLabel dev1SelPortLab = null;
	JComboBox dev1SelectPort = null;
	JLabel dev2SelLab = null;
	JComboBox dev2Select = null;
	JLabel dev2SelPortLab = null;
	JComboBox dev2SelecPort = null;
	JButton pingBtn = null;
	JButton backBtn = null;
	JLabel devHistoryLab = null;
	JComboBox devHistoryComb = null;
	JButton histRefBtn = null;
	JScrollPane historyScrollPane = null;
	JTextArea historyTextArea = null;
	
	/**
	 * Create the panel.
	 */
	public StatisticsUI() {
		history = new JPanel();
		simDev = new JPanel();
		addTab("Devices", simDev);
		simDev.setLayout(null);
		//simDev.setLayout(new BoxLayout(simDev, BoxLayout.X_AXIS));
		
		dev1SelLab = new JLabel("Device From:");
		dev1SelLab.setAlignmentY(10.0f);
		simDev.add(dev1SelLab);
		
		dev1Select = new JComboBox();
		simDev.add(dev1Select);
		
		dev2SelPortLab = new JLabel("Device To:");
		simDev.add(dev2SelPortLab);
		
		dev2SelecPort = new JComboBox();
		simDev.add(dev2SelecPort);
		
		pingBtn = new JButton("Ping");
		simDev.add(pingBtn);
		
		backBtn = new JButton("Back");
		simDev.add(backBtn);
		
		
		addTab("History", history);
		history.setLayout(null);
		//history.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		devHistoryLab = new JLabel("Device History:");
		devHistoryLab.setBounds(0, 0, 73, 14);
		history.add(devHistoryLab);
		
		devHistoryComb = new JComboBox();
		devHistoryComb.setBounds(0, 0, 28, 20);
		history.add(devHistoryComb);
		
		histRefBtn = new JButton("New button");
		histRefBtn.setBounds(0, 0, 89, 23);
		history.add(histRefBtn);
		
		historyScrollPane = new JScrollPane();
		historyScrollPane.setBounds(0, 0, 2, 2);
		history.add(historyScrollPane);
		
		historyTextArea = new JTextArea();
		historyScrollPane.add(historyTextArea);
	}

}
