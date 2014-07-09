package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class PalateUI extends JPanel
{
//	private JLabel devPLabel, toolsPLabel, icPCLabel, icHUBLabel, icROUTERLabel, icSWITCHLabel = null;
	private JButton devPLabel, toolsPLabel, icPCLabel, icHUBLabel, icROUTERLabel, icSWITCHLabel = null;
	private JTabbedPane tab = null;
	private JPanel devPalate, toolsPalate = null;
	private ImageIcon iconPC, iconHUB, iconROUTER, iconSWITCH = null;
	private GridLayout devGrid, toolsGrid = null;
	private int x, y = 100;
	
	public PalateUI()
	{
		tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.LEFT);
		tab.setPreferredSize(new Dimension(200, 400));
		tab.setOpaque(false);
		tab.setBorder(new LineBorder(Color.WHITE));
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 400));
		this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		
		iconPC = new ImageIcon(PalateUI.class.getResource("/Images/PC.png"), "Computer");
		iconSWITCH = new ImageIcon(PalateUI.class.getResource("/Images/switch.png"), "Switch");
		iconHUB = new ImageIcon(PalateUI.class.getResource("/Images/hub.gif"), "Hub");
		iconROUTER = new ImageIcon(PalateUI.class.getResource("/Images/router.jpeg"), "Router");
		
//		iconPC.getImage().getScaledInstance(x, y, 0);
//		iconHUB.getImage().getScaledInstance(x, y, 0);
//		iconROUTER.getImage().getScaledInstance(x, y, 0);
//		iconSWITCH.getImage().getScaledInstance(x, y, 0);
		
		icPCLabel = new JButton("Computer");
		icPCLabel.setIcon(new ImageIcon(iconPC.getImage().getScaledInstance(50, 50, 0)));
		icPCLabel.setOpaque(false);
		icPCLabel.setBorder(null);
		icPCLabel.setHorizontalTextPosition(JLabel.CENTER);
		icPCLabel.setVerticalTextPosition(JLabel.BOTTOM);
		
		icHUBLabel = new JButton("Hub");
		icHUBLabel.setIcon(new ImageIcon(iconHUB.getImage().getScaledInstance(50, 50, 0)));
		icHUBLabel.setOpaque(false);
		icHUBLabel.setBorder(null);
		icHUBLabel.setHorizontalTextPosition(JLabel.CENTER);
		icHUBLabel.setVerticalTextPosition(JLabel.BOTTOM);
		
		icSWITCHLabel = new JButton("Switch");
		icSWITCHLabel.setIcon(new ImageIcon(iconSWITCH.getImage().getScaledInstance(50, 50, 0)));
		icSWITCHLabel.setOpaque(false);
		icSWITCHLabel.setBorder(null);
		icSWITCHLabel.setHorizontalTextPosition(JLabel.CENTER);
		icSWITCHLabel.setVerticalTextPosition(JLabel.BOTTOM);
		
		icROUTERLabel = new JButton("Router");
		icROUTERLabel.setIcon(new ImageIcon(iconROUTER.getImage().getScaledInstance(50, 50, 0)));
		icROUTERLabel.setOpaque(false);
		icROUTERLabel.setBorder(null);
		icROUTERLabel.setHorizontalTextPosition(JLabel.CENTER);
		icROUTERLabel.setVerticalTextPosition(JLabel.BOTTOM);
		
		this.devGrid = new GridLayout(0,2);
		this.devPalate = new JPanel();
		devPalate.setBorder(new LineBorder(Color.WHITE));
		this.devPalate.setBackground(Color.WHITE);
		
		devPalate.setLayout(devGrid);
		devPalate.add(icPCLabel);
		devPalate.add(icHUBLabel);
		devPalate.add(icSWITCHLabel);
		devPalate.add(icROUTERLabel);
		tab.addTab("<html><p style=\"padding:1\">D<br/>E<br/>V<br/>I<br/>C<br/>E</p></html>", devPalate);
		
		this.toolsPalate = new JPanel();
		this.toolsPalate.setLayout(new GridLayout(0,2));
		this.toolsPalate.setBackground(Color.WHITE);
		tab.addTab("<html><p style=\"padding:1\">T<br/>O<br/>O<br/>L<br/>S</p></html>", toolsPalate);
		
		this.add(tab, BorderLayout.CENTER);
		this.setOpaque(false);
		
//		this.devPLabel = new JLabel("Device");
//		this.devPLabel.setUI(new VerticalLabelUI(false));
//		this.setTabComponentAt(0, devPLabel);
//		this.toolsPLabel = new JLabel("Tools");
//		this.toolsPLabel.setUI(new VerticalLabelUI(false)); 
//		this.setTabComponentAt(1, toolsPLabel);
	}
}
