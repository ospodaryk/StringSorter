# StringSorter Java Class

## Table of Contents

- [Description](#description)
- [Example Usage](#example-usage)
- [Methods](#methods)
- [Additional Features](#additional-features)
- [Documentation](#documentation)

## Description

The `StringSorter` class provides a specialized way to sort a list of strings in Java. The unique feature of this class is its ability to sort words starting with a specific prefix in a different manner than the rest. It also ensures that null or empty strings are handled gracefully.

## Example Usage

**Input:** `["apple", "banana", "grape", "avocado", "cherry"]`  
**Exception prefix:** `"a"`

**Output:** `["banana", "cherry", "grape", "avocado", "apple"]`

Here, "banana", "cherry", and "grape" are sorted in alphabetical order, whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order and are placed at the end of the list.

## Methods

### `public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar)`

**Parameters:**

- `unsortedStrings`: A list of unsorted strings.
- `exceptionChar`: A prefix for which the sorting rule should be different.

**Returns:**

- A list of sorted strings, considering the exception prefix.

### `private boolean isListEmptyOrNull(List<String> list)`

**Parameters:**

- `list`: A list to be checked.

**Returns:**

- `true` if the list is null or empty, `false` otherwise.

### `private List<String> sortByEmptyPrefix(List<String> sortedStrings)`

**Parameters:**

- `sortedStrings`: A list of already sorted strings.

**Returns:**

- A list where empty strings are moved to the end.

### `private List<String> sortByPrefix(List<String> sortedStrings, String exceptionChar)`

**Parameters:**

- `sortedStrings`: A list of already sorted strings.
- `exceptionChar`: A prefix for which the sorting rule should be different.

**Returns:**

- A list of sorted strings, considering the exception prefix.

## Additional Features

- The class is designed to handle null or empty strings gracefully.
- If the exception prefix is empty or null, the class returns the list sorted in alphabetical order with empty strings moved to the end.

## Documentation

For more detailed documentation, refer to the inline comments and JavaDoc provided within the `StringSorter` class.

