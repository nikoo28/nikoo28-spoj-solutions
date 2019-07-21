package implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/23/17.
 */
public class Encryption {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    double row = Math.floor(Math.pow(s.length(), 0.5));
    double col = Math.ceil(Math.pow(s.length(), 0.5));
    String ans = "";
    for (int i = 0; i < col; i++) {
      int j = 0;
      while (i + j < s.length()) {
        ans = ans + s.substring(i + j, i + j + 1);
        j = (int) (j + col);
      }
      ans = ans + " ";
    }
    System.out.println(ans);
  }

}
