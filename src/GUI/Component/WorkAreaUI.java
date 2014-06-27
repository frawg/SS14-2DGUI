package GUI.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class WorkAreaUI extends JPanel {
	private JPanel work = null;
	private JScrollPane scroll = null;
	
	public WorkAreaUI(){
		this.setLayout(new BorderLayout());
		work = new JPanel();
		//work.setLayout(null);
		work.setPreferredSize(new Dimension(1600,1200));
//		work.setMinimumSize(new Dimension(1600,1200));
		work.setBackground(Color.WHITE);
//		JLabel temp = new JLabel();
//		temp.setSize(new Dimension(1600,1200));
//		work.add(temp);
//		temp.setBackground(Color.BLACK);
		
		scroll = new JScrollPane(work);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setPreferredSize(new Dimension(800, 600));
		add(scroll, BorderLayout.CENTER);
	}
}
