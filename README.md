# StringSorter Java Class

## Table of Contents

- [Description](#description)
- [Example](#example)
- [Features](#features)
- [Methods](#methods)

## Description

The `StringSorter` class in Java provides a robust way to sort a list of strings. The unique feature of this class is its ability to sort words that start with a specific prefix in a different manner than the rest. The StringSorter class defines the contract for sorting strings based on alphabetical order while skipping words that start with a specific prefix.

If prefix='' I decided all not empty elements have to be sorted alphabetically and only elements that are also empty will be in the end. 

## Example:
Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"

Output: ["banana", "cherry", "grape", "avocado", "apple"]

Here, "banana", "cherry", and "grape" are sorted in alphabetical order whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order at the end of the list.

## Methods

### `sortStrings(List<String> unsortedStrings, String exceptionChar)`

**Parameters:**

- `unsortedStrings`: A list of unsorted strings.
- `exceptionChar`: A prefix for which the sorting rule should be different.

**Returns:**

- A list of sorted strings.

### `isListEmptyOrNull(List<String> list)`

**Parameters:**

- `list`: A list to be checked.

**Returns:**

- `True` if the list is null or empty, `false` otherwise.

### `sortByPrefix(List<String> sortedStrings, String exceptionChar)`

**Parameters:**

- `sortedStrings`: A list of already sorted strings.
- `exceptionChar`: A prefix for which the sorting rule should be different.

**Returns:**

- A list of sorted strings considering the exception character.

## Documentation

For more detailed documentation, refer to the inline comments and JavaDoc provided in the class file.

---
