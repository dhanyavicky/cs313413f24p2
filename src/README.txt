TestIterator
// TODO also try with a LinkedList - does it make any difference?
// To test with LinkedList
  list = new LinkedList<Integer>();
  For the purposes of iterating through the list with an Iterator, both ArrayList and LinkedList will provide similar results, as both implement the List interface and their iterator() method allows forward traversal of the list.
  However, if you we are adding or removing elements frequently during iteration, or accessing elements by index, you would notice differences in performance:
  ArrayList might be slower when removing elements from the beginning or middle of the list, as this requires shifting the remaining elements.
  LinkedList, would handle removals more efficiently, especially for elements at the beginning or middle, since it simply adjusts pointers without shifting elements.
    // TODO fix the expected values in the assertions below
    // TODO what happens if you use list.remove(Integer.valueOf(77))?
    // TODO using assertEquals and List.of, express which values are left in the list
    // TODO use an iterator and a while loop to compute the average (mean) of the values

TestList

    // TODO also try with a LinkedList - does it make any difference?
    // TODO fix the expected values in the assertions below
    // TODO write assertions using
    // TODO fix the expected values in the assertions below
    // TODO fix the expected values in the assertions below
    // TODO fix the expected values in the assertions below
    // TODO using containsAll and List.of (see above),
    // TODO in a single statement using addAll and List.of,
    // TODO in a single statement using removeAll and List.of,
    // TODO in a single statement using retainAll and List.of,
    // TODO use the set method to change specific elements in the list
    // TODO fix the arguments in the subList method so that the assertion

TestPerformance

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // TODO (optional) refactor to DRY
  // TODO choose this value in such a way that you can observe an actual effect
