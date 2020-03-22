package org.menaphos.event;

import org.menaphos.event.listener.MenaphosEventListener;

import java.util.HashMap;
import java.util.Map;

public class MenaphosEventManager {

    private final Map<MenaphosEvent,MenaphosListenerManager> listenerManagers = new HashMap<>();

    public void registerObserver(MenaphosEvent eventType, MenaphosEventListener observer){
        synchronized (listenerManagers){
            listenerManagers.putIfAbsent(eventType,new MenaphosListenerManager());

            MenaphosListenerManager observerManager = listenerManagers.get(eventType);
            observerManager.add(observer);
        }
    }

    public void unregisterObserver(MenaphosEvent eventType, MenaphosEventListener observer){
        synchronized (listenerManagers) {
            if (!listenerManagers.containsKey(eventType)) {
                return;
            }

            MenaphosListenerManager observerManager = listenerManagers.get(eventType);
            observerManager.remove(observer);
        }
    }

    public void callEvent(MenaphosEvent event){
        if (!listenerManagers.containsKey(event)){
            return;
        }

        MenaphosListenerManager observerManager = listenerManagers.get(event);
        observerManager.callEvent(event);
    }
}
