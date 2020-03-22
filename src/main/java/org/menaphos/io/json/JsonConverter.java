package org.menaphos.io.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonConverter {

    public JsonObject convertToJsonObject(Object payload) {
        GsonBuilder builder = new GsonBuilder();
        return (JsonObject) builder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).
                create().toJsonTree(payload);
    }
}
