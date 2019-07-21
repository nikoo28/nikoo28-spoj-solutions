package strings;

import java.util.Scanner;

/**
 * Created by nikoo28 on 7/4/17.
 */
public class CamelCase {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    System.out.println(s.length() - s.replaceAll("[A-Z]", "").length() + 1);
  }
}
