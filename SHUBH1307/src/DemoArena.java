import java.util.LinkedList;

/**
 * Created by nikoo28 on 10/11/16.
 */
public class DemoArena {

  public double average(LinkedList<Integer> integerLinkedList) {

    if (integerLinkedList.size() == 0)
      return 0.0;

    double sum = 0;
    for (Integer integer : integerLinkedList) {
      sum += integer;
    }

    return sum/integerLinkedList.size();

  }

  public static void rec(int[] a) {
    int size = a.length;
    int mid = size/2;
    System.out.println(a[mid]);
    if (size > 1) {
      int[] b = new int[mid];
      for (int i = 0; i < mid; i++) {
        b[i] = a[mid+i] * 10;
      }
      rec(b);
    }
  }

  public static void main(String[] args) {
    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    rec(a);
  }

}
