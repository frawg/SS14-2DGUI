package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
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
	private final String vertDev = "<html><p style=\"padding:1\">D<br/>E<br/>V<br/>I<br/>C<br/>E</p></html>";
	private final String vertTool = "<html><p style=\"padding:1\">T<br/>O<br/>O<br/>L<br/>S</p></html>";
	private final String horiDev = "DEVICE";
	private final String horiTool = "TOOLS";
	public JToggleButton lineButton,deleteButton;
	private JTabbedPane tab = null;
	private JPanel devPalate, toolPalate = null;
	private ImageIcon iconPC, iconHUB, iconROUTER, iconSWITCH, iconLINE,iconDELETE = null;
	private GridLayout devGrid, toolsGrid = null;
	private int x, y = 100;
	private JCustomBtnLabel hubLabel, switchLabel, routLabel, pcLabel = null;
	private WorkAreaUI work = null;
	private int com, hub, swi = 0;
	
	public PalateUI(WorkAreaUI twork)
	{
		this.work = twork;
		
		tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.LEFT);
		//tab.setPreferredSize(new Dimension(200, 400));
		tab.setOpaque(false);
		tab.setBorder(null);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(200, 400));
		this.setMinimumSize(this.getPreferredSize());
		
		iconPC = new ImageIcon(PalateUI.class.getResource("/Images/PC.png"), "Computer");
		iconSWITCH = new ImageIcon(PalateUI.class.getResource("/Images/switch.png"), "Switch");
		iconHUB = new ImageIcon(PalateUI.class.getResource("/Images/hub.gif"), "Hub");
		iconROUTER = new ImageIcon(PalateUI.class.getResource("/Images/router.jpeg"), "Router");
		iconLINE = new ImageIcon(PalateUI.class.getResource("/Images/line.jpg"), "Line");
		iconDELETE = new ImageIcon(PalateUI.class.getResource("/Images/cross.png"), "Cross");
		
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
		
		routLabel = new JCustomBtnLabel("Router", iconROUTER);
		routLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {
                            
				GUI.Component.Labels.JLabel temp = new GUI.Component.Labels.JLabel("Router",
                                        new ImageIcon(iconROUTER.getImage().getScaledInstance(50, 50, 0)), JLabel.CENTER);
				temp.setType(Type.ROUTER);
				temp.setVerticalTextPosition(JLabel.BOTTOM);
				temp.setHorizontalTextPosition(JLabel.CENTER);
				work.setSelected(temp);
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
		
		this.devGrid = new GridLayout(0,2);
		this.devPalate = new JPanel();
		devPalate.setBorder(new LineBorder(Color.WHITE));
		this.devPalate.setBackground(Color.WHITE);
		
		devPalate.setLayout(devGrid);
		devPalate.add(pcLabel);
		devPalate.add(routLabel);
		devPalate.add(hubLabel);
		devPalate.add(switchLabel);
		tab.addTab(vertDev, devPalate);
		
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
					work.deleteLine(deleteButton,true);
					lineButton.setSelected(false);
				}
				if(evt.getStateChange()==ItemEvent.DESELECTED)
				{
					//flag here
					work.cancelDelete(false);
				}
			}
		});
		
		this.toolPalate = new JPanel();
		this.toolPalate.setLayout(new GridLayout(0,2));
		this.toolPalate.setBackground(Color.WHITE);
		
		toolPalate.add(lineButton);
		toolPalate.add(deleteButton);
//		toolPalate.add(new JLabel());
//		toolPalate.add(new JLabel());
//		toolPalate.add(new JLabel());
		
		tab.addTab(vertTool, toolPalate);
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
				if(tabbedPane.getSelectedIndex()==0 )
				{
					lineButton.setSelected(false);
					deleteButton.setSelected(false);
					work.cancelDelete(false);
					
				}
			}
		});
		
		horizontalOutlook();
		
		this.add(tab, BorderLayout.CENTER);
		this.setOpaque(false);
	}
	
	private void horizontalOutlook()
	{
		this.setPreferredSize(new Dimension(400, 200));
		this.setMinimumSize(this.getPreferredSize());
		tab.setTabPlacement(JTabbedPane.TOP);
		tab.setTitleAt(0, horiDev);
		tab.setTitleAt(1, horiTool);
	}
	
	private void verticalOutlook()
	{
		this.setPreferredSize(new Dimension(200, 400));
		this.setMinimumSize(this.getPreferredSize());
		tab.setTitleAt(0, vertDev);
		tab.setTitleAt(1, vertTool);
	}
}
