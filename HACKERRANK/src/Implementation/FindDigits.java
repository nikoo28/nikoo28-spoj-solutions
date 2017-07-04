package Implementation;

import java.util.*;

public class FindDigits {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for (int i = 0; i < testCases; i++) {
      int n = in.nextInt();
      int r = n;
      int count = 0;
      while (r > 0) {
        if (r % 10 != 0 && n % (r % 10) == 0) count++;
        r = r / 10;
      }
      System.out.println(count);
    }
  }
}