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
  private static final int[] SIZES = {10, 100, 1000, 10000, 100000};

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes
  private final int REPS = 1000000; // Number of repetitions to see noticeable performance differences

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<>(SIZE);
    linkedList = new LinkedList<>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  private void measurePerformance(String operation, Runnable task) {
    long startTime = System.nanoTime();
    task.run();
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
    System.out.println(operation + " took " + duration + " ms");
  }

  @Test
  public void testLinkedListAddRemove() {
    measurePerformance("LinkedList Add/Remove", () -> {
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  });
  }

  @Test
  public void testArrayListAddRemove() {
    measurePerformance("ArrayList Add/Remove", () -> {
      for (var r = 0; r < REPS; r++) {
        arrayList.add(0, 77);
        arrayList.remove(0);
      }
    });
  }
  @Test
  public void testLinkedListAccess() {
    measurePerformance("LinkedList Access", () -> {
      var sum = 0L;
      for (var r = 0; r < REPS; r++) {
        sum += linkedList.get(r % SIZE);
      }
    });
  }

  @Test
  public void testArrayListAccess() {
    measurePerformance("ArrayList Access", () -> {
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
     }
    });
  }
}
