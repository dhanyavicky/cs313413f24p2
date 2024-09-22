package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestList {

  private List<Integer> list;

  @Before
  public void setUp() throws Exception {
    //Here it was mentioned testing with both ArrayList and LinkedList. To switch btw them, we could conditionally initialize list
    list = new ArrayList<>();
    // TODO also try with a LinkedList - does it make any difference?
    //can change to new LinkedList<>(); - to test with LinkedList

    //public void setUp() throws Exception {
      // Use a system property to choose between ArrayList and LinkedList
      //String listType = System.getProperty("listType", "ArrayList"); // Default to ArrayList

      //if ("LinkedList".equalsIgnoreCase(listType)) {
      //  list = new LinkedList<>();
     // } else {
      //  list = new ArrayList<>();
     // }
    //}
 // }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  @Test
  public void testSizeEmpty() {
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
    try {
      list.get(0);
      fail("there should not be any items in the list");
    } catch (Exception ex) {
    }
  }

  @Test
  public void testSizeNonEmpty() {
    //in this tc, 77 has been added to the list, but expected values are incorrect
    // TODO fix the expected values in the assertions below
    list.add(77);
    assertEquals(false, list.isEmpty()); //the list is not empty now
    assertEquals(1, list.size()); //one element in the list
    assertEquals(77, list.get(0).intValue()); //first element is 77
  }

  @Test
  public void testContains() {
    //It's required to write assertions for the contains() method before and after adding 77.
    // TODO write assertions using
    assertFalse(list.contains(77)); //list does not contain 77 initially
    list.add(77);
    // list.contains(77)
    assertTrue(list.contains(77)); //list contains 77 after adding it
    // that hold before and after adding 77 to the list
    //fail("Not yet implemented"); // remove this line when done
  }

  @Test
  public void testAddMultiple() {
    //Here we are adding three instances of 77 to the list, the expected values in the assertions need to be fixed.
    list.add(77);
    list.add(77);
    list.add(77);
    // TODO fix the expected values in the assertions below
    assertEquals(3, list.size()); //list size is 3
    assertEquals(0, list.indexOf(77)); //first 77 is at index 0
    assertEquals(77, list.get(1).intValue()); // second element is 77
    assertEquals(2, list.lastIndexOf(77)); // last 77 is at index 2
  }

  @Test
  public void testAddMultiple2() {
    //here we add multiple numbers and need to correct the expected values
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // TODO fix the expected values in the assertions below
    assertEquals(7, list.size()); // list size is 7
    assertEquals(1, list.indexOf(77)); //First 77 is at index 1
    assertEquals(5, list.lastIndexOf(77)); // Last 77 is at index 5
    assertEquals(44, list.get(2).intValue()); // Element at index 2 is 44
    assertEquals(77, list.get(3).intValue()); // Element at index 3 is 77
    assertEquals(List.of(33, 77, 44, 77, 55, 77, 66), list);
  }

  @Test
  public void testRemoveObject() {
    //we are testing both list.remove(index) and list.remove(Integer)
    list.add(3);
    list.add(77);
    list.add(4);
    list.add(77);
    list.add(5);
    list.add(77);
    list.add(6);
    list.remove(5); // what does this method do? ans: this removes the element at index 5 (77)
    // TODO fix the expected values in the assertions below
    assertEquals(6, list.size());
    assertEquals(1, list.indexOf(77));
    assertEquals(3, list.lastIndexOf(77));
    //assertEquals(0, list.get(2).intValue());
    //assertEquals(0, list.get(3).intValue());
    list.remove(Integer.valueOf(5)); // what does this one do? ans: this removes the first occurrence of 5
    assertEquals(5, list.size());
    assertEquals(1, list.indexOf(77));
    assertEquals(3, list.lastIndexOf(77));
    //assertEquals(0, list.get(2).intValue());
    //assertEquals(0, list.get(3).intValue());
  }

  @Test
  public void testContainsAll() {
    // we are trying to test if the list contains certain elements using containsAll()
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // TODO using containsAll and List.of (see above),
    // 1) assert that list contains all five different numbers added
    assertTrue(list.containsAll(List.of(33, 77, 44, 55, 66))); // checks that the list contains all the elements [33, 77, 44, 55, 66]
    // 2) assert that list does not contain all of 11, 22, and 33
    assertFalse(list.containsAll(List.of(11, 22, 33))); // checks that the list does not contain [11, 22, 33]
    //fail("Not yet implemented"); // remove this line when done
  }

  @Test
  public void testAddAll() {
    //here we can use addAll(0 to add multiple items in a single call
    // TODO in a single statement using addAll and List.of,
    // add items to the list to make the following assertions pass
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    // (without touching the assertions themselves)
    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(77, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(77, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testRemoveAll() {
    //we are removing certain elements from the list using removeAll()
    // TODO in a single statement using removeAll and List.of,
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    // remove items from the list to make the following assertions pass
    list.removeAll(List.of(33, 44, 55, 66)); //remove these elements
    // (without touching the assertions themselves)
    assertEquals(3, list.size());
    assertEquals(List.of(77, 77, 77), list); //only 77s should remain
  }

  @Test
  public void testRetainAll() {
    //Use retainAll() to keep only the elements in a specific collection
    // TODO in a single statement using retainAll and List.of,
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    // remove items from the list to make the following assertions pass
    list.retainAll(List.of(77)); //retains only 77s
    // (without touching the assertions themselves)
    assertEquals(3, list.size());
    assertEquals(List.of(77, 77, 77), list);
  }

  @Test
  public void testSet() {
    //trying to modify specific elements using set()
    // TODO use the set method to change specific elements in the list
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    list.set(1, 99); // change the element at index 1 to 99
    list.set(3, 99); // change the element at index 3 to 99
    list.set(5, 99); // change the element at index 5 to 99
    // such that the following assertions pass
    // (without touching the assertions themselves)
    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(99, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(99, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(99, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testSubList() {
    // fix the arguments to return the correct sublist
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // TODO fix the arguments in the subList method so that the assertion
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    // passes
    assertEquals(List.of(44, 77, 55), list.subList(2, 5)); //correct indices for subList
  }
}
