package GUI.Component;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBarUI extends JPanel {
	//private JLabel btnNew, btnSave, btnLoad, btnPrint, btnCopy, btnPaste, btnUndo, btnRedo, btnZoomIn, btnZoomOut, btnZoomDef = null;
	private ImageIcon imgNew, imgSave, imgLoad, imgPrint, imgCopy, imgPaste, imgUndo, imgRedo, imgZoomIn, imgZoomOut, imgZoomDef = null;
	private JButton btnNew, btnSave, btnLoad, btnPrint, btnCopy, btnPaste, btnUndo, btnRedo, btnZoomIn, btnZoomOut, btnZoomDef = null;
	private JPanel projPane, editPane, zoomPane = null;
	
	public MenuBarUI(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 0));
		//this.setPreferredSize(new Dimension(800,34));
		//this.setMaximumSize(this.getPreferredSize());
		this.setMinimumSize(new Dimension(800,34));
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setBackground(Color.WHITE);
		
		btnNew = new JButton("New");
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		btnPrint = new JButton("Export");
		
		projPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		projPane.setBackground(Color.WHITE);
		projPane.add(btnNew);
		projPane.add(btnSave);
		projPane.add(btnLoad);
		projPane.add(btnPrint);
		
		btnCopy = new JButton("Copy");
		btnPaste = new JButton("Paste");
		btnUndo = new JButton("Undo");
		btnRedo = new JButton("Redo");
		
		editPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		editPane.setBackground(Color.white);
		
		editPane.add(btnCopy);
		editPane.add(btnPaste);
		editPane.add(btnUndo);
		editPane.add(btnRedo);
		
		btnZoomIn = new JButton("Zoom In");
		btnZoomOut = new JButton("Zoom Out");
		btnZoomDef = new JButton("Default Zoom");
		
		zoomPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		zoomPane.setBackground(Color.WHITE);
		
		zoomPane.add(btnZoomIn);
		zoomPane.add(btnZoomOut);
		zoomPane.add(btnZoomDef);
		
		this.add(projPane);
		this.add(editPane);
		this.add(zoomPane);
	}
}
