package engine;

import java.awt.Robot;
//import java.awt.AWTException;
import java.util.ArrayList;
//import java.io.IOException;

import data.Keyboard;

public class KeyboardAction {
	
	private Robot keyboardRobot;
	private Keyboard keyboard;
	
	private int flag;
	
	public KeyboardAction() {
		try {
			keyboardRobot = new Robot();
		}
		catch (Exception e) {
			System.out.println("Mouse robot problem : " + e.getMessage());
		}
		
		keyboard = new Keyboard();
		
		flag = 0;	
	}
	
	public void pressKey(String inputText) {
		flag = 1;
      
		// If the received input matches one the entries of the list of keycode, we generate a keybord input
		ArrayList<Integer> keyCodesList = keyboard.getKeyCodesList();
		ArrayList<String> keyTextList = keyboard.getKeyTextList();
		
		for(int index1 = 0; index1 < keyCodesList.size(); index1++) {
			if (keyCodesList.get(index1) == Integer.valueOf(inputText)) {
//				System.out.println(inputText);
				keyboardRobot.keyPress(keyboard.getKeyCodesList().get(index1));
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void launchPowerPointSlide(String inputText) {
		flag = 2;	
	}

	@Override
	public String toString() {
		String flagMsg;
		String keyboardData = keyboard.toString();
		switch (flag) {
			case 1 :
				flagMsg = "[ Key press = OK ]";
				break;
			case 2 :
				flagMsg = "[ PowerPoint slide launching = OK ]";
				break;
			default :
				flagMsg = "";
		}
			return "Keyboard Action :\n" + "[ Keyboard data : " + keyboardData + " ]" + "\n" + flagMsg;
	}
	
}