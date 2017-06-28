import java.util.Scanner;

/**
 * Created by nikoo28 on 6/28/17.
 */
public class ChocolateFeast {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for (int a0 = 0; a0 < t; a0++) {

      int n = in.nextInt();
      int c = in.nextInt();
      int m = in.nextInt();

      int totalChoc = n / c;
      int totalWrappers = totalChoc;
      int freeChocs = 0;

      while (m <= totalWrappers) {

        int wrapperTogive = totalWrappers - (totalWrappers % m);
        freeChocs = totalWrappers / m;
        totalWrappers = (totalWrappers - wrapperTogive) + freeChocs;
        totalChoc = totalChoc + freeChocs;
      }

      System.out.println(totalChoc);
    }
  }

}
