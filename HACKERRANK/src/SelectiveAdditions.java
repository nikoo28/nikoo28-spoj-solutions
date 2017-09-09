import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// My submission.
// Fails some test cases

public class SelectiveAdditions {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] A = new int[n];
    for (int A_i = 0; A_i < n; A_i++) {
      A[A_i] = in.nextInt();
    }
    List<Integer> favoriteList = new ArrayList<>();
    int[] S = new int[k];
    for (int S_i = 0; S_i < k; S_i++) {
      favoriteList.add(in.nextInt());
    }
    for (int a0 = 0; a0 < m; a0++) {
      int l = in.nextInt();
      int r = in.nextInt();
      int x = in.nextInt();
      // Write Your Code Here

      long sum = 0;
      for (int i = 0; i < A.length; i++) {

        if (i >= (l - 1) && i < r) {
          if (favoriteList.contains(A[i])) {
            sum += A[i];
            continue;
          }

          A[i] = A[i] + x;
          sum += A[i];
          continue;
        }

        sum += A[i];
      }

      System.out.println(sum);


    }
    in.close();
  }

}
