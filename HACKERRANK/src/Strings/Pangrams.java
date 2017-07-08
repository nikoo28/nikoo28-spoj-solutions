package Strings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by nikoo28 on 7/8/17.
 */
public class Pangrams {

  public static void main(String args[]) throws Exception {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    s = s.toLowerCase();
    HashSet<Integer> h = new HashSet<Integer>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        int put = (int) s.charAt(i);
        h.add(put);
      }
    }
    if (h.size() == 26)
      System.out.println("pangram");
    else
      System.out.println("not pangram");
  }
}
