package engine;

//import java.awt.AWTException;
import java.awt.Robot;
//import java.awt.event.*;

import data.Mouse;

public class MouseAction {
	
	private Robot mouseRobot;
	private Mouse mouse;
	private int flag;
	
	public MouseAction() {
		flag = 0;
		try {
			mouseRobot = new Robot();
		}
		catch (Exception e) {
			System.out.println("Mouse robot problem : " + e.getMessage());
		}
		mouse = new Mouse();
	}
	
	public void mouseCursorMoving(int abs, int ord) {
		try {
			mouse.setCoord(abs, ord);
			mouseRobot.mouseMove(abs,ord);
			flag = 1;
		}
		catch (Exception e) {
			System.out.println("Mouse cursor problem : " + e.getMessage());
		}
	}
	
	public void mouseLeftClick() {
		try {
			int mask = Mouse.MASK_LEFT_BUTTON;
			mouseRobot.mousePress(mask);
			mouseRobot.mouseRelease(mask);
			flag = 2;
		}
		catch (Exception e) {
			System.out.println("Mouse left click problem : " + e.getMessage());
		}
	}
	
	public void mouseRightClick() {
		try {
			int mask = Mouse.MASK_RIGHT_BUTTON;
			mouseRobot.mousePress(mask);
			mouseRobot.mouseRelease(mask);
			flag = 3;
			
		}
		catch (Exception e) {
			System.out.println("Mouse right click problem : " + e.getMessage());
		}
	}
	
	public void mouseWheeling(int wheelAmt) {
		try {
			mouseRobot.mouseWheel(wheelAmt);
			flag = 4;
		}
		catch (Exception e) {
			System.out.println("Mouse wheeling problem : " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		String flagMsg;
		String mouseData = mouse.toString();
		switch (flag) {
			case 1 :
				flagMsg = "[ Mouse move = OK ]";
				break;
			case 2 :
				flagMsg = "[ Mouse left click = OK ]";
				break;
			case 3 :
				flagMsg = "[ Mouse right click = OK ]";
				break;
			case 4 :
				flagMsg = "[ Mouse wheel = OK ]";
				break;
			default :
				flagMsg = "[ Mouse move = KO ]";
		}
		return "Mouse Action :\n" + "[ Mouse cursor position : " + mouseData + " ]" + "\n" + flagMsg;
	}
	
}
