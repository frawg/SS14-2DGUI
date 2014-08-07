package GUI.Component;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Component.Labels.Connection;
import GUI.Component.Labels.JLabel;

public class MenuBarUI extends JPanel {
	private ImageIcon imgNew, imgSave, imgLoad, imgPrint, imgCopy, imgPaste, imgUndo, imgRedo = null;
	private JButton btnNew, btnSave, btnLoad, btnPrint, btnCopy, btnPaste, btnUndo, btnRedo = null;
	private JPanel projPane, editPane = null;
	
	public MenuBarUI(){
		int iconSize = 24;
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setPreferredSize(new Dimension(800,34));
		//this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(new Dimension(800,34));
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setBackground(Color.WHITE);
		
		imgNew = new ImageIcon(getClass().getResource("/Images/1403889507_519959-022_Document_Add.png"));
		imgSave = new ImageIcon(getClass().getResource("/Images/1403888714_save.png"));
		imgLoad = new ImageIcon(getClass().getResource("/Images/1403889643_519946-006_Folder.png"));
		imgPrint = new ImageIcon(getClass().getResource("/Images/1403889510_519969-032_Printer2.png"));
		
		btnNew = new JButton();
		btnNew.setIcon(new ImageIcon(imgNew.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnNew.setMargin(new Insets(0, 0, 0, 0));
		btnNew.setBorderPainted(false);
		btnNew.setOpaque(false);
		
		btnSave = new JButton();
		btnSave.setIcon(new ImageIcon(imgSave.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnSave.setMargin(new Insets(0, 0, 0, 0));
		btnSave.setBorderPainted(false);
		btnSave.setOpaque(false);
		btnSave.addActionListener(new ButtonListener());
		
		btnLoad = new JButton();
		btnLoad.setIcon(new ImageIcon(imgLoad.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnLoad.setMargin(new Insets(0, 0, 0, 0));
		btnLoad.setBorderPainted(false);
		btnLoad.setOpaque(false);
		
		btnPrint = new JButton();
		btnPrint.setIcon(new ImageIcon(imgPrint.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnPrint.setMargin(new Insets(0, 0, 0, 0));
		btnPrint.setBorderPainted(false);
		btnPrint.setOpaque(false);
		
		projPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		projPane.setBackground(Color.WHITE);
		projPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY), BorderFactory.createEmptyBorder(0, 2, 0, 5)));
		projPane.add(btnNew);
		projPane.add(btnSave);
		projPane.add(btnLoad);
		projPane.add(btnPrint);
		
		
		imgCopy = new ImageIcon(getClass().getResource("/Images/1403889779_519723-231_PagesView.png"));
		imgPaste = new ImageIcon(getClass().getResource("/Images/1403889589_519584-081_Pen.png"));
		imgUndo = new ImageIcon(getClass().getResource("/Images/1403888615_undo.png"));
		imgRedo = new ImageIcon(getClass().getResource("/Images/1403888612_redo.png"));
		
		btnCopy = new JButton();
		btnCopy.setIcon(new ImageIcon(imgCopy.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnCopy.setMargin(new Insets(0, 0, 0, 0));
		btnCopy.setBorderPainted(false);
		btnCopy.setOpaque(false);
		
		btnPaste = new JButton();
		btnPaste.setIcon(new ImageIcon(imgPaste.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnPaste.setMargin(new Insets(0, 0, 0, 0));
		btnPaste.setBorderPainted(false);
		btnPaste.setOpaque(false);
		
		btnUndo = new JButton();
		btnUndo.setIcon(new ImageIcon(imgUndo.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnUndo.setMargin(new Insets(0, 0, 0, 0));
		btnUndo.setBorderPainted(false);
		btnUndo.setOpaque(false);
		
		btnRedo = new JButton();
		btnRedo.setIcon(new ImageIcon(imgRedo.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnRedo.setMargin(new Insets(0, 0, 0, 0));
		btnRedo.setBorderPainted(false);
		btnRedo.setOpaque(false);
		
		editPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		editPane.setBackground(Color.white);
		editPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.LIGHT_GRAY), BorderFactory.createEmptyBorder(0, 2, 0, 5)));
		editPane.add(btnCopy);
		editPane.add(btnPaste);
		editPane.add(btnUndo);
		editPane.add(btnRedo);
		
		this.add(projPane);
		this.add(editPane);
	}
	
	public void save()
	{
		ArrayList<JLabel> itemList = WorkPanel.getItemsList();
		ArrayList<Connection> connList = WorkPanel.getConnList();
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory( new File( "./") );
		int actionDialog = chooser.showSaveDialog(this);
		
		if(actionDialog == JFileChooser.APPROVE_OPTION)
		{
			File fileName = new File( chooser.getSelectedFile( ) + ".log" );
		    if(fileName == null)
		        return;
		    if(fileName.exists())
		    {
		        actionDialog = JOptionPane.showConfirmDialog(this,
		                           "Replace existing file?");
		        // may need to check for cancel option as well
		        if (actionDialog == JOptionPane.NO_OPTION)
		            return;
		    }
		    // okay to write file
		    try
		    {
		    	BufferedWriter outFile = new BufferedWriter( new FileWriter( fileName ) );
		    	
		    	for(int i=1;i<itemList.size();i++)
		    	{
		    		String name = itemList.get(i).getText();
		    		String type = itemList.get(i).getType().toString();
		    		double x = itemList.get(i).getLocation().getX();
		    		double y = itemList.get(i).getLocation().getY();
		    		
		    		outFile.write(name+"!"+type+"!"+x+"!"+y+"!");
		    	}
		    	
		    	for(int i=0;i<connList.size();i++)
		    	{
		    		double startX = connList.get(i).getStart().getLocation().getX();
		    		double startY = connList.get(i).getStart().getLocation().getY();
		    		double endX = connList.get(i).getEnd().getLocation().getX();
		    		double endY = connList.get(i).getEnd().getLocation().getY();
		    		
		    		outFile.write(startX+"!"+startY+"!"+endX+"!"+endY);
		    	}
		    	System.out.println(connList.size());
		    	
		    	outFile.close( );
		    }
		    catch(IOException e)
		    {
		    	
		    }
		    
		}
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnSave)
			{
				save();
			}
		}
	}
}
