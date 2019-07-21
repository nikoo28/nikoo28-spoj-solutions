package implementation;

import java.util.Scanner;

/**
 * Created by nikhil.lohia on 6/28/2017.
 */
public class FairRations {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int B[] = new int[N];
    for (int B_i = 0; B_i < N; B_i++) {
      B[B_i] = in.nextInt();
    }

    int counter = 0;
    for (int i = 0; i < N; i++) {

      if (isEven(B[i]))
        continue;

      if (i + 1 != N && !isEven(B[i+1])) {
        counter += 2;
        B[i] += 1;
        B[i+1] += 1;
        continue;
      }

      if (i + 1 == N) {
        counter += 2;
        B[i] += 1;
        B[i-1] += 1;
        continue;
      }

      B[i] += 1;
      B[i+1] += 1;
      counter += 2;
      continue;
    }

    if (isSettled(B))
      System.out.println(counter);
    else
      System.out.println("NO");
  }

  public static boolean isEven(int num) {
    return (num & 1) == 0;
  }

  private static boolean isSettled(int[] b) {
    boolean flag = true;

    for (int i : b) {
      if ((i & 1) == 1) {
        flag = false;
        break;
      }
    }
    return flag;
  }
}

