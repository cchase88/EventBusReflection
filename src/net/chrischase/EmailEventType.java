package net.chrischase;

public class EmailEventType extends AbstractEventType {

	private String address;

	public EmailEventType(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}

}
