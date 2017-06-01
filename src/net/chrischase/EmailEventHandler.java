package net.chrischase;


public class EmailEventHandler implements Member {
	
	
	private void handle(EmailEventType event){
		System.out.println("Received EmailEventType");
	}
	

}
