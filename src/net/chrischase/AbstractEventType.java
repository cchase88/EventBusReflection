package net.chrischase;

public abstract class AbstractEventType implements EventType{
	
	private EventBus eventBus;

	@Override
	public EventBus getEventBus() {
		if(eventBus == null) throw new RuntimeException("eventBus is currently null");
		return eventBus;
	}

	@Override
	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;		
	}
	
	 

}
