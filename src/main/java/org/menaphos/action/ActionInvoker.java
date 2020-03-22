package org.menaphos.action;

public class ActionInvoker {


    public boolean perform(Action action) {
        return action.invoke();
    }
}
