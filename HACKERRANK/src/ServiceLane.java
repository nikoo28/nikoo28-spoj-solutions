import java.util.Scanner;

/**
 * Created by nikoo28 on 6/28/17.
 */
public class ServiceLane {

  private static int getMinimumBetween(int[] widths, int i, int j) {

    int minimum = Integer.MAX_VALUE;
    final int lowest = 1;

    for (int k = i; k <= j; k++) {
      if (widths[k] == lowest)
        return lowest;

      if (widths[k] <= minimum)
        minimum = widths[k];
    }
    return minimum;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int t = scanner.nextInt();
    int[] widths = new int[n];
    for (int i = 0; i < n; i++) {
      widths[i] = scanner.nextInt();
    }

    for (int x = 0; x < t; x++) {
      int i = scanner.nextInt();
      int j = scanner.nextInt();

      System.out.println(getMinimumBetween(widths, i, j));
    }

  }

}
