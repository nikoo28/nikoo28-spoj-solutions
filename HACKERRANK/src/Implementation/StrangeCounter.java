package Implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/29/17.
 */
public class StrangeCounter {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long t = scanner.nextLong();

    long i = 1;
    long idx = 3;
    long lastCounter = 1;
    while (i <= t) {
      lastCounter = i;
      idx = idx * 2;
      i = idx - 2;
    }

    long diff = t - lastCounter;
    System.out.println(lastCounter + 2 + diff);
  }

}
