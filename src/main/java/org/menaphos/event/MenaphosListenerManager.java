package org.menaphos.event;

import org.menaphos.event.listener.MenaphosEventListener;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class MenaphosListenerManager {

    private Set<MenaphosEventListener> weakReferencedListeners;

    public MenaphosListenerManager() {
        weakReferencedListeners = Collections.newSetFromMap(new WeakHashMap<>()); // allows a set of weak references
    }

    public void add(MenaphosEventListener listener){
        if (listener != null) {
            weakReferencedListeners.add(listener);
        }
    }

    public void remove(MenaphosEventListener listener){
        weakReferencedListeners.remove(listener);
    }

    public void callEvent(MenaphosEvent event){
        weakReferencedListeners
                .forEach(observer -> observer.handle(event));

        weakReferencedListeners.remove(null);
    }
}
