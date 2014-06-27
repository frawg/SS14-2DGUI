package GUI.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.ScrollPaneConstants;

public class PDUPanel extends JPanel {

	private JLabel labTime, labDest, labSource, labStatus, labType = null;
	private JPanel header, content = null;
	private JScrollPane scroll = null;
	
	/**
	 * Create the panel.
	 */
	public PDUPanel() {
		Border bordLabel = BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY), BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		header = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		header.setBackground(Color.WHITE);
		header.setAlignmentX(Component.RIGHT_ALIGNMENT);
		header.setPreferredSize(new Dimension(100 + 100 + 50 + 50 + 80 + 20, 20));
		header.setMaximumSize(header.getPreferredSize());
		header.setMinimumSize(header.getPreferredSize());
		
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		scroll = new JScrollPane(content);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		labTime = new JLabel("Time");
		labTime.setBorder(bordLabel);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		labTime.setPreferredSize(new Dimension(50, 20));
		
		labDest = new JLabel("Destination");
		labDest.setBorder(bordLabel);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		labDest.setPreferredSize(new Dimension(100, 20));
		
		labSource = new JLabel("Source");
		labSource.setBorder(bordLabel);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		labSource.setPreferredSize(new Dimension(100, 20));
		
		labStatus = new JLabel("Status");
		labStatus.setBorder(bordLabel);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		labStatus.setPreferredSize(new Dimension(80, 20));
		
		labType = new JLabel("Type");
		labType.setBorder(bordLabel);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		labType.setPreferredSize(new Dimension(52, 20));
		
		header.add(labTime);
		header.add(labDest);
		header.add(labSource);
		header.add(labStatus);
		header.add(labType);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(400, 200));
		this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		this.setBackground(Color.WHITE);
		
		this.add(header);
		this.add(scroll);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		AddRecord();
	}
	
	public void AddRecord(String time, String dest, String source, String status, String type){
		StatisticRow sr = new StatisticRow(time, dest, source, status, type);
		sr.setAlignmentX(Component.RIGHT_ALIGNMENT);
		content.add(sr);
	}
	
	private void AddRecord(){
		StatisticRow sr = new StatisticRow();
		sr.setAlignmentX(Component.RIGHT_ALIGNMENT);
		content.add(sr);
	}
	
	public void ClearRecords(){
		content.removeAll();
	}

}
