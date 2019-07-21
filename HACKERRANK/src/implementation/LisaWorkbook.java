package implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/20/17.
 */

public class LisaWorkbook {

  public static void main(String[] args) {

    Scanner sn = new Scanner(System.in);
    int n = sn.nextInt();
    int k = sn.nextInt();
    int[] m = new int[n];
    int j = 2;
    int x = 0;
    int y;
    int count = 0;

    for (int i = 0; i < n; i++) {
      m[i] = sn.nextInt();
    }

    for (int i = 0; i < n; i++) {
      x = x + ((j - 2) / k) + 1;
      for (j = 1; j <= m[i]; j++) {
        y = x + (j - 1) / k;
        if (j == y)
          count++;
      }
    }
    System.out.println(count);
  }
}