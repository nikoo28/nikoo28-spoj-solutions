import java.io.*;
import java.util.*;

public class SherlockAndSquares {

  public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    int cases = scanner.nextInt();
    for (int i = 0; i < cases; i++) {
      double a = scanner.nextDouble();
      double b = scanner.nextDouble();
      double x = 0;
      if (a != 1)
        x = Math.floor(Math.sqrt(a - 1));
      double y = Math.floor(Math.sqrt(b));
      System.out.println((int) (y - x));
    }

  }
}