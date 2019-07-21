package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by nikoo28 on 7/17/17.
 */
public class GameOfThrones1 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();

    Set<Character> set = new HashSet<Character>();
    for (Character ch : str.toCharArray()) {
      if (set.contains(ch)) {
        set.remove(ch);
      } else {
        set.add(ch);
      }
    }

    System.out.println((set.size() <= 1) ? "YES" : "NO");

    scan.close();

  }

}
