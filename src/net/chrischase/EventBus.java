package net.chrischase;

import java.util.HashSet;
import java.util.Set;

public class EventBus {
	
	private static EventBus INSTANCE = new EventBus();
	
	private EventBus(){}
	
	public static EventBus getInstance(){ return INSTANCE; }
	

	private Set<Member> members = new HashSet<>();
	
	public void subscribe(Member m){
		members.add(m);
	}
	
	public void unsubscribe(Member m){
		members.remove(m);
	}
	
	public void publish(EventType event){
		event.setEventBus(this); // Store a ref to the bus the event is using.
		members.forEach((member) -> member.accept(event)); 
	}
	

}
