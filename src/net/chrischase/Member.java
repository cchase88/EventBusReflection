package net.chrischase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;

public interface Member extends Consumer<EventType>{
	
	
	@Override
	default void accept(EventType event){
	
		Class clazz = this.getClass();
		Class<EventType> eventType = (Class<EventType>) event.getClass();
		
		
		Method handlerMethod = null;
		for(Method m : clazz.getDeclaredMethods()){
			//System.out.println(m.toString());
			if(m.getName() == "handle" && m.getParameterTypes()[0] == eventType){
				handlerMethod = m;
				break;
			}
		}
		
		if(handlerMethod != null ){
			handlerMethod.setAccessible(true);	
			
			try {
				
				handlerMethod.invoke(this, event);
			
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			handlerMethod.setAccessible(false);	
			
		}
		
		
		
	}
}
