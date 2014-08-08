package GUI.Component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import GUI.Component.Labels.JLabel;
import GUI.Component.Labels.ToolTipPortRow;

public class DeviceToolTipSwitch extends JPanel {
	private JLabel hostname, type = null;
	private ToolTipPortRow header = null;
	private JPanel headPanel = null;
	
	/* Overloaded Constructor for Computer */
	public DeviceToolTipSwitch(Nodes.SWITCH s){
		System.out.println("hovering above switch");
            
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.hostname = new JLabel(s.getguiID());
		type = new JLabel("Switch");
                
		headPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		headPanel.add(new JLabel("Hostname: "));
		headPanel.add(this.hostname);
		
		JLabel blank = new JLabel();
		blank.setPreferredSize(new Dimension(20,20));
		headPanel.add(blank);
		
		headPanel.add(new JLabel("Type: "));
		headPanel.add(this.type);
		
		add(headPanel);
		
		header = new ToolTipPortRow();
		add(header);                                
		add(new JSeparator(JSeparator.HORIZONTAL));
		
		refreshSize();
	}
	
        
	public DeviceToolTipSwitch(String hostname, String type){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.hostname = new JLabel(hostname);
		this.type = new JLabel(type);
		
		headPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		headPanel.add(new JLabel("Hostname: "));
		headPanel.add(this.hostname);
		
		JLabel blank = new JLabel();
		blank.setPreferredSize(new Dimension(20,20));
		headPanel.add(blank);
		
		headPanel.add(new JLabel("Type: "));
		headPanel.add(this.type);
		
		add(headPanel);
		
		header = new ToolTipPortRow();
		add(header);
		add(new JSeparator(JSeparator.HORIZONTAL));
		
		refreshSize();
	}
	
	public void Add(String portname, String ip, String status, String mac)
	{
		add(new ToolTipPortRow(portname, ip, status, mac));
	}
	public void Add()
	{
		add(new ToolTipPortRow());
	}
	public void AddRowForSwitch(Nodes.SWITCH s)
	{
		//add(new ToolTipPortRow("id here", "", "UP", s.getMACAddress(0)));
		for (int i = 0; i < s.getSwitchTable().length; i++)
			add(new ToolTipPortRow("" + i, "", "UP", s.getMACAddress(i)));
	}      
	public void refreshSize() { this.setSize(this.getPreferredSize()); }
}
