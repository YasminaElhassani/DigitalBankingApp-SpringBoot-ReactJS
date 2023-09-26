package com.ebank.app.ebank.utils;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;


@Component
public class RibUtils {




    private static final Map<Character, Integer> charactersValue =
            Stream.of(
                            new AbstractMap.SimpleEntry<>('A', 1),
                            new AbstractMap.SimpleEntry<>('B', 2),
                            new AbstractMap.SimpleEntry<>('C', 3),
                            new AbstractMap.SimpleEntry<>('D', 4),
                            new AbstractMap.SimpleEntry<>('E', 5),
                            new AbstractMap.SimpleEntry<>('F', 6),
                            new AbstractMap.SimpleEntry<>('G', 7),
                            new AbstractMap.SimpleEntry<>('H', 8),
                            new AbstractMap.SimpleEntry<>('I', 9),
                            new AbstractMap.SimpleEntry<>('J', 1),
                            new AbstractMap.SimpleEntry<>('K', 2),
                            new AbstractMap.SimpleEntry<>('L', 3),
                            new AbstractMap.SimpleEntry<>('M', 4),
                            new AbstractMap.SimpleEntry<>('N', 5),
                            new AbstractMap.SimpleEntry<>('O', 6),
                            new AbstractMap.SimpleEntry<>('P', 7),
                            new AbstractMap.SimpleEntry<>('Q', 8),
                            new AbstractMap.SimpleEntry<>('R', 9),
                            new AbstractMap.SimpleEntry<>('S', 2),
                            new AbstractMap.SimpleEntry<>('T', 3),
                            new AbstractMap.SimpleEntry<>('U', 4),
                            new AbstractMap.SimpleEntry<>('V', 5),
                            new AbstractMap.SimpleEntry<>('W', 6),
                            new AbstractMap.SimpleEntry<>('X', 7),
                            new AbstractMap.SimpleEntry<>('Y', 8),
                            new AbstractMap.SimpleEntry<>('Z', 9))
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue));




    public static boolean checkRib(String rib) {
        try {
            BigDecimal extendedRib = calculateExtendedRib(rib);
            BigDecimal divider = new BigDecimal(97);

            return extendedRib.remainder(divider).intValue() == 0;
        }catch (Exception e){
            return false;
        }

    }


    public static BigDecimal calculateExtendedRib(String rib) {
        StringBuilder extendedRib = new StringBuilder(rib.length());
        for (char currentChar : rib.toCharArray()) {
            // Works on base 36
            int currentCharValue = Character.digit(currentChar, Character.MAX_RADIX);
            // Convert character to simple digit
            extendedRib.append(currentCharValue < 10 ? currentCharValue : (int) charactersValue.get(currentChar));
        }

        return new BigDecimal(extendedRib.toString());
    }
}
