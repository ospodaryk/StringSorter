package org.example;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * The StringSorter class defines the contract for sorting strings based on
 * alphabetical order while skipping words that start with a specific prefix.
 * <p>
 * Example:
 * Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
 * Output: ["banana", "cherry", "grape", "avocado", "apple"]
 * <p>
 * Here, "banana", "cherry", and "grape" are sorted in alphabetical order
 * whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order
 * at the end of the list.
 */
public class StringSorter {
    /**
     * Sorts a list of strings based on the provided exception character.
     *
     * @param unsortedStrings List of unsorted strings.
     * @param exceptionChar   The specific prefix.
     * @return List of sorted strings.
     */
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        List<String> filteredAndSortedStrings = unsortedStrings.stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());

        if ((exceptionChar == null) || (isListEmptyOrNull(unsortedStrings))) {
            return filteredAndSortedStrings;
        }

        return sortByPrefix(filteredAndSortedStrings, exceptionChar);
    }

    /**
     * Checks if the list is empty or null.
     *
     * @param list The list to be checked.
     * @return True if the list is null or empty, false otherwise.
     */
    private boolean isListEmptyOrNull(List<String> list) {
        return list == null || list.isEmpty();
    }

    /**
     * Handles the sorting logic for strings based on the exception character.
     *
     * @param sortedStrings The list of already sorted strings.
     * @param exceptionChar The exception character.
     * @return The sorted list of strings considering the exception character.
     */
    private List<String> sortByPrefix(List<String> sortedStrings, String exceptionChar) {
        List<String> exceptionPrefixStrings = new ArrayList<>();
        List<String> otherStrings = new ArrayList<>();
        for (String string : sortedStrings) {
            if (exceptionChar.isEmpty() ? string.isEmpty() : string.startsWith(exceptionChar)) {
                exceptionPrefixStrings.add(string);
            } else {
                otherStrings.add(string);
            }
        }
        exceptionPrefixStrings.sort(Comparator.reverseOrder());
        otherStrings.addAll(exceptionPrefixStrings);
        return otherStrings;
    }
}
