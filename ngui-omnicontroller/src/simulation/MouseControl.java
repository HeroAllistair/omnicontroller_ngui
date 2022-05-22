package simulation;

import engine.MouseAction;

public class MouseControl {

	public MouseControl() {
		
		MouseAction mouseAction = new MouseAction();
		
		// Mouse left click test
		mouseAction.mouseCursorMoving(200, 40);
		mouseAction.mouseLeftClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(mouseAction.toString());
		
		System.out.println("\n===============================================================================\n");
		
		// Mouse right click test
		mouseAction.mouseCursorMoving(100, 100);
		mouseAction.mouseRightClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(mouseAction.toString());
		
		System.out.println("\n===============================================================================\n");
		
		// Mouse wheeling test
		mouseAction.mouseCursorMoving(600, 400);
		mouseAction.mouseLeftClick();
		mouseAction.mouseWheeling(-20);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(mouseAction.toString());
		
		System.out.println("\n===============================================================================\n");
		
	}

}
