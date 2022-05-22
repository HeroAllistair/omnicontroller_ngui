package simulation;

import java.io.IOException;

import engine.ActionFinder;
import engine.MouseAction;
import gui.WindowGUI;
import gui.LauncherGUI;

public class Dashboard {

	public static void main(String[] args) throws IOException {
		String name;
		String adr;
		LauncherGUI testGUI = new LauncherGUI(name, adr);
		
//		MouseControl mouseControl = new MouseControl();
//		KeyboardControl keyboardControl = new KeyboardControl();
				
		ActionFinder actFinder = new ActionFinder();
		String cmd = args[0];
		actFinder.parseMsg(cmd);
		System.out.println(actFinder.toString());
		
		System.out.println("\n===============================================================================\n");
		
		
		// Parser test
//		MouseAction mouseAction = new MouseAction();		
//		ActionFinder actFinder = new ActionFinder();
//		
//		String cmd = "TRACK,200,40";
//		actFinder.parseMsg(cmd);
//		System.out.println(actFinder.toString());
//		mouseAction.mouseLeftClick();
//		
//		System.out.println("\n===============================================================================\n");
//		
//		
//		cmd = "TRAC,200,40";
//		actFinder.parseMsg(cmd);
//		System.out.println(actFinder.toString());
//		
//		System.out.println("\n===============================================================================\n");
		
		
//		cmd = "CONT,A";
//		actFinder.parseMsg(cmd);
//		System.out.println(actFinder.toString());
	}

}
