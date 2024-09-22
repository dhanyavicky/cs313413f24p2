package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  private final int SIZE = 10000;

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private int REPS; // Declare REPS without initialization here

  private List<Integer> arrayList;
  private List<Integer> linkedList;

  // Helper method to initialize both lists
  private void initializeLists() {
    arrayList = new ArrayList<>(SIZE);
    linkedList = new LinkedList<>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }
  @Before
  public void setUp() throws Exception {
    REPS = Math.max(10000, 1000000 / SIZE); // Calculate REPS here
    initializeLists();
//    arrayList = new ArrayList<Integer>(SIZE);
//    linkedList = new LinkedList<Integer>();
//    for (var i = 0; i < SIZE; i++) {
//      arrayList.add(i);
//      linkedList.add(i);
//    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  // DRY refactor: Helper method to measure and print execution time
  private void measureTime(String testName, Runnable test) {
    long startTime = System.currentTimeMillis();
    test.run();
    long endTime = System.currentTimeMillis();
    System.out.println(testName + " took " + (endTime - startTime) + " ms");
  }

  @Test
  public void testLinkedListAddRemove() {
    measureTime("LinkedList Add/Remove", () -> {
      for (var r = 0; r < REPS; r++) {
        linkedList.add(0, 77);
        linkedList.remove(0);
      }
    });
  }

  @Test
  public void testArrayListAddRemove() {
    measureTime("ArrayList Add/Remove", () -> {
      for (var r = 0; r < REPS; r++) {
        arrayList.add(0, 77);
        arrayList.remove(0);
      }
    });
  }

  @Test
  public void testLinkedListAccess() {
    measureTime("LinkedList Access", () -> {
      long sum = 0;
      for (var r = 0; r < REPS; r++) {
        sum += linkedList.get(r % SIZE);
      }
    });
  }

  @Test
  public void testArrayListAccess() {
    measureTime("ArrayList Access", () -> {
      long sum = 0;
      for (var r = 0; r < REPS; r++) {
        sum += arrayList.get(r % SIZE);
      }
    });
  }
}