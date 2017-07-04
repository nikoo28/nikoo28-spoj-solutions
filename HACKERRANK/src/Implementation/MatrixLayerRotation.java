package Implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 7/2/17.
 */
public class MatrixLayerRotation {

  private static int[][] rotateMatrixBy90DegreeCounterClockwise(int[][] matrix) {

    return rotateMatrixBy90DegreeClockwise(
        rotateMatrixBy90DegreeClockwise(
            rotateMatrixBy90DegreeClockwise(matrix)));
  }

  private static int[][] rotateMatrixBy90DegreeClockwise(int[][] matrix) {

    int row = matrix.length; //Total columns of Original Matrix
    int col = matrix[0].length; //Total rows of Original Matrix

    int[][] newa = new int[col][row];

    for (int j = 0; j < col; j++) {
      for (int i = 0, k = row - 1; i < row; i++, k--) {
        newa[j][i] = matrix[k][j];
      }
    }
    return newa;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int M = scanner.nextInt();
    int N = scanner.nextInt();
    int R = scanner.nextInt();
    int[][] matrix = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    for (int i = 0; i < R; i++) {
      matrix = rotateMatrixBy90DegreeCounterClockwise(matrix);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

}
