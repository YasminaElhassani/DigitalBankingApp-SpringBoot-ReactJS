package com.ebank.app.ebank.enums;

import java.util.Map;
import java.util.stream.Stream;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;



public enum Type {


    AUTRES("Autres"),
    INVALID("invalid");




    
    private static final Map<String, Type> typesByType = Stream.of(values())
            .filter(c -> c != INVALID)
            .collect(toUnmodifiableMap(c -> c.type.toLowerCase(), identity()));




    public final String type;


    Type(String type) {
        this.type = type;
    }




    public static boolean isAutres(String type) {
        return AUTRES.type.equalsIgnoreCase(type);
    }


    public static Type getByType(String type) {
        if (null == type)
            return INVALID;

        return typesByType.getOrDefault(type.toLowerCase(), INVALID);
    }


    public boolean isInvalid() {
        return this == INVALID;
    }


    @Override
    public String toString() {
        return this.type;
    }
}
