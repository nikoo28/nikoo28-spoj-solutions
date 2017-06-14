import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClimbingTheLeaderboard {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] scores = new int[n];
    for (int scores_i = 0; scores_i < n; scores_i++) {
      scores[scores_i] = in.nextInt();
    }
    int m = in.nextInt();
    int[] alice = new int[m];
    for (int alice_i = 0; alice_i < m; alice_i++) {
      alice[alice_i] = in.nextInt();
    }
    // your code goes here

    int[] ranks = new int[n];
    int rank = 1;
    ranks[0] = 1;
    int prevRankScore = scores[0];
    for (int i = 1; i < n; i++) {
      if (scores[i] == prevRankScore) {
        ranks[i] = rank;
        continue;
      }

      prevRankScore = scores[i];
      rank++;
      ranks[i] = rank;
    }

    int[] aliceRanks = new int[m];
    int lastIndex = n - 1;

    boolean flag = false;

    for (int i = 0; i < m; i++) {

      int scoreToBeRanked = alice[i];
      System.out.println(lastIndex);
      while (scores[lastIndex] < scoreToBeRanked) {
        lastIndex--;
        if (lastIndex == -1) {
          aliceRanks[i] = 1;
          flag = true;
        }
      }

      if (flag) {
        while (i < m) {
          aliceRanks[i] = 1;
          i++;
        }
        break;
      }

      if (scoreToBeRanked == scores[lastIndex]) {
        aliceRanks[i] = ranks[lastIndex];
        continue;
      }

      aliceRanks[i] = ranks[lastIndex] + 1;
    }

    for (int aliceRank : aliceRanks) {
      System.out.println(aliceRank);
    }
  }
}

