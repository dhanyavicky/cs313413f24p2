TestIterator
// TODO also try with a LinkedList - does it make any difference?
// To test with LinkedList
  list = new LinkedList<Integer>();
  For the purposes of iterating through the list with an Iterator, both ArrayList and LinkedList will provide similar results, as both implement the List interface and their iterator() method allows forward traversal of the list.
  However, if you we are adding or removing elements frequently during iteration, or accessing elements by index, you would notice differences in performance:
  ArrayList might be slower when removing elements from the beginning or middle of the list, as this requires shifting the remaining elements.
  LinkedList, would handle removals more efficiently, especially for elements at the beginning or middle, since it simply adjusts pointers without shifting elements.

    // TODO fix the expected values in the assertions below
       assertEquals(77, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(44, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(77, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(55, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(77, i.next().intValue());
        assertTrue(i.hasNext());
        assertEquals(66, i.next().intValue());
        assertFalse(i.hasNext());
    // TODO what happens if you use list.remove(Integer.valueOf(77))?
    the remove method attempts to remove the first occurrence of the element 77 from the list
    list.remove(Integer.valueOf(77))
    The Integer.valueOf(77) creates an Integer object with the value 77.
    The remove(Object o) method is then called with this object.
    The list will be traversed, and the first occurrence of the integer 77 will be removed from the list.
    // TODO using assertEquals and List.of, express which values are left in the list
    the list should no longer contain any 77
    // TODO use an iterator and a while loop to compute the average (mean) of the values
      final var i = list.iterator();
          while (i.hasNext()){
            sum += i.next();
            n++;
TestList

    // TODO also try with a LinkedList - does it make any difference?
    public void setUp() throws Exception {
        // Use a system property to choose between ArrayList and LinkedList
        String listType = System.getProperty("listType", "ArrayList"); // Default to ArrayList

        if ("LinkedList".equalsIgnoreCase(listType)) {
            list = new LinkedList<>();
        } else {
            list = new ArrayList<>();
        }
    }
    // TODO fix the expected values in the assertions below
    assertEquals(1, list.size()); //one element in the list
        assertEquals(77, list.get(0).intValue()); //first element is 77
    // TODO write assertions using
    assertFalse(list.contains(77)); //list does not contain 77 initially
        list.add(77);
        assertTrue(list.contains(77));
    // TODO fix the expected values in the assertions below
    assertEquals(3, list.size()); //list size is 3
        assertEquals(0, list.indexOf(77)); //first 77 is at index 0
        assertEquals(77, list.get(1).intValue()); // second element is 77
        assertEquals(2, list.lastIndexOf(77)); // last 77 is at index 2
    // TODO fix the expected values in the assertions below
    assertEquals(7, list.size()); // list size is 7
        assertEquals(1, list.indexOf(77)); //First 77 is at index 1
        assertEquals(5, list.lastIndexOf(77)); // Last 77 is at index 5
        assertEquals(44, list.get(2).intValue()); // Element at index 2 is 44
        assertEquals(77, list.get(3).intValue()); // Element at index 3 is 77
        assertEquals(List.of(33, 77, 44, 77, 55, 77, 66), list);
    // TODO fix the expected values in the assertions below
    assertEquals(6, list.size());
        assertEquals(1, list.indexOf(77));
        assertEquals(3, list.lastIndexOf(77));
    // TODO using containsAll and List.of (see above),
    // 1) assert that list contains all five different numbers added
        assertTrue(list.containsAll(List.of(33, 77, 44, 55, 66))); // checks that the list contains all the elements [33, 77, 44, 55, 66]
        // 2) assert that list does not contain all of 11, 22, and 33
        assertFalse(list.containsAll(List.of(11, 22, 33))); // checks that the list does not contain [11, 22, 33]
        //fail("Not yet implemented"); // remove this line when done
    // TODO in a single statement using addAll and List.of,
list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    // TODO in a single statement using removeAll and List.of,
 list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    list.removeAll(List.of(33, 44, 55, 66)); //remove these elements
    // TODO in a single statement using retainAll and List.of,
    // TODO use the set method to change specific elements in the list
    // TODO fix the arguments in the subList method so that the assertion

TestPerformance

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // TODO (optional) refactor to DRY
  // TODO choose this value in such a way that you can observe an actual effect
