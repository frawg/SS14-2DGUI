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

import GUI.Component.WorkPanel;
import GUI.Component.Labels.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RouterProperties extends JFrame
{
	private JButton jbApply, jbCancel;
	private JLabel jlHostName, jlReceiveBuff,jlSendBuff,jlProtocols;
	private JLabel jlIPV4, jlGateway,jlSubnet,jlMacAddress;
	private JTextField jtfHostName, jtfReceiveBuff,jtfSendBuff,jtfProtocols,jlMacAddressDisplay;
	private JTextField jtfIPV4, jtfGateway, jtfSubnet;
	private JPanel mainPanel, topPanel,midPanel,btmPanel,containerPanel,comboBoxPanel;
	private TitledBorder deviceTitle = null,portTitle = null;
	
	public RouterProperties(final Nodes.ROUTER router) {
		this.requestFocus();
		final JFrame frame = this;
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
		
		jbApply = new JButton("Save");
		jbCancel = new JButton("OK");
		
		jlHostName = new JLabel("HostName");
		jlReceiveBuff = new JLabel("Receive Buffer");
		jlSendBuff = new JLabel("Send Buffer");
		jlProtocols = new JLabel("Protocols");
		jlIPV4 = new JLabel("IPv4 Address");
		jlSubnet = new JLabel("Subnet");
		jlGateway = new JLabel("Gateway");		
		jlMacAddress = new JLabel("MAC Address");		
		
		jtfHostName = new JTextField(20);
		jtfHostName.setEditable(Boolean.FALSE);
		jtfHostName.setOpaque(Boolean.TRUE);
		jtfReceiveBuff = new JTextField(20);
		jtfReceiveBuff.setEditable(Boolean.FALSE);
		jtfReceiveBuff.setOpaque(Boolean.TRUE);
		jtfSendBuff = new JTextField(20);
		jtfSendBuff.setEditable(Boolean.FALSE);
		jtfSendBuff.setOpaque(Boolean.TRUE);
		jtfProtocols = new JTextField(20);
        jtfProtocols.setEditable(Boolean.FALSE);
        jtfProtocols.setOpaque(Boolean.TRUE);
        jtfIPV4 = new JTextField(20);
        jtfSubnet = new JTextField(20);
        jtfGateway = new JTextField(20);
        jtfGateway.setEditable(Boolean.FALSE);
        jtfGateway.setOpaque(Boolean.TRUE);
        jlMacAddressDisplay = new JTextField(20);
        jlMacAddressDisplay.setEditable(Boolean.FALSE);
        jlMacAddressDisplay.setOpaque(Boolean.TRUE);
                
        /* Populate Values */
        jtfHostName.setText(router.getguiID());
        jtfReceiveBuff.setText(""+router.getrecvBuffer());
        jtfSendBuff.setText(""+router.getsendBuffer());
        jtfProtocols.setText("Ethernet, ARP, IPv4");
        jtfIPV4.setText(router.ipInterface.getIPAddress());
        jtfGateway.setText("Not Assigned");
        jtfSubnet.setText("255.255.255.0");
        jlMacAddressDisplay.setText(router.ipInterface.getMACAddress());
             
		Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		deviceTitle = BorderFactory.createTitledBorder("Device Properties");
		portTitle = BorderFactory.createTitledBorder("Network Interface");
		
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.setBorder(paneEdge);
		topPanel.setBorder(deviceTitle);
		midPanel.setBorder(portTitle);
		
		topPanel.add(jlHostName);			topPanel.add(jtfHostName);
		topPanel.add(jlReceiveBuff);		topPanel.add(jtfReceiveBuff);
		topPanel.add(jlSendBuff);			topPanel.add(jtfSendBuff);
		topPanel.add(jlProtocols);			topPanel.add(jtfProtocols);
		
		midPanel.add(jlIPV4);				midPanel.add(jtfIPV4);
        midPanel.add(jlSubnet);				midPanel.add(jtfSubnet);
		midPanel.add(jlGateway);			midPanel.add(jtfGateway);
		midPanel.add(jlMacAddress);			midPanel.add(jlMacAddressDisplay);

		btmPanel.add(jbApply);	
		btmPanel.add(Box.createRigidArea(new Dimension(10,0)));
		btmPanel.add(jbCancel);
		
		containerPanel.add(topPanel);
		containerPanel.add(midPanel);
		containerPanel.add(btmPanel);
		
		mainPanel.add(containerPanel);
		
		this.add(mainPanel);  
        
        /* Apply Button */
		jbApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Execute when button is pressed
				String ip = jtfIPV4.getText();
				boolean status = Network.NetworkOperations.validateIPAddress(ip);
				if (status == false) {
					JOptionPane.showMessageDialog(null, "Error in IP Address");
				} else if (status == true) {
					router.ipInterface.setIPAddress(ip);
					JOptionPane.showMessageDialog(null, "Changes Successful");
				}
			}
		});     

		/* Cancel Button */
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Execute when button is pressed
				frame.dispose();
			}
        }); 
                
		setTitle(router.getguiID()+" Properties");
		setVisible(true);
		setResizable(false);
		setPreferredSize(new Dimension(getPreferredSize()));
		pack();	
	}
}
	
	
	
