package org.menaphos.model.world.chat;

import org.menaphos.model.Observable;

public interface MessageAction extends Observable {

    void send(String message);

}
