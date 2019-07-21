package implementation;

import java.util.Scanner;

/**
 * Created by nikhil.lohia on 6/28/2017.
 */
public class ManasaAndStones {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int cases = in.nextInt();
    for (int j = 0; j < cases; j++) {
      int n = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();
      if (a == b) System.out.print((n - 1) * a);
      else {
        if (a > b) {
          int temp = a;
          a = b;
          b = temp;
        }
        for (int i = 0; i < n; i++) System.out.print(i * b + (n - 1 - i) * a + " ");
      }
      System.out.println();
    }
  }
}

