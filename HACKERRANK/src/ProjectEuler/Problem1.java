package ProjectEuler;

import java.util.Scanner;

/**
 * Created by nikhil.lohia on 08/03/2017.
 */
public class Problem1 {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    long t = sc.nextLong();
    for (long i = 0; i < t; i++) {
      long n = sc.nextLong();
      long a = 0, b = 0, d = 0;

      a = (n - 1) / 3;
      b = (n - 1) / 5;
      d = (n - 1) / 15;

      long c = 3 * a * (a + 1) / 2 + 5 * b * (b + 1) / 2 - 15 * d * (d + 1) / 2;
      System.out.println(c);
    }
  }
}