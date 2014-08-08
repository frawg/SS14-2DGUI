package GUI.Component.Labels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ToolTipPortRow extends JPanel {
	private JLabel portname, ipv4, status, macaddress;
	
	public ToolTipPortRow(){

		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setMinimumSize(new Dimension(400, 20));
		this.setPreferredSize(new Dimension(420, 20));
		this.setMaximumSize(this.getPreferredSize());

		portname = new JLabel("Interface #"/*"FastEthernet 0/1/30"*/);
		portname.setPreferredSize(new Dimension(85,10));
		
		this.ipv4 = new JLabel("IP Address"/*"255.255.255.255"*/);
		this.ipv4.setPreferredSize(new Dimension(80,10));
		
		this.status = new JLabel("Status");
		this.status.setPreferredSize(new Dimension(40,10));
		
		macaddress = new JLabel("MAC Address"/*"0000.0000.0000"*/);
		macaddress.setPreferredSize(new Dimension(120,10));
		
		JLabel blank = new JLabel();
		blank.setPreferredSize(new Dimension(20,10));
		JLabel blank1 = new JLabel();
		blank1.setPreferredSize(new Dimension(20,10));
		JLabel blank2 = new JLabel();
		blank2.setPreferredSize(new Dimension(20,10));
		
		this.add(portname);
		this.add(blank);
		this.add(this.ipv4);
		this.add(blank1);
		this.add(this.status);
		this.add(blank2);
		this.add(macaddress);
	}
	
	public ToolTipPortRow(String name, String ipv4, String status, String mac){
		this();
		portname.setText(name);
		this.ipv4.setText(ipv4);
		this.status.setText(status);
		macaddress.setText(mac);
	}
}
