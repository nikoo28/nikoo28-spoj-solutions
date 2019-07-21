package implementation;

import java.util.Scanner;

public class BirthdayCakeCandles {

  private static int birthdayCakeCandles(int n, int[] ar) {
    // Complete this function

    int max = -1;
    for (int i : ar) {
      if (i > max)
        max = i;
    }

    int count = 0;
    for (int i : ar) {
      if (i == max)
        count++;
    }

    return count;

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    int result = birthdayCakeCandles(n, ar);
    System.out.println(result);
  }
}

