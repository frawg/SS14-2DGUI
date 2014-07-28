package GUI.Component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import GUI.Component.Labels.JLabel;


public class DeviceProperties extends JFrame
{
	
	private JButton jbApply, jbCancel;
	private JLabel jlHostName, jlReceiveBuff,jlSendBuff,jlProtocols;
	private JLabel jlIPV4, jlGateway,jlSubnet,jlMacAddress,jlMacAddressDisplay;
	private JTextField jtfHostName, jtfReceiveBuff,jtfSendBuff,jtfProtocols;
	private JTextField jtfIPV4, jtfGateway, jtfSubnet;
	private JCheckBox jcbDeviceShutdown, jcbPortShutdown;
	private JPanel mainPanel, topPanel,midPanel,btmPanel,containerPanel,comboBoxPanel;
	private JComboBox<String> jcbPort;
	private TitledBorder deviceTitle = null,portTitle = null;
	String[] ports = { "Port1", "Port2", "Port3", "Port4", "Port5" };
	
	public DeviceProperties() {
		
		
		 
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
		
		jcbPort = new JComboBox<String>(ports);
		jcbPort.setSelectedIndex(0);
		jcbPort.setEditable(false);
		
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
		jlMacAddressDisplay = new JLabel("test mac address");
		
		jtfHostName = new JTextField(20);
		jtfReceiveBuff = new JTextField(20);
	    jtfSendBuff = new JTextField(20);
	    jtfProtocols = new JTextField(20);
	    jtfIPV4 = new JTextField(20);
	    jtfGateway = new JTextField(20);
	    jtfSubnet = new JTextField(20);
	    
		jcbDeviceShutdown = new JCheckBox("Shutdown?");
		jcbDeviceShutdown.setHorizontalTextPosition(SwingConstants.LEFT);
		jcbDeviceShutdown.setSelected(false);
		jcbPortShutdown = new JCheckBox("Shutdown?");
		jcbPortShutdown.setHorizontalTextPosition(SwingConstants.LEFT);
		jcbPortShutdown.setSelected(false);
		
		Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		deviceTitle = BorderFactory.createTitledBorder("Device Properties");
		portTitle = BorderFactory.createTitledBorder("Port Properties");
		
		
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.setBorder(paneEdge);
		topPanel.setBorder(deviceTitle);
		midPanel.setBorder(portTitle);
		
		topPanel.add(jlHostName);			topPanel.add(jtfHostName);
		topPanel.add(jlReceiveBuff);		topPanel.add(jtfReceiveBuff);
		topPanel.add(jlSendBuff);			topPanel.add(jtfSendBuff);
		topPanel.add(jlProtocols);			topPanel.add(jtfProtocols);
		topPanel.add(jcbDeviceShutdown);	
		
		comboBoxPanel.add(jcbPort);
		
		midPanel.add(jlIPV4);				midPanel.add(jtfIPV4);
		midPanel.add(jlGateway);			midPanel.add(jtfGateway);
		midPanel.add(jlSubnet);				midPanel.add(jtfSubnet);
		midPanel.add(jlMacAddress);			midPanel.add(jlMacAddressDisplay);
		midPanel.add(jcbPortShutdown);	
		
		btmPanel.add(jbApply);	
		btmPanel.add(Box.createRigidArea(new Dimension(10,0)));
		btmPanel.add(jbCancel);
		
		containerPanel.add(topPanel);
		containerPanel.add(comboBoxPanel);
		containerPanel.add(midPanel);
		containerPanel.add(btmPanel);
		
		mainPanel.add(containerPanel);
		
		this.add(mainPanel);  
		
		setTitle("Properties");
		setVisible(true);
		setResizable(false);
		setPreferredSize(new Dimension(getPreferredSize()));
		pack();	
		
}
	
	 }
	
	
	
