package GUI.Component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PingBox extends JFrame
{
	private JLabel jlblPing = new JLabel("Ping");
	private JLabel jlblHostname = new JLabel("Origin Device Hostname : ",JLabel.RIGHT);
	private JLabel jlblYourname = new JLabel("getDeviceName()");
	private JLabel jlblDesIP = new JLabel("Destination IP : ",JLabel.RIGHT);
	private JLabel kosong = new JLabel("");
	private JLabel aColon = null;
	
	private JTextField jtfDesIP = new JTextField("");
	
	private JTextArea results = new JTextArea(10,25);
	
	private JScrollPane jtaResults = new JScrollPane(results);
	
	private JButton btnPing = new JButton("Ping!");
	
	public PingBox()
	{
		JFrame frame = new JFrame("Ping");
		frame.setSize(400,300);
	    frame.setLayout(new BorderLayout());
	    
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3,2));
		JPanel jp2 = new JPanel();
		
		results.setEditable(false);
		results.setLineWrap(true);
		results.setText("Enter target IP Address and click Ping!\n");
		
		btnPing.addActionListener(new ButtonListener());
		
	    jp1.add(jlblHostname);
	    jp1.add(jlblYourname);
	    jp1.add(jlblDesIP);
	    jp1.add(jtfDesIP);
	    jp1.add(kosong);
	    jp1.add(btnPing);
	    
	    jp2.add(jtaResults);
	    
	    frame.add(jp1,BorderLayout.NORTH);
	    frame.add(jp2,BorderLayout.SOUTH);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}

	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(jtfDesIP.getText().length()==0)
			{
				results.append("Enter a Destination IP Address!\n");
			}
			else
			{
				//do some mambo jumbo
			}
		}
	}
}
