import org.example.StringSorter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringSorterTest {

    @Test
    public void returnsEmptyList_WhenInputListIsEmpty() {
        StringSorter sorter = new StringSorter();
        assertEquals(Collections.emptyList(), sorter.sortStrings(Collections.emptyList(), "a"));
    }

    @Test
    public void returnsSortedOrder_WhenExceptionCharIsEmpty() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "cherry", "banana");
        assertEquals(Arrays.asList("apple", "banana", "cherry"), sorter.sortStrings(list, ""));
    }

    @Test
    public void sortsList_PuttingEmptyStringAtTheEnd() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "", "banana", "cherry");
        assertEquals(Arrays.asList("apple", "banana", "cherry", ""), sorter.sortStrings(list, ""));
    }

    @Test
    public void sortsList_WhenExceptionCharIsNull() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "", "banana", "cherry");
        assertEquals(Arrays.asList("", "apple", "banana", "cherry"), sorter.sortStrings(list, null));
    }

    @Test
    public void sortsWordsWithExceptionChar_InReverseOrder() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "avocado");
        assertEquals(Arrays.asList("avocado", "apple"), sorter.sortStrings(list, "a"));
    }

    @Test
    public void sortsWords_WhenNoWordsWithExceptionChar() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("banana", "cherry", "date");
        assertEquals(Arrays.asList("banana", "cherry", "date"), sorter.sortStrings(list, "a"));
    }

    @Test
    public void sortsWords_SeparatingWordsWithExceptionChar() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "banana", "avocado", "cherry");
        assertEquals(Arrays.asList("banana", "cherry", "avocado", "apple"), sorter.sortStrings(list, "a"));
    }

    @Test
    public void sortsWords_RemovingNullElements() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList(null, "banana", "avocado", "cherry");
        assertEquals(Arrays.asList("banana", "cherry", "avocado"), sorter.sortStrings(list, "a"));
    }

    @Test
    public void sortsWords_PuttingEmptyStringAtTheBeginning() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("", "banana", "avocado", "cherry");
        assertEquals(Arrays.asList("", "banana", "cherry", "avocado"), sorter.sortStrings(list, "a"));
    }

    @Test
    public void sortsWords_WhenPrefixIsMultipleCharacters() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "banana", "avocado", "applause", "cherry");
        assertEquals(Arrays.asList("avocado", "banana", "cherry", "apple", "applause"), sorter.sortStrings(list, "app"));
    }

    @Test
    public void sortsWords_WhenPrefixIsNumber() {
        StringSorter sorter = new StringSorter();
        List<String> list = Arrays.asList("apple", "3banana", "avocado", "3cherry");
        assertEquals(Arrays.asList("apple", "avocado", "3cherry", "3banana"), sorter.sortStrings(list, "3"));
    }

    @Test
    public void sortsWords_WhenInputListIsNull() {
        StringSorter sorter = new StringSorter();
        assertEquals(Collections.emptyList(), sorter.sortStrings(null, "a"));
    }

    @Test
    public void sortsWords_WhenBothListAndExceptionCharAreNull() {
        StringSorter sorter = new StringSorter();
        assertEquals(Collections.emptyList(), sorter.sortStrings(null, null));
    }
}
