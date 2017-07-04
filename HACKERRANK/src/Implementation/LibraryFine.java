package Implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/18/17.
 */
public class LibraryFine {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int d1 = in.nextInt();
    int m1 = in.nextInt();
    int y1 = in.nextInt();
    int d2 = in.nextInt();
    int m2 = in.nextInt();
    int y2 = in.nextInt();
    if (y1 > y2)
      System.out.println("10000");
    else if (m1 > m2 && y1 == y2)
      System.out.println((m1 - m2) * 500);
    else if (d1 > d2 && m1 == m2 && y1 == y2)
      System.out.println((d1 - d2) * 15);
    else System.out.println("0");
  }

}
