package org.menaphos.entity;

import org.menaphos.action.ActionInvoker;
import org.menaphos.model.world.location.Location;

public interface Entity {

    ActionInvoker getActionInvoker();

    boolean moveTo(Location location);
}
