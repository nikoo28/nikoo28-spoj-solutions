package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class ElectronicsShop {

  private static int getMoneySpent(int[] keyboards, int[] drives, int s) {
    // Complete this function

    Arrays.sort(keyboards);
    Arrays.sort(drives);

    int min;
    if (keyboards[0] + drives[0] > s)
      return -1;

    int smallestBoard = 0;
    int largestDrive = drives.length - 1;

    while (keyboards[smallestBoard] + drives[largestDrive] > s && largestDrive >= 0) {
      largestDrive--;
    }
    min = s - keyboards[smallestBoard] - drives[largestDrive];
    int diff;

    while (smallestBoard < keyboards.length && largestDrive >= 0) {
      diff = s - keyboards[smallestBoard] - drives[largestDrive];
      if (diff >= 0) {
        if (diff < min)
          min = diff;
        smallestBoard++;
      } else
        largestDrive--;
    }
    return s - min;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int n = in.nextInt();
    int m = in.nextInt();
    int[] keyboards = new int[n];
    for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
      keyboards[keyboards_i] = in.nextInt();
    }
    int[] drives = new int[m];
    for (int drives_i = 0; drives_i < m; drives_i++) {
      drives[drives_i] = in.nextInt();
    }
    //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
    int moneySpent = getMoneySpent(keyboards, drives, s);
    System.out.println(moneySpent);
  }
}

