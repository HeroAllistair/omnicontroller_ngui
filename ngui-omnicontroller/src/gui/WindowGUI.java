package gui;

import javax.swing.*;

import data.GUI;

import java.awt.*; 

public class WindowGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2941318999657277463L;

	public WindowGUI(String name, String adr) {
		super(GUI.WINDOWS_NAME);
      
		JPanel displayPanel = new JPanel();
		
		String nameDevice = name;
		String nameDevice2 = "Player 2";
		String nameDevice3 = "/";
		String nameDevice4 = "Player 4";
		
		String macAdr = adr;
		String macAdr2 = "address2";
		String macAdr3 = "        ";
		String macAdr4 = "address4";
      
		DeviceGraphical firstDevice = new DeviceGraphical(nameDevice, macAdr);
		firstDevice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		DeviceGraphical secondDevice = new DeviceGraphical(nameDevice2, macAdr2);
		secondDevice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		DeviceGraphical thirdDevice = new DeviceGraphical(nameDevice3, macAdr3);
		thirdDevice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		DeviceGraphical fourthDevice = new DeviceGraphical(nameDevice4, macAdr4);
		fourthDevice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
 
		displayPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
		displayPanel.add(firstDevice);
		displayPanel.add(secondDevice);
		displayPanel.add(thirdDevice);
		displayPanel.add(fourthDevice);
		this.add(displayPanel);

		Image icon = Toolkit.getDefaultToolkit().getImage(GUI.ICON_FILE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(GUI.WINDOWS_SIZE_X, GUI.WINDOWS_SIZE_Y);
		this.setIconImage(icon);
		this.setVisible(true);
   }
	
}