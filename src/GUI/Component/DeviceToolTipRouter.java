package GUI.Component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import GUI.Component.Labels.JLabel;
import GUI.Component.Labels.ToolTipPortRow;

public class DeviceToolTipRouter extends JPanel {

	private JLabel hostname, type = null;
	private ToolTipPortRow header = null;
	private JPanel headPanel = null;
	
        /* Overloaded Constructor for Computer */
        public DeviceToolTipRouter(Nodes.ROUTER r){
                System.out.println("hovering above router");
            
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.hostname = new JLabel(r.getguiID());
                type = new JLabel("Router");
                
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
	
        
	public DeviceToolTipRouter(String hostname, String type){
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
        public void AddRowForRouter(Nodes.ROUTER r)
	{
		add(new ToolTipPortRow(r.ipInterface.getinterfaceID(),r.ipInterface.getIPAddress(),
                        "UP",r.ipInterface.getMACAddress()));
	}      
	public void refreshSize() { this.setSize(this.getPreferredSize()); }
}
