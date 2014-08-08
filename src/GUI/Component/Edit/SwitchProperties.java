package GUI.Component.Edit;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class SwitchProperties extends JFrame
{
	private JButton jbApply, jbCancel;
	private JLabel jlHostName, jlReceiveBuff,jlSendBuff,jlProtocols;
	private JLabel [] jlMacAddress;
	private JTextField jtfHostName, jtfProtocols;
	private JTextField[] jlMacAddressDisplay;
	private JPanel mainPanel, topPanel,midPanel,btmPanel,containerPanel,comboBoxPanel;
	private JComboBox<String> jcbPort;
	private TitledBorder deviceTitle = null,portTitle = null;
	private JLabel portNumbHeading = new JLabel("Port #");
	private JLabel macAddressHeading = new JLabel("MAC Address");
        
	public SwitchProperties(final Nodes.SWITCH s) {
		jlMacAddress = new JLabel[Globals.Globals.numbSwitchPorts];
		jlMacAddressDisplay = new JTextField[Globals.Globals.numbSwitchPorts];
               
		final JFrame frame = this;
		mainPanel = new JPanel();
		topPanel = new JPanel();
		midPanel = new JPanel();
		btmPanel = new JPanel();
		containerPanel = new JPanel();
		comboBoxPanel = new JPanel();
		
		mainPanel.setLayout(new FlowLayout());
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.Y_AXIS));
		topPanel.setLayout(new GridLayout(3,2));
		midPanel.setLayout(new GridLayout(17,2));
		btmPanel.setLayout(new FlowLayout());
		comboBoxPanel.setLayout(new FlowLayout());
		
		jbApply = new JButton("Cancel");
		jbCancel = new JButton("OK");
		
		jlHostName = new JLabel("HostName");
		jlProtocols = new JLabel("Protocol");	
                
		for(int i=0; i < Globals.Globals.numbSwitchPorts; i++){
			System.out.println("i = "+i);
			jlMacAddress[i] = new JLabel(""+i);                    
			jlMacAddressDisplay[i] = new JTextField(20);
			jlMacAddressDisplay[i].setEditable(Boolean.FALSE);
			jlMacAddressDisplay[i].setText(s.getMACAddress(i));
		}
		
		jtfHostName = new JTextField(20);
		jtfHostName.setEditable(Boolean.FALSE);
		jtfHostName.setOpaque(Boolean.TRUE);
		jtfProtocols = new JTextField(20);
		jtfProtocols.setEditable(Boolean.FALSE);
		jtfProtocols.setOpaque(Boolean.TRUE);

		/* Populate Values */
		jtfHostName.setText(s.getguiID());
		jtfProtocols.setText("Ethernet");
                                             		
		Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		deviceTitle = BorderFactory.createTitledBorder("Device Properties");
		portTitle = BorderFactory.createTitledBorder("Switch Ports");		
		
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.setBorder(paneEdge);
		topPanel.setBorder(deviceTitle);
		midPanel.setBorder(portTitle);
		
		topPanel.add(jlHostName);			topPanel.add(jtfHostName);
		topPanel.add(jlProtocols);			topPanel.add(jtfProtocols);

		midPanel.add(portNumbHeading);
		midPanel.add(macAddressHeading);
                 
		for(int i=0; i < Globals.Globals.numbSwitchPorts; i++){
			midPanel.add(jlMacAddress[i]);			
			midPanel.add(jlMacAddressDisplay[i]);
		}	
		
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
				frame.dispose();
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
                
		setTitle(s.getguiID() + " Properties");
		setVisible(true);
		setResizable(false);
		setPreferredSize(new Dimension(getPreferredSize()));
		pack();	
	}
}
	
	
	
