import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BetweenTwoSets {

  static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  static int getLCM(int[] a) {

    if (a.length == 1)
      return a[0];

    if (a.length == 2)
      return (a[0] * a[1]) / gcd(a[0], a[1]);

    int lcm = (a[0] * a[1]) / gcd(a[0], a[1]);
    for (int i = 2; i < a.length; i++) {
      lcm = (lcm * a[i]) / gcd(lcm, a[i]);
    }
    return lcm;
  }

  static int getTotalX(int[] a, int[] b) {
    // Complete this function
    int lcm = getLCM(a);
    int multiple = lcm;

    int maxB = -1;
    for (int i : b) {
      if (i > maxB)
        maxB = i;
    }

    int setNumbers = 0;
    List<Integer> xList = new ArrayList<>();
    while (lcm <= maxB) {
      xList.add(lcm);
      lcm += multiple;
    }

    List<Integer> finalSet = new ArrayList<>();
    for (int x : xList) {
      boolean isCandidate = true;
      for (int i = 0; i < b.length; i++) {
        if ((b[i] % x) != 0) {
          isCandidate = false;
          break;
        }
      }

      if (isCandidate)
        finalSet.add(x);
    }

    return finalSet.size();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int[] b = new int[m];
    for (int b_i = 0; b_i < m; b_i++) {
      b[b_i] = in.nextInt();
    }
    int total = getTotalX(a, b);
    System.out.println(total);
  }
}

