package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import GUI.Component.Labels.JCustomHubLabel;
import GUI.Component.Labels.JCustomPCLabel;
import GUI.Component.Labels.JCustomSwitchLabel;

public class PalateUI extends JPanel implements MouseListener
{
	private JLabel devPLabel, toolsPLabel, icPCLabel, icHUBLabel, /*icROUTERLabel,*/ icSWITCHLabel = null;
	//private JButton devPLabel, toolsPLabel, icPCLabel, icHUBLabel, icROUTERLabel, icSWITCHLabel = null;
	private JTabbedPane tab = null;
	private JPanel devPalate, toolsPalate = null;
	private ImageIcon iconPC, iconHUB, iconROUTER, iconSWITCH = null;
	private GridLayout devGrid, toolsGrid = null;
	private int x, y = 100;
	private JCustomSwitchLabel switchLabel = null;
	private JCustomPCLabel pcLabel = null;
	private JCustomHubLabel hubLabel = null;
	
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
		
//		icPCLabel = new JLabel("Computer", new ImageIcon(iconPC.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
//		icPCLabel.setVerticalTextPosition(JLabel.BOTTOM);
//		icPCLabel.setHorizontalTextPosition(JLabel.CENTER);
//		
//		icHUBLabel = new JLabel("Hub", new ImageIcon(iconHUB.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
//		icHUBLabel.setVerticalTextPosition(JLabel.BOTTOM);
//		icHUBLabel.setHorizontalTextPosition(JLabel.CENTER);
//		
//		icSWITCHLabel = new JLabel("Switch", new ImageIcon(iconSWITCH.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
//		icSWITCHLabel.setVerticalTextPosition(JLabel.BOTTOM);
//		icSWITCHLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		pcLabel = new JCustomPCLabel();
		hubLabel = new JCustomHubLabel();
		switchLabel = new JCustomSwitchLabel();
		
//		icPCLabel = new JButton("Computer");
//		icPCLabel.setIcon(new ImageIcon(iconPC.getImage().getScaledInstance(50, 50, 0)));
//		icPCLabel.setOpaque(false);
//		icPCLabel.setBorder(null);
//		icPCLabel.setHorizontalTextPosition(JLabel.CENTER);
//		icPCLabel.setVerticalTextPosition(JLabel.BOTTOM);
//		
//		icHUBLabel = new JButton("Hub");
//		icHUBLabel.setIcon(new ImageIcon(iconHUB.getImage().getScaledInstance(50, 50, 0)));
//		icHUBLabel.setOpaque(false);
//		icHUBLabel.setBorder(null);
//		icHUBLabel.setHorizontalTextPosition(JLabel.CENTER);
//		icHUBLabel.setVerticalTextPosition(JLabel.BOTTOM);
//		
//		icSWITCHLabel = new JButton("Switch");
//		icSWITCHLabel.setIcon(new ImageIcon(iconSWITCH.getImage().getScaledInstance(50, 50, 0)));
//		icSWITCHLabel.setOpaque(false);
//		icSWITCHLabel.setBorder(null);
//		icSWITCHLabel.setHorizontalTextPosition(JLabel.CENTER);
//		icSWITCHLabel.setVerticalTextPosition(JLabel.BOTTOM);
//		
//		icROUTERLabel = new JButton("Router");
//		icROUTERLabel.setIcon(new ImageIcon(iconROUTER.getImage().getScaledInstance(50, 50, 0)));
//		icROUTERLabel.setOpaque(false);
//		icROUTERLabel.setBorder(null);
//		icROUTERLabel.setHorizontalTextPosition(JLabel.CENTER);
//		icROUTERLabel.setVerticalTextPosition(JLabel.BOTTOM);
		
		this.devGrid = new GridLayout(0,2);
		this.devPalate = new JPanel();
		devPalate.setBorder(new LineBorder(Color.WHITE));
		this.devPalate.setBackground(Color.WHITE);
		
		devPalate.setLayout(devGrid);
//		devPalate.add(icPCLabel);
//		devPalate.add(icHUBLabel);
		//devPalate.add(icSWITCHLabel);
		//devPalate.add(icROUTERLabel);
		devPalate.add(pcLabel);
		devPalate.add(hubLabel);
		devPalate.add(switchLabel);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
