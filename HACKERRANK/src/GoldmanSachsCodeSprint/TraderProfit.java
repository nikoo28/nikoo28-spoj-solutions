package GoldmanSachsCodeSprint;

import java.util.Scanner;

public class TraderProfit {

  static int traderProfit(int k, int n, int[] A) {
    // Complete this function

    // table to store results of subproblems
    // profit[t][i] stores maximum profit using atmost
    // t transactions up to day i (including day i)
    int[][] profit = new int[k + 1][n + 1];

    // For day 0, you can't earn money
    // irrespective of how many times you trade
    for (int i = 0; i <= k; i++)
      profit[i][0] = 0;

    // profit is 0 if we don't do any transation
    // (i.e. k =0)
    for (int j = 0; j <= n; j++)
      profit[0][j] = 0;

    // fill the table in bottom-up fashion
    for (int i = 1; i <= k; i++) {

      int prevDiff = Integer.MIN_VALUE;

      for (int j = 1; j < n; j++) {

        prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - A[j - 1]);
        profit[i][j] = Math.max(profit[i][j - 1], A[j] + prevDiff);
      }
    }

    return profit[k][n - 1];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      int k = in.nextInt();
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int arr_i = 0; arr_i < n; arr_i++) {
        arr[arr_i] = in.nextInt();
      }
      int result = traderProfit(k, n, arr);
      System.out.println(result);
    }
    in.close();
  }

}
