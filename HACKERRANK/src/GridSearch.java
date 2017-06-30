/**
 * Created by nikoo28 on 6/29/17.
 */

import java.util.Scanner;

/**
 * Created by nikhil.lohia on 6/28/2017.
 */
public class GridSearch {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int steps = Integer.parseInt(scan.nextLine());
    while (steps > 0) {
      int sr = scan.nextInt();
      int sc = scan.nextInt();
      boolean found = false;
      scan.nextLine();
      int[][] m1 = new int[sr][sc];
      for (int i = 0; i < sr; i++) {
        String row = scan.nextLine();
        for (int j = 0; j < sc; j++) {
          m1[i][j] = (int) (row.charAt(j));
        }

      }

      int fr = scan.nextInt();
      int fc = scan.nextInt();

      scan.nextLine();
      int[][] m2 = new int[fr][fc];

      for (int i = 0; i < fr; i++) {
        String row = scan.nextLine();

        for (int j = 0; j < fc; j++) {
          m2[i][j] = (int) (row.charAt(j));
        }

      }

       /*  System.out.println(Arrays.deepToString(m1));
        System.out.println(Arrays.deepToString(m2)); */
      outLoop:
      for (int i = 0; i < sr; i++) {
        for (int j = 0; j < sc; j++) {
          if (m1[i][j] == m2[0][0]) {
            if (isMatrix(m1, m2, fr, fc, i, j)) {
              found = true;
              break outLoop;
            } else {
              found = false;
            }
          }
        }
      }

      String r = (found == true) ? "YES" : "NO";
      System.out.println(r);

      steps--;
    }
  }

  public static boolean isMatrix(int[][] m1, int[][] m2, int fr, int fc, int i, int j) {
    boolean found = true;
    for (int a = 0; a < fr; a++) {
      for (int b = 0; b < fc; b++) {
        try {
          if (m2[a][b] != m1[i + a][j + b]) {
            return false;
          }
        } catch (Exception e) {
          return false;
        }

      }
    }
    return true;
  }

}