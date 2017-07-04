package Implementation; /**
 * Created by nikoo28 on 6/29/17.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by nikhil.lohia on 6/29/2017.
 */
public class HappyLadybugs {

  public static boolean isEven(int num) {
    return (num & 1) == 0;
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int games = scanner.nextInt();
    for (int i = 0; i < games; i++) {

      boolean flag = true;
      boolean isEmptySpaceAvailable = false;

      int n = scanner.nextInt();
      String b = scanner.next();
      int[] chars = new int[26];

      for (int j = 0; j < b.length(); j++) {
        char x = b.charAt(j);
        if (x == '_') {
          isEmptySpaceAvailable = true;
          continue;
        }
        chars[x - 'A']++;
      }

      for (int aChar : chars) {
        if (aChar == 1) {
          flag = false;
          break;
        }
      }

      if (flag == false) {
        System.out.println("NO");
        continue;
      }

      if (isAlreadySolved(b)) {
        System.out.println("YES");
        continue;
      }

      if (!isEmptySpaceAvailable) {
        System.out.println("NO");
        continue;
      }

      System.out.println("YES");
    }
  }

  private static boolean isAlreadySolved(String b) {

    boolean flag = true;

    Set<Character> charSet = new HashSet<>();

    char prevChar = b.charAt(0);
    charSet.add(prevChar);

    for (int i = 1; i < b.length(); i++) {

      if (b.charAt(i) == prevChar)
        continue;

      if (charSet.contains(b.charAt(i))) {
        flag = false;
        break;
      }

      prevChar = b.charAt(i);
      charSet.add(prevChar);
    }

    return flag;
  }

}