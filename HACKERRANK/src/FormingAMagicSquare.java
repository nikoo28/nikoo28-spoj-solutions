import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FormingAMagicSquare {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] s = new int[3][3];
    for (int s_i = 0; s_i < 3; s_i++) {
      for (int s_j = 0; s_j < 3; s_j++) {
        s[s_i][s_j] = in.nextInt();
      }
    }

    int[][][] magic_mat = {
        {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
        {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
        {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
        {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
        {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
        {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
        {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
    };

    int min_cost = 81;
    for (int k = 0; k < 8; k++) {
      int crt_cost = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++)
          crt_cost += Math.abs(s[i][j] - magic_mat[k][i][j]);
      }
      if (crt_cost < min_cost)
        min_cost = crt_cost;
    }

    System.out.println(min_cost);

    //  Print the minimum cost of converting 's' into a magic square
  }
}

