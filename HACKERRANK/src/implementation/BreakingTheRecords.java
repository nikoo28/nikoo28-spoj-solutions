package implementation;

import java.util.Scanner;

public class BreakingTheRecords {

  private static int[] getRecord(int[] s) {
    // Complete this function
    int[] result = new int[2];
    result[0] = 0;
    result[1] = 0;

    int maxScore = s[0];
    int minScore = s[0];

    for (int score : s) {
      if (score > maxScore) {
        maxScore = score;
        result[0]++;
      }

      if (score < minScore) {
        minScore = score;
        result[1]++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] s = new int[n];
    for (int s_i = 0; s_i < n; s_i++) {
      s[s_i] = in.nextInt();
    }
    int[] result = getRecord(s);
    String separator = "", delimiter = " ";
    for (Integer val : result) {
      System.out.print(separator + val);
      separator = delimiter;
    }
    System.out.println("");
  }
}

