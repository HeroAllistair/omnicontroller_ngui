package gui;

import javax.swing.JPanel;

import javax.swing.JTextArea;

import data.Device;
import data.GUI;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Graphics;

public class DeviceGraphical extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 788896303477211435L;
	
	private Device device;
	
	public DeviceGraphical(String deviceName, String address) {
		super();
		device = new Device();
		
		if (!deviceName.equals("/")) {
			device.setName("Name : " + deviceName);
		}
		else {
			device.setName("/");		
		}
		
		if (!address.equals("/")) {
			device.setAddress("MAC Adress : " + address);
		}
		else {
			device.setAddress("/");		
		}

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel namePanel = new JPanel();
		JTextArea nameTxtA = new JTextArea(device.getName());
	    nameTxtA.setEditable(false);
	    namePanel.add(nameTxtA);
	    JPanel adressPanel = new JPanel();
	    JTextArea adrTxtA = new JTextArea(device.getAddress());
	    adrTxtA.setEditable(false);
	    adressPanel.add(adrTxtA);
	    
	    File file = new File(GUI.IMAGE_FILE);
        BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}		
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel label = new JLabel();
        label.setIcon(imageIcon);
             
        this.add(namePanel);
	    this.add(adressPanel);
	    this.add(label);
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!device.getName().equals("/")) {
        	g.setColor(GUI.CONNECTED_STATE_COLOR);
        }
        else {
        	g.setColor(GUI.DISCONNECTED_STATE_COLOR);
        }
        
        g.fillOval(GUI.STATE_SHAPE_X1, GUI.STATE_SHAPE_Y1, GUI.STATE_SHAPE_X2, GUI.STATE_SHAPE_Y2);
    }
	
}