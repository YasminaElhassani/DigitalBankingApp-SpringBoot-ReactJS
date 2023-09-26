package com.ebank.app.ebank.enums;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public enum User {

    LOCAL_CLIENT("Local Client"),
    INTERNATIONAL_CLIENT("International Client"),
    INVALID("invalid");


    private static final Map<String, User> typesByType = Stream.of(values())
            .filter(c -> c != INVALID)
            .collect(toUnmodifiableMap(c -> c.type.toLowerCase(), identity()));




    public final String type;


    User(String type) {
        this.type = type;
    }




    public static boolean isLocalClient(String type) {
        return LOCAL_CLIENT.type.equalsIgnoreCase(type);
    }

    public static boolean isInternationalClient(String type) {
        return INTERNATIONAL_CLIENT.type.equalsIgnoreCase(type);
    }


    public static User getByType(String type) {
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
