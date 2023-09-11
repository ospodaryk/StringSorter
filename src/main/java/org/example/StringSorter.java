package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The StringSorter class sorts a list of strings alphabetically but places words that
 * start with a specific prefix at the end of the list, sorted in reverse alphabetical order.
 * <p>
 * Example:
 * Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
 * Output: ["banana", "cherry", "grape", "avocado", "apple"]
 */
public class StringSorter {

    /**
     * Sorts a list of strings based on a given exception prefix.
     *
     * @param unsortedStrings List of unsorted strings.
     * @param exceptionChar   The specific prefix for exception sorting.
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

        return exceptionChar.isEmpty()
                ? sortByEmptyPrefix(filteredAndSortedStrings)
                : sortByPrefix(filteredAndSortedStrings, exceptionChar);
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
     * Handles sorting for strings that have an empty prefix.
     * <p>
     * This method takes a list of already sorted strings and moves all empty strings to the end.
     * </p>
     *
     * @param sortedStrings The list of already sorted strings.
     * @return The list with empty strings moved to the end.
     */
    private List<String> sortByEmptyPrefix(List<String> sortedStrings) {
        List<String> listOfEmptys = sortedStrings.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());
        sortedStrings.removeAll(listOfEmptys);
        sortedStrings.addAll(listOfEmptys);
        return sortedStrings;
    }

    /**
     * Sorts the strings in the list based on a specific exception character.
     *
     * @param sortedStrings List of sorted strings.
     * @param exceptionChar The exception character.
     * @return The list of sorted strings considering the exception character.
     */
    private List<String> sortByPrefix(List<String> sortedStrings, String exceptionChar) {
        List<String> otherStrings = sortedStrings.stream()
                .filter(s -> !s.startsWith(exceptionChar))
                .collect(Collectors.toList());

        List<String> exceptionPrefixStrings = sortedStrings.stream()
                .filter(s -> s.startsWith(exceptionChar))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        otherStrings.addAll(exceptionPrefixStrings);
        return otherStrings;
    }
}
