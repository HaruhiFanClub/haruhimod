package com.haruhifanclub.mods.haruhicore.common.advancement.criterion;

import javax.annotation.Nullable;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.JSONUtils;

public class BooleanPredicate {

    public static final BooleanPredicate ANY = new BooleanPredicate(true);
    private final boolean value;

    BooleanPredicate(boolean value) {
        this.value = value;
    }

    // public JsonElement serializeToJson(String property) {
    //     if (this == ANY) {
    //         return JsonNull.INSTANCE;
    //     } else {
    //         JsonObject json = new JsonObject();
    //         json.addProperty(property, this.value);
    //         return json;
    //     }
    // }

    public static BooleanPredicate fromJson(@Nullable JsonElement jsonElement, String property) {
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            JsonObject jsonObject = JSONUtils.convertToJsonObject(jsonElement, property);
            if (jsonObject.has(property)) {
                return new BooleanPredicate(jsonObject.get(property).getAsBoolean());
            }
            return ANY;
        } else {
            return ANY;
        }
    }

    public boolean test(boolean value) {
        if (this == ANY) {
            return true;
        }
        return this.value == value;
    }

}
