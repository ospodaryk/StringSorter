package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class StringSorter {

    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {

        List<String> filteredAndSortedStrings = filterAndSortStrings(unsortedStrings);

        if (isListEmptyOrNull(unsortedStrings) || exceptionChar == null) {
            return filteredAndSortedStrings;
        }
        if (exceptionChar.isEmpty()) {
            return sortWhenCharIsEmpty(filteredAndSortedStrings);
        }
        return sortConsideringExceptionChar(filteredAndSortedStrings, exceptionChar);
    }

    private boolean isListEmptyOrNull(List<String> unsortedStrings) {
        return unsortedStrings == null || unsortedStrings.isEmpty();
    }

    private List<String> filterAndSortStrings(List<String> unsortedStrings) {
        return unsortedStrings.stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> sortWhenCharIsEmpty(List<String> sortedStrings) {
        List<String> stringsWithExceptionPrefix = new ArrayList<>();
        List<String> otherStrings = new ArrayList<>();

        for (String string : sortedStrings) {
            if (string.isEmpty()) {
                stringsWithExceptionPrefix.add(string);
            } else {
                otherStrings.add(string);
            }
        }
        stringsWithExceptionPrefix.sort(Comparator.reverseOrder());
        otherStrings.addAll(stringsWithExceptionPrefix);

        return otherStrings;
    }

    private List<String> sortConsideringExceptionChar(List<String> sortedStrings, String exceptionChar) {
        List<String> stringsWithExceptionPrefix = new ArrayList<>();
        List<String> otherStrings = new ArrayList<>();
        for (String string : sortedStrings) {
            if (string.startsWith(exceptionChar)) {
                stringsWithExceptionPrefix.add(string);
            } else {
                otherStrings.add(string);
            }
        }
        stringsWithExceptionPrefix.sort(Comparator.reverseOrder());
        otherStrings.addAll(stringsWithExceptionPrefix);
        return otherStrings;
    }
}
