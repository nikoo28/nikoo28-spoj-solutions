import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayChocolate {

  static int solve(int n, int[] s, int d, int m) {
    // Complete this function

    int low = 0;
    int possibilities = 0;

    int[] consecutiveSums = new int[n];
    int temp = 0;
    for (int i = 0; i < m; i++)
      temp += s[i];
    consecutiveSums[m - 1] = temp;
    if (temp == d)
      possibilities++;
    for (int i = m; i < n; i++) {
      consecutiveSums[i] = consecutiveSums[i - 1] + s[i] - s[low];
      if (consecutiveSums[i] == d)
        possibilities++;
      low++;
    }

    return possibilities;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] s = new int[n];
    for (int s_i = 0; s_i < n; s_i++) {
      s[s_i] = in.nextInt();
    }
    int d = in.nextInt();
    int m = in.nextInt();
    int result = solve(n, s, d, m);
    System.out.println(result);
  }
}

