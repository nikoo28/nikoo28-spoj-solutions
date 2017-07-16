package Strings;

import java.util.Scanner;

/**
 * Created by nikoo28 on 7/15/17.
 */
public class TheLoveLetterMystery {

  static int theLoveLetterMystery(String s) {

    // Complete this function
    char[] c = s.toCharArray();
    int count = 0;
    for (int i = 0, j = c.length - 1; i < c.length / 2; i++, j--)
      count += Math.abs(c[i] - c[j]);
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      int result = theLoveLetterMystery(s);
      System.out.println(result);
    }
  }
}
