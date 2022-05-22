package data;

import java.util.ArrayList;

public class Keyboard {
	
	private ArrayList<Integer> keyCodesList;
	private ArrayList<String> keyTextList;
	
	public Keyboard() {
		keyCodesList = new ArrayList<Integer>();
		keyTextList = new ArrayList<String>();
		BuildKeyEventsList();
	}
	
	public ArrayList<Integer> getKeyCodesList() {
		return keyCodesList;
	}
	public void addKeyCodesList(int keyCode) {
		keyCodesList.add(keyCode);
	}
	public ArrayList<String> getKeyTextList() {
		return keyTextList;
	}
	public void addKeyTextList(String keyText) {
		keyTextList.add(keyText);
	}
	
	public void BuildKeyEventsList() {
		for(int index = 0; index < 65500; index++) {                                                    
            String text = java.awt.event.KeyEvent.getKeyText(index);                       
            if(!text.contains("Unknown keyCode: ")) {
            	getKeyCodesList().add(index);
            	getKeyTextList().add(text);
            }
		}		
	}
	
	@Override
	public String toString() {
		return "Keyboard [keyCodesList=" + keyCodesList + ", keyTextList=" + keyTextList + "]";
	}

}
