package strings;

import java.util.Scanner;

public class TwoStrings {


  public static boolean hasCommonString(String s1, String s2) {
    return (toInt(s1) & toInt(s2)) > 0;
  }

  private static int toInt(String str) {
    int res = 0;
    for (int i = 0; i < str.length(); i++)
      res |= 1 << (str.charAt(i) - 'a');
    return res;
  }

  static String twoStrings(String s1, String s2) {
    // Complete this function
    if (hasCommonString(s1, s2))
      return "YES";
    else
      return "NO";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s1 = in.next();
      String s2 = in.next();
      String result = twoStrings(s1, s2);
      System.out.println(result);
    }
  }
}