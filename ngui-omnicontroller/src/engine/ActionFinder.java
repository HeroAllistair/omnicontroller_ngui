package engine;

import data.Parser;

public class ActionFinder {

	
	private MouseAction mouseAction;
	private KeyboardAction keyboardAction;
	
	private int flag;
	
	public ActionFinder() {	
		mouseAction = new MouseAction();
		keyboardAction = new KeyboardAction();	
	}
	
	public void parseMsg(String cmd) {	
		String[] tokenCmd = cmd.split(Parser.DELIMITER);
		
		if (tokenCmd[0].equals(Parser.PREF_TRACKPAD)) {
			int abs = Integer.valueOf(tokenCmd[1]);
			int ord = Integer.valueOf(tokenCmd[2]);
			mouseAction.mouseCursorMoving(abs, ord);
			flag = 1;
		}
		else if (tokenCmd[0].equals(Parser.PREF_CONTROLER)) {
			String inputText = tokenCmd[1];
			keyboardAction.pressKey(inputText);
			flag = 2;
		}
		else if (tokenCmd[0].equals(Parser.PREF_ACCELEROMETER)) {
			flag = 3;	
		}
		
		else {
			flag = 0;
		}	
	}

	@Override
	public String toString() {
		String flagMsg;
		switch (flag) {
			case 1 :
				flagMsg = mouseAction.toString();
				break;
			case 2 :
				flagMsg = keyboardAction.toString();
				break;
			case 3 :
				flagMsg = "[ Accelerometer action = OK ]";
				break;
			default :
				flagMsg = "[ !!! Command unknown !!!]";
		}
		return flagMsg;
	}
	
}
