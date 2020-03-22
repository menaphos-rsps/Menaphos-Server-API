package org.menaphos.action.impl;

import org.menaphos.action.Action;
import org.menaphos.entity.impl.CharacterEntity;
import org.menaphos.entity.impl.impl.PlayableCharacter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAction implements Action {

    private final CharacterEntity actor;

    public AbstractAction(CharacterEntity actor) {
        this.actor = actor;
    }

    public CharacterEntity getActor() {
        return actor;
    }

    //    private final Map<String, Object> actionPropertyMap;


//    @Override
//    public void putValue(String key, Object value) {
//        if (actionPropertyMap.containsKey(key)) {
//            if (key != null) {
//                actionPropertyMap.put(key, value);
//            }
//        }
//    }
//
//    @Override
//    public Object getValue(String key) {
//        if (!actionPropertyMap.isEmpty()) {
//            if (key != null) {
//                if (actionPropertyMap.containsKey(key)) {
//                    if (actionPropertyMap.get(key) != null) {
//                        return actionPropertyMap.get(key);
//                    }
//                }
//            }
//        }
//        return null;
//    }

//    public Map<String, Object> getActionPropertyMap() {
//        return actionPropertyMap;
//    }
}
