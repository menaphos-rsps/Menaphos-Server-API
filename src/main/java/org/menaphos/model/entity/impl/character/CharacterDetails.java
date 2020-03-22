package org.menaphos.model.entity.impl.character;

import org.menaphos.model.entity.EntityDetails;
import org.menaphos.model.math.impl.AdjustableInteger;

import java.util.HashMap;
import java.util.Map;

public class CharacterDetails extends EntityDetails {

    private final Map<String, AdjustableInteger> pointMap;

    public CharacterDetails(String id) {
        super(id);
        this.pointMap = new HashMap<>();
    }

    public Map<String, AdjustableInteger> getPointMap() {
        return pointMap;
    }

    @Override
    public String getId() {
        return (String) super.getId();
    }
}
