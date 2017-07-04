package Implementation;

import java.util.*;

public class AppleAndOrange {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int t = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int m = in.nextInt();
    int n = in.nextInt();
    int[] apple = new int[m];
    int appleCount = 0;
    int orangeCount = 0;
    for (int apple_i = 0; apple_i < m; apple_i++) {
      apple[apple_i] = in.nextInt();
      if (apple[apple_i] < (s - a) ||
          apple[apple_i] > (t - a))
        continue;

      appleCount++;
    }
    int[] orange = new int[n];
    for (int orange_i = 0; orange_i < n; orange_i++) {
      orange[orange_i] = in.nextInt();
      if (orange[orange_i] > (t - b) ||
          orange[orange_i] < (s - b))
        continue;

      orangeCount++;
    }

    System.out.println(appleCount);
    System.out.println(orangeCount);

  }
}

