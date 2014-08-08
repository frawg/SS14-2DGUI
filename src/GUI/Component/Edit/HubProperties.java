package GUI.Component.Edit;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import GUI.Component.Labels.JLabel;

public class HubProperties extends JFrame
{
	private JButton jbApply, jbCancel;
	private JLabel jlHostName, jlReceiveBuff,jlSendBuff,jlProtocols;
	private JLabel jlIPV4, jlGateway,jlSubnet,jlMacAddress;
	private JTextField jtfHostName, jtfReceiveBuff,jtfSendBuff,jtfProtocols,jlMacAddressDisplay;
	private JTextField jtfIPV4, jtfGateway, jtfSubnet;
	private JPanel mainPanel, topPanel,midPanel,btmPanel,containerPanel,comboBoxPanel;
	private TitledBorder deviceTitle = null,portTitle = null;
	
	public HubProperties(Nodes.HUB comp) {
		mainPanel = new JPanel();
		topPanel = new JPanel();
		midPanel = new JPanel();
		btmPanel = new JPanel();
		containerPanel = new JPanel();
		comboBoxPanel = new JPanel();
		
		mainPanel.setLayout(new FlowLayout());
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.Y_AXIS));
		topPanel.setLayout(new GridLayout(7,2));
		midPanel.setLayout(new GridLayout(7,2));
		btmPanel.setLayout(new FlowLayout());
		comboBoxPanel.setLayout(new FlowLayout());
		
		jbApply = new JButton("Apply");
		jbCancel = new JButton("Cancel");
		
		jlHostName = new JLabel("HostName");
		jlReceiveBuff = new JLabel("Receive Buffer");
		jlSendBuff = new JLabel("Send Buffer");
		jlProtocols = new JLabel("Protocols");
		jlIPV4 = new JLabel("IPv4 Address"); 
		jlGateway = new JLabel("Gateway");
		jlSubnet = new JLabel("Subnet");
		jlMacAddress = new JLabel("MAC Address");		
		
		jtfHostName = new JTextField(20);
		jtfHostName.setEditable(Boolean.FALSE);
		jtfHostName.setOpaque(Boolean.TRUE);
		jtfReceiveBuff = new JTextField(20);
		jtfSendBuff = new JTextField(20);
		jtfProtocols = new JTextField(20);
		jtfProtocols.setEditable(Boolean.FALSE);
		jtfProtocols.setOpaque(Boolean.TRUE);
		jtfIPV4 = new JTextField(20);
		jtfGateway = new JTextField(20);
		jtfSubnet = new JTextField(20);
		jlMacAddressDisplay = new JTextField(20);
		jlMacAddressDisplay.setEditable(Boolean.FALSE);
		jlMacAddressDisplay.setOpaque(Boolean.TRUE);
		
		/* Populate Values */
		jtfHostName.setText("N/A");
		jtfReceiveBuff.setText("N/A");
		jtfSendBuff.setText("N/A");
		jtfProtocols.setText("N/A");
		jtfIPV4.setText("N/A");
		jtfGateway.setText("N/A");
		jtfSubnet.setText("N/A");
		jlMacAddressDisplay.setText("N/A");
             
		Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		deviceTitle = BorderFactory.createTitledBorder("Device Properties");
		portTitle = BorderFactory.createTitledBorder("N/A");
		
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.setBorder(paneEdge);
		topPanel.setBorder(deviceTitle);
		midPanel.setBorder(portTitle);
		
		topPanel.add(jlHostName);			topPanel.add(jtfHostName);
		topPanel.add(jlReceiveBuff);		topPanel.add(jtfReceiveBuff);
		topPanel.add(jlSendBuff);			topPanel.add(jtfSendBuff);
		topPanel.add(jlProtocols);			topPanel.add(jtfProtocols);
		
		midPanel.add(jlIPV4);				midPanel.add(jtfIPV4);
		midPanel.add(jlGateway);			midPanel.add(jtfGateway);
		midPanel.add(jlSubnet);				midPanel.add(jtfSubnet);
		midPanel.add(jlMacAddress);			midPanel.add(jlMacAddressDisplay);
		
		btmPanel.add(jbApply);	
		btmPanel.add(Box.createRigidArea(new Dimension(10,0)));
		btmPanel.add(jbCancel);
		
		containerPanel.add(topPanel);
		containerPanel.add(midPanel);
		containerPanel.add(btmPanel);
		
		mainPanel.add(containerPanel);
		
		this.add(mainPanel);  
		
		setTitle(comp.getguiID()+" Properties");
		setVisible(true);
		setResizable(false);
		setPreferredSize(new Dimension(getPreferredSize()));
		pack();	
	}
}
	
	
	
