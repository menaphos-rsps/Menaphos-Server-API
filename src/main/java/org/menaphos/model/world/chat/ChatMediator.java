package org.menaphos.model.world.chat;

import org.menaphos.model.entity.Entity;

public interface ChatMediator {

    void sendMessage(String msg);

    void addUser(Entity user);
}
