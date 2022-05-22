package data;

public class Device {
	
	private String name;
	private String address;
	
	public Device() {
		name = null;
		address = null;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

}
