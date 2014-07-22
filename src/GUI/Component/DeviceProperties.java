package GUI.Component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.beans.Customizer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import GUI.Component.Labels.JLabel;


public class DeviceProperties extends JFrame
{

	private JButton jbApply = null;
	private JButton jbOK = null;
	private JButton jbApply1 = null;
	private JButton jbOK1 = null;
	private JButton jbOK2 = null;
	private JLabel jl = null;
	private JLabel jl1 = null;
	private JPanel mainP = null;
	private JPanel p1 = null;
	private JPanel p2 = null;
	private JPanel p3 = null;
	private JPanel p4 = null;
	Customizer customedialog;
	private TitledBorder deviceTitle = null,connectionTitle = null;
	
	public DeviceProperties() {
		mainP = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		
		mainP.setLayout(new FlowLayout());
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p2.setLayout(new GridLayout(1,2));
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		
		jbApply = new JButton("Apply");
		jbOK = new JButton("OK");
		jbApply1 = new JButton("Apply");
		jbOK1 = new JButton("OK");
		jbOK2 = new JButton("OK");
		jl1 = new JLabel("Device Name");
		jl = new JLabel("Device Type");
		
		
		
		Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		deviceTitle = BorderFactory.createTitledBorder("Edit Device Properties");
		connectionTitle = BorderFactory.createTitledBorder("Edit Connection Properties");
		
		p1.add(Box.createRigidArea(new Dimension(0, 10)));
		p1.setBorder(paneEdge);
		p2.setBorder(deviceTitle);
		p3.setBorder(connectionTitle);
		
		p2.add(jl1);
		p3.add(jl);
		p2.add(jbApply);
		p4.add(jbApply1);
		p3.add(jbOK);
		p3.add(jbOK1);
		p4.add(jbOK2);
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		
		mainP.add(p1);
		
		this.add(mainP);  
		
		setTitle("Properties");
		setVisible(true);
		setResizable(false);
		setPreferredSize(new Dimension(getPreferredSize()));
		pack();
}
						
		public static void main(String[] args)
		{
			DeviceProperties dp = new DeviceProperties();	
		}
		
	}	
	
