package GUI.Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class StatisticRow extends JPanel {
	private JLabel labDest, labSource, labType, labTime, labStatus = null;
	private Border padd = null;
	
	public StatisticRow(String time, String dest, String source, String status, String type){
		padd = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		labTime = new JLabel(time);
		labTime.setBackground(Color.WHITE);
		labTime.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labTime.setPreferredSize(new Dimension(50, labTime.getHeight()));
		
		labDest = new JLabel(dest);
		labDest.setBackground(Color.WHITE);
		labDest.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labDest.setPreferredSize(new Dimension(100, labDest.getHeight()));
		
		labSource = new JLabel(source);
		labSource.setBackground(Color.WHITE);
		labSource.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labSource.setPreferredSize(new Dimension(100, 20));
		
		labStatus = new JLabel(status);
		labStatus.setBackground(Color.WHITE);
		labStatus.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labStatus.setPreferredSize(new Dimension(80, 20));
		
		labType = new JLabel(type);
		labType.setBackground(Color.WHITE);
		labType.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labType.setPreferredSize(new Dimension(50, 20));
		
		this.add(labTime);
		this.add(labDest);
		this.add(labSource);
		this.add(labStatus);
		this.add(labType);
		
		this.setPreferredSize(new Dimension(100 + 100 + 50 + 50 + 80, 20));	
	}
	
	public StatisticRow(){
		padd = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		labTime = new JLabel("23:55", SwingConstants.LEFT);
		labTime.setBackground(Color.WHITE);
		labTime.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labTime.setPreferredSize(new Dimension(50, 20));
		
		labDest = new JLabel("255.255.253.254", SwingConstants.LEFT);
		labDest.setBackground(Color.WHITE);
		labDest.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labDest.setPreferredSize(new Dimension(100, 20));
		
		labSource = new JLabel("255.255.255.253", SwingConstants.LEFT);
		labSource.setBackground(Color.WHITE);
		labSource.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labSource.setPreferredSize(new Dimension(100, 20));
		
		labStatus = new JLabel("Unsuccessful", SwingConstants.LEFT);
		labStatus.setBackground(Color.WHITE);
		labStatus.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labStatus.setPreferredSize(new Dimension(80, 20));
		
		labType = new JLabel("ICMP", SwingConstants.LEFT);
		labType.setBackground(Color.WHITE);
		labType.setBorder(padd);//(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
		labType.setPreferredSize(new Dimension(50, 20));
		
		this.add(labTime);
		this.add(labDest);
		this.add(labSource);
		this.add(labStatus);
		this.add(labType);
		
		this.setPreferredSize(new Dimension(100 + 100 + 50 + 50 + 80, 20));
	}
}
