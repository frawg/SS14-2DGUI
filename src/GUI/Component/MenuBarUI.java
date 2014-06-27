package GUI.Component;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBarUI extends JPanel {
	//private JLabel btnNew, btnSave, btnLoad, btnPrint, btnCopy, btnPaste, btnUndo, btnRedo, btnZoomIn, btnZoomOut, btnZoomDef = null;
	private ImageIcon imgNew, imgSave, imgLoad, imgPrint, imgCopy, imgPaste, imgUndo, imgRedo, imgZoomIn, imgZoomOut, imgZoomDef = null;
	private JButton btnNew, btnSave, btnLoad, btnPrint, btnCopy, btnPaste, btnUndo, btnRedo, btnZoomIn, btnZoomOut, btnZoomDef = null;
	private JPanel projPane, editPane, zoomPane = null;
	
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
		
		
		imgZoomIn = new ImageIcon(getClass().getResource("/Images/1403889420_519953-014_ZoomIn.png"));
		imgZoomOut = new ImageIcon(getClass().getResource("/Images/1403889424_519894-015_ZoomOut.png"));
		imgZoomDef = new ImageIcon(getClass().getResource("/Images/1403889427_519895-013_MagnifyingGlass.png"));
		
		btnZoomIn = new JButton();
		btnZoomIn.setIcon(new ImageIcon(imgZoomIn.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnZoomIn.setMargin(new Insets(0, 0, 0, 0));
		btnZoomIn.setBorderPainted(false);
		btnZoomIn.setOpaque(false);
		
		btnZoomOut = new JButton();
		btnZoomOut.setIcon(new ImageIcon(imgZoomOut.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnZoomOut.setMargin(new Insets(0, 0, 0, 0));
		btnZoomOut.setBorderPainted(false);
		btnZoomOut.setOpaque(false);
		
		btnZoomDef = new JButton();
		btnZoomDef.setIcon(new ImageIcon(imgZoomDef.getImage().getScaledInstance(iconSize, iconSize, 0)));
		btnZoomDef.setMargin(new Insets(0, 0, 0, 0));
		btnZoomDef.setBorderPainted(false);
		btnZoomDef.setOpaque(false);
		
		zoomPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		zoomPane.setBackground(Color.WHITE);
		zoomPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.LIGHT_GRAY), BorderFactory.createEmptyBorder(0, 2, 0, 5)));
		zoomPane.add(btnZoomIn);
		zoomPane.add(btnZoomOut);
		zoomPane.add(btnZoomDef);
		
		this.add(projPane);
		this.add(editPane);
		this.add(zoomPane);
	}
}
