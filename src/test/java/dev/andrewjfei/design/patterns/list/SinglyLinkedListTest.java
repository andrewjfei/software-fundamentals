package dev.andrewjfei.design.patterns.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.List;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> singlyLinkedList;

    @BeforeEach
    void setUp() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    void testAdd_withEmptyList_returnsSuccessfully() throws UnexpectedException {
        // Given
        Integer expectedElement = 100;

        Assertions.assertEquals(0, singlyLinkedList.size());
        Assertions.assertTrue(singlyLinkedList.isEmpty());

        // When
        singlyLinkedList.add(expectedElement);

        // Then
        Assertions.assertEquals(1, singlyLinkedList.size());
        Assertions.assertFalse(singlyLinkedList.isEmpty());
        Assertions.assertTrue(singlyLinkedList.contains(expectedElement));
        Assertions.assertEquals(expectedElement, singlyLinkedList.get(0));
    }

    @Test
    void testAdd_withNonEmptyList_returnsSuccessfully() throws UnexpectedException {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Integer expectedElement = 10000;

        Assertions.assertEquals(elementList.size(), singlyLinkedList.size());
        Assertions.assertFalse(singlyLinkedList.isEmpty());

        // When
        singlyLinkedList.add(expectedElement);

        // Then
        Assertions.assertEquals(elementList.size() + 1, singlyLinkedList.size());
        Assertions.assertFalse(singlyLinkedList.isEmpty());
        Assertions.assertTrue(singlyLinkedList.contains(expectedElement));
        Assertions.assertEquals(expectedElement, singlyLinkedList.get(elementList.size()));
    }

    @Test
    void testGet_withValidIndex_returnsSuccessfully() throws UnexpectedException {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Integer expectedElement = 1000;

        Assertions.assertEquals(elementList.size(), singlyLinkedList.size());

        // When
        Integer element = singlyLinkedList.get(elementList.size() - 1);

        // Then
        Assertions.assertEquals(expectedElement, element);
    }

    @Test
    void testGet_withInvalidIndex_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Assertions.assertEquals(elementList.size(), singlyLinkedList.size());

        // When
        // Then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.get(elementList.size() + 1);
        });
    }

    @Test
    void testRemove_withValidIndex_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Integer removedElement = 1000;

        Assertions.assertTrue(singlyLinkedList.contains(removedElement));
        Assertions.assertEquals(elementList.size(), singlyLinkedList.size());

        // When
        singlyLinkedList.remove(elementList.size() - 1);

        // Then
        Assertions.assertFalse(singlyLinkedList.contains(removedElement));
        Assertions.assertEquals(elementList.size() - 1, singlyLinkedList.size());
    }

    @Test
    void testRemove_withInvalidIndex_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Assertions.assertEquals(elementList.size(), singlyLinkedList.size());

        // When
        // Then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            singlyLinkedList.remove(elementList.size() + 1);
        });
    }

    @Test
    void testContains_withExistingElement_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Integer element = 1000;

        // When
        // Then
        Assertions.assertTrue(singlyLinkedList.contains(element));
    }

    @Test
    void testContains_withNonExistingElement_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Integer element = 10000;

        // When
        // Then
        Assertions.assertFalse(singlyLinkedList.contains(element));
    }

    @Test
    void testSize_whenListIsEmpty_returnsSuccessfully() {
        // Given
        Assertions.assertTrue(singlyLinkedList.isEmpty());

        // When
        // Then
        Assertions.assertEquals(0, singlyLinkedList.size());
    }

    @Test
    void testSize_whenListIsNotEmpty_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        Assertions.assertFalse(singlyLinkedList.isEmpty());

        // When
        // Then
        Assertions.assertEquals(elementList.size(), singlyLinkedList.size());
    }

    @Test
    void testIsEmpty_whenListIsEmpty_returnsSuccessfully() {
        // Given
        // When
        // Then
        Assertions.assertTrue(singlyLinkedList.isEmpty());
    }

    @Test
    void testIsEmpty_whenListIsNotEmpty_returnsSuccessfully() {
        // Given
        List<Integer> elementList = Arrays.asList(0, 10, 100, 1000);
        addElementsToList(elementList);

        // When
        // Then
        Assertions.assertFalse(singlyLinkedList.isEmpty());
    }

    private void addElementsToList(List<Integer> elementList) {
        for (Integer element : elementList) {
            singlyLinkedList.add(element);
        }
    }
}
