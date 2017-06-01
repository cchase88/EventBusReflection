package net.chrischase;

public class App {

	public static void main(String[] args) {
		EventBus eb = EventBus.getInstance();
		
		EmailEventHandler eeh = new EmailEventHandler();
		
		eb.subscribe(eeh);
		
		RegistrationHandler rh = new RegistrationHandler();
		
		eb.subscribe(rh);
		
		eb.publish(new EmailEventType("chris@gmail.com"));
		eb.publish(new RegistrationEventType());

	}

}
