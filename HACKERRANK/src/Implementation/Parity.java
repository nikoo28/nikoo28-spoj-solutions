package Implementation; /**
 * Created by nikoo28 on 7/2/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Parity {

  public static boolean isEven(int num) {
    return (num & 1) == 0;
  }

  static boolean toggleFlag(boolean flag) {
    if (flag == true)
      return false;
    else
      return true;
  }

  static int smallestSizeSubsequence(int n, int[] A) {
    // Return the size of the smallest subsequence to remove

    if (n == 1 && !isEven(A[0])) {
      return -1;
    }

    boolean isEvenFlag = true;
    for (int i : A) {
      if (isEven(i))
        continue;
      isEvenFlag = toggleFlag(isEvenFlag);
    }

    if (isEvenFlag)
      return 0;

    return 1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] A = new int[n];
    for (int A_i = 0; A_i < n; A_i++) {
      A[A_i] = in.nextInt();
    }
    int result = smallestSizeSubsequence(n, A);
    System.out.println(result);
  }
}

