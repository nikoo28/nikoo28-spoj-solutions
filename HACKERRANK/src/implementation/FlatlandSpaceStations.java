package implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/21/17.
 */
public class FlatlandSpaceStations {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    int[] stations = new int[n];
    for (int i = 0; i < m; i++) {
      stations[scanner.nextInt()] = 1;
    }

    int[] leftStations = new int[n];
    int[] rightStations = new int[n];

    int left = n+1;
    int idx = 0;
    while (idx < n) {
      if (stations[idx] == 1) {
        leftStations[idx] = 0;
        left = 0;
        idx++;
        continue;
      }

      left++;
      leftStations[idx] = left;
      idx++;
    }

    int right = n+1;
    idx = n - 1;
    while (idx > -1) {
      if (stations[idx] == 1) {
        rightStations[idx] = 0;
        right = 0;
        idx--;
        continue;
      }

      right++;
      rightStations[idx] = right;
      idx--;
    }

//    for (int leftStation : leftStations) {
//      System.out.print(leftStation + " ");
//    }
//    System.out.println();
//    for (int rightStation : rightStations) {
//      System.out.print(rightStation + " ");
//    }
//    System.out.println();


    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int near = leftStations[i] < rightStations[i] ? leftStations[i] : rightStations[i];
//      System.out.print(near + " ");
      if (near > max) {
        max = near;
      }
    }

//    System.out.println("\n-----");
    System.out.println(max);

  }

}
