package Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringConstruction {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int a0 = 0; a0 < n; a0++) {
      String s = in.next();
      Set<Character> charSet = new HashSet<>();
      char[] c = s.toCharArray();
      for (char ch : c) {
        charSet.add(ch);
      }
      System.out.println(charSet.size());
    }
  }
}
