import java.util.Scanner;

/**
 * Created by nikoo28 on 6/21/17.
 */

public class TaumAndBday {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      long b = in.nextLong();
      long w = in.nextLong();
      long x = in.nextLong();
      long y = in.nextLong();
      long z = in.nextLong();

      x = x > y ? ((x - y > z) ? y + z : x) : x;
      y = y > x ? ((y - x > z) ? x + z : y) : y;
      System.out.println(b * x + w * y);

    }
  }
}

