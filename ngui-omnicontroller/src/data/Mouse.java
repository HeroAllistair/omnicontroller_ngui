package data;

import java.awt.event.*;

public class Mouse {
	
	public static final int MASK_LEFT_BUTTON = InputEvent.BUTTON1_DOWN_MASK;
	public static final int MASK_RIGHT_BUTTON = InputEvent.BUTTON3_DOWN_MASK;
	
	private int abs;
	private int ord;
	
	public Mouse() {
		abs = 0;
		ord = 0;
	}
	
	public void setCoord(int abs, int ord) {
		this.abs = abs;
		this.ord = ord;
	}
	
	public int getAbs() {
		return abs;
	}

	public int getOrd() {
		return ord;
	}


	@Override
	public String toString() {
		return "x = " + abs + ", y = " + ord;
	}

}
