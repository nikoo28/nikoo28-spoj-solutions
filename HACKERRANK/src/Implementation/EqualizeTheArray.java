package Implementation;

import java.io.*;
import java.util.*;

public class EqualizeTheArray {

  public static int minDeletions(int[] a) {
    int max = 1;
    Map<Integer, Integer> nums = new HashMap<>();
    for (int i : a)
      if (!nums.containsKey(i))
        nums.put(i, 1);
      else {
        nums.put(i, nums.get(i) + 1);
        if (max < nums.get(i))
          max = nums.get(i);
      }
    return a.length - max;
  }

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    System.out.print(minDeletions(a));
  }
}