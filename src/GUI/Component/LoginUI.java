package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JPanel {
	private JPanel loginPanel, userPanel, pwPanel, buttonPanel = null;
	private JLabel userLabel, pwLabel, logoLabel = null;
	private ImageIcon logoIcon = null;
	private JTextField userField = null;
	private JPasswordField pwField = null;
	private JButton btnCancel, btnSubmit = null;
	
	public LoginUI(){
		this.setBackground(Color.WHITE);
		//this.setSize(new Dimension(600,300));
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setAlignmentY(CENTER_ALIGNMENT);
		this.setPreferredSize(new Dimension(600, 300));
		this.setMaximumSize(new Dimension(600,300));
		this.setMinimumSize(new Dimension(600,300));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		logoIcon = new ImageIcon(PalateUI.class.getResource("/Images/logo.jpg"), "Computer");
		logoLabel = new JLabel(logoIcon);
		logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		userLabel = new JLabel("Username: ");
		userField = new JTextField(20);
		
		userPanel = new JPanel(new FlowLayout());
		userPanel.setPreferredSize(new Dimension(300,30));
		userPanel.setMaximumSize(userPanel.getPreferredSize());
		userPanel.setBackground(Color.WHITE);
		userPanel.add(userLabel);
		userPanel.add(userField);
		
		pwLabel = new JLabel("Password: ");
		pwField = new JPasswordField(20);
		
		pwPanel = new JPanel(new FlowLayout());
		pwPanel.setPreferredSize(new Dimension(300,30));
		pwPanel.setMaximumSize(userPanel.getPreferredSize());
		pwPanel.setBackground(Color.WHITE);
		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		btnSubmit = new JButton("Submit");
		btnCancel = new JButton("Cancel");
		
		JLabel blank = new JLabel("");
		blank.setPreferredSize(new Dimension(80,10));
		buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setPreferredSize(new Dimension(300,35));
		buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.add(btnSubmit);
		buttonPanel.add(blank);
		buttonPanel.add(btnCancel);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.setPreferredSize(new Dimension(300,105));
		loginPanel.setMaximumSize(loginPanel.getPreferredSize());
		loginPanel.add(userPanel, Component.LEFT_ALIGNMENT);
		loginPanel.add(pwPanel, Component.LEFT_ALIGNMENT);
		loginPanel.add(buttonPanel, Component.LEFT_ALIGNMENT);
		
		this.add(logoLabel);
		this.add(loginPanel);
	}
}