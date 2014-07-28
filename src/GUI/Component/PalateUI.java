package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;



import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.Component.Labels.JCustomBtnLabel;
import GUI.Component.Labels.JLabel.Type;

public class PalateUI extends JPanel{
	private JLabel devPLabel, toolsPLabel, icPCLabel, icHUBLabel, /*icROUTERLabel,*/ icSWITCHLabel, icLINELabel, icDeleteLabel = null;
	//private JButton devPLabel, toolsPLabel, icPCLabel, icHUBLabel, icROUTERLabel, icSWITCHLabel = null;
	public JToggleButton lineButton,deleteButton;
	private JTabbedPane tab = null;
	private JPanel devPalate, toolsPalate = null;
	private ImageIcon iconPC, iconHUB, iconROUTER, iconSWITCH, iconLINE,iconDELETE = null;
	private GridLayout devGrid, toolsGrid = null;
	private int x, y = 100;
	private JCustomBtnLabel hubLabel, switchLabel, pcLabel, lineLabel,deleteLabel= null;
	private WorkAreaUI work = null;
	private int com, hub, swi = 0;
	private Point start,end; 
	
	
	public PalateUI(WorkAreaUI twork)
	{
		this.work = twork;
		
		tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.LEFT);
		tab.setPreferredSize(new Dimension(200, 400));
		tab.setOpaque(false);
		//tab.setBorder(new LineBorder(Color.WHITE));
		tab.setBorder(null);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 400));
		//this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(this.getPreferredSize());
		
		iconPC = new ImageIcon(PalateUI.class.getResource("/Images/PC.png"), "Computer");
		iconSWITCH = new ImageIcon(PalateUI.class.getResource("/Images/switch.png"), "Switch");
		iconHUB = new ImageIcon(PalateUI.class.getResource("/Images/hub.gif"), "Hub");
		iconROUTER = new ImageIcon(PalateUI.class.getResource("/Images/router.jpeg"), "Router");
		iconLINE = new ImageIcon(PalateUI.class.getResource("/Images/line.jpg"), "Line");
		iconDELETE = new ImageIcon(PalateUI.class.getResource("/Images/cross.png"), "Cross");
		
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
		
		pcLabel = new JCustomBtnLabel("Computer", iconPC);
		pcLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
				GUI.Component.Labels.JLabel temp = new GUI.Component.Labels.JLabel("Computer"+com, new ImageIcon(iconPC.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
				temp.setType(Type.COMPUTER);
				temp.setVerticalTextPosition(JLabel.BOTTOM);
				temp.setHorizontalTextPosition(JLabel.CENTER);
				work.setSelected(temp);
				com += 1;
			}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			});
		
		hubLabel = new JCustomBtnLabel("Hub", iconHUB);
		hubLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
				GUI.Component.Labels.JLabel temp = new GUI.Component.Labels.JLabel("HUB"+hub, new ImageIcon(iconHUB.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
				temp.setType(Type.HUB);
				temp.setVerticalTextPosition(JLabel.BOTTOM);
				temp.setHorizontalTextPosition(JLabel.CENTER);
				work.setSelected(temp);
				hub += 1;
			}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		switchLabel = new JCustomBtnLabel("Switch", iconSWITCH);
		switchLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
				GUI.Component.Labels.JLabel temp = new GUI.Component.Labels.JLabel("Switch"+swi, new ImageIcon(iconSWITCH.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
				temp.setType(Type.SWITCH);
				temp.setVerticalTextPosition(JLabel.BOTTOM);
				temp.setHorizontalTextPosition(JLabel.CENTER);
				work.setSelected(temp);
				swi += 1;
			}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
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
		
		lineButton = new JToggleButton("Line");
		lineButton.setSelected(false);
		lineButton.setBackground(Color.WHITE);
		lineButton.setOpaque(false);
		lineButton.setBorder(null);
		lineButton.setIcon(new ImageIcon(iconLINE.getImage()));
		lineButton.setHorizontalTextPosition(JToggleButton.CENTER);
		lineButton.setVerticalTextPosition(JToggleButton.BOTTOM);
		lineButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange()==ItemEvent.SELECTED)
				{
					//flag here
					work.setLine(lineButton, true);
					deleteButton.setSelected(false);
				}
				if(evt.getStateChange()==ItemEvent.DESELECTED)
				{
					//flag here
					work.cancelLine(false);
				}
			}
		});
		
		deleteButton = new JToggleButton("Delete");
		deleteButton.setSelected(false);
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setOpaque(false);
		deleteButton.setBorder(null);
		deleteButton.setIcon(new ImageIcon(iconDELETE.getImage()));
		deleteButton.setHorizontalTextPosition(JToggleButton.CENTER);
		deleteButton.setVerticalTextPosition(JToggleButton.BOTTOM);
		deleteButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange()==ItemEvent.SELECTED)
				{
					//flag here
				//	work.setLine(lineButton, true);
					work.deleteLine(deleteButton,true);
					lineButton.setSelected(false);
				}
				if(evt.getStateChange()==ItemEvent.DESELECTED)
				{
					//flag here
					work.cancelDeleteLine(false);
				}
			}
		});
		
		this.toolsPalate = new JPanel();
		this.toolsPalate.setLayout(new GridLayout(0,2));
		this.toolsPalate.setBackground(Color.WHITE);
		
		toolsPalate.add(lineButton);
		toolsPalate.add(deleteButton);
		toolsPalate.add(new JLabel());
		toolsPalate.add(new JLabel());
		toolsPalate.add(new JLabel());
		
		tab.addTab("<html><p style=\"padding:1\">T<br/>O<br/>O<br/>L<br/>S</p></html>", toolsPalate);
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
				if(tabbedPane.getSelectedIndex()==0 )
				{
					System.out.println(tabbedPane.getSelectedIndex());
					lineButton.setSelected(false);
					deleteButton.setSelected(false);
					
				}
			}
		});
			
		
		
		this.add(tab, BorderLayout.CENTER);
		this.setOpaque(false);
		
//		this.devPLabel = new JLabel("Device");
//		this.devPLabel.setUI(new VerticalLabelUI(false));
//		this.setTabComponentAt(0, devPLabel);
//		this.toolsPLabel = new JLabel("Tools");
//		this.toolsPLabel.setUI(new VerticalLabelUI(false)); 
//		this.setTabComponentAt(1, toolsPLabel);
	}
	//public void toggleButton(boolean c){lineButton.setSelected(false);}
	
}
