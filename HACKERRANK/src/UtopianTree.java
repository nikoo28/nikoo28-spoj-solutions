import java.io.*;
import java.util.*;

public class UtopianTree {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int height = 0;
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      if (n % 2 == 0)
        height = (int) (Math.pow(2, n / 2) - 1) * 2 + 1;
      else
        height = (int) (Math.pow(2, n / 2 + 1) - 1) * 2;

      System.out.println(height);
    }
  }
}