package Implementation;

import java.util.*;

public class AppendAndDelete {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String t = in.next();
    int k = in.nextInt();

    int commonLength = 0;

    for (int i = 0; i < java.lang.Math.min(s.length(), t.length()); i++) {
      if (s.charAt(i) == t.charAt(i))
        commonLength++;
      else
        break;
    }
    //CASE A
    if ((s.length() + t.length() - 2 * commonLength) > k) {
      System.out.println("No");
    }
    //CASE B
    else if ((s.length() + t.length() - 2 * commonLength) % 2 == k % 2) {
      System.out.println("Yes");
    }
    //CASE C
    else if ((s.length() + t.length() - k) < 0) {
      System.out.println("Yes");
    }
    //CASE D
    else {
      System.out.println("No");
    }
  }
}

