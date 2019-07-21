package implementation;

import java.util.Scanner;

public class MigratoryBirds {

  private static int migratoryBirds(int n, int[] ar) {
    // Complete this function

    int[] count = new int[5];
    for (int type : ar) {
      count[type - 1]++;
    }

    int type = 0;
    int max = -1;
    for (int i = 0; i < 5; i++) {
      if (count[i] > max) {
        type = (i + 1);
        max = count[i];
      }
    }

    return type;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    int result = migratoryBirds(n, ar);
    System.out.println(result);
  }
}

