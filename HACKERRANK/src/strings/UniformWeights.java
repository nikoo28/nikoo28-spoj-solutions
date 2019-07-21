package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by nikhil.lohia on 07/17/2017.
 */
public class UniformWeights {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int n = in.nextInt();

    Set<Integer> sumList = new HashSet<>();
    char prev = s.charAt(0);
    sumList.add(prev - 'a' + 1);
    int sum = prev - 'a' + 1;
    for (int i = 1; i < s.length(); i++) {
      char next = s.charAt(i);
      if (next == prev) {
        sum += (prev - 'a' + 1);
        sumList.add(sum);
      } else {
        sumList.add(next - 'a' + 1);
        prev = next;
        sum = prev - 'a' + 1;
      }
    }

    for (int a0 = 0; a0 < n; a0++) {
      int x = in.nextInt();
      // your code goes here
      if (sumList.contains(x))
        System.out.println("Yes");
      else
        System.out.println("No");
    }
  }
}

