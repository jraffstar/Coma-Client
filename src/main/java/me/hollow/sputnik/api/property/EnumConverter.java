package me.hollow.sputnik.api.property;

import com.google.common.base.Converter;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class EnumConverter extends Converter<Enum, JsonElement> {

    private final Class<? extends Enum> clazz;

    public EnumConverter(Class<? extends Enum> clazz) {
        this.clazz = clazz;
    }

    public static int currentEnum(Enum clazz) {
        for (int i = 0; i < clazz.getClass().getEnumConstants().length; i++) {
            final Enum e = clazz.getClass().getEnumConstants()[i];
            if (e.name().equalsIgnoreCase(clazz.name())) {
                return i;
            }
        }
        return -1;
    }

    public static Enum increaseEnum(Enum clazz) {
        int index = currentEnum(clazz);
        for (int i = 0; i < clazz.getClass().getEnumConstants().length; i++) {
            final Enum e = clazz.getClass().getEnumConstants()[i];
            if(i == index + 1) {
                return e;
            }
        }
        return clazz.getClass().getEnumConstants()[0];
    }

    public static String getProperName(Enum clazz) {
        return Character.toUpperCase(clazz.name().charAt(0)) + clazz.name().toLowerCase().substring(1);
    }

    @Override
    public JsonElement doForward(Enum anEnum) {
        return new JsonPrimitive(anEnum.toString());
    }

    @Override
    public Enum doBackward(JsonElement jsonElement) {
        try {
            return Enum.valueOf(clazz, jsonElement.getAsString());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}