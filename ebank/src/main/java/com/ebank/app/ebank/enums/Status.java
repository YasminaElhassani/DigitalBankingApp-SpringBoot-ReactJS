package com.ebank.app.ebank.enums;

import java.util.Map;
import java.util.stream.Stream;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;




public enum Status {


    SAVED("Enregister" ),
    SIGNED("Signed"),
    INVALID("invalid");





    private static final Map<String, Status> statusByType = Stream.of(values())
            .filter(c -> c != INVALID)
            .collect(toUnmodifiableMap(c -> c.type.toLowerCase(), identity()));




    public final String type;


    Status(String type) {
        this.type = type;
    }




    public static boolean isSaved(String type) {
        return SAVED.type.equalsIgnoreCase(type);
    }


    public static boolean isSigned(String type) {
        return SIGNED.type.equalsIgnoreCase(type);
    }


    public static Status getByType(String type) {
        if (null == type)
            return INVALID;

        return statusByType.getOrDefault(type.toLowerCase(), INVALID);
    }


    public boolean isInvalid() {
        return this == INVALID;
    }


    @Override
    public String toString() {
        return this.type;
    }
}
