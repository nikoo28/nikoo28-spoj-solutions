package Implementation;

import java.util.*;

public class ViralAdvertising {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner keyboard = new Scanner(System.in);

    int num = keyboard.nextInt();
    int people = 5;
    int sum = 0;

    for (int i = 0; i < num; i++) {
      people = (int) Math.floor(people / 2);
      sum += people;
      people *= 3;
    }


    System.out.println(sum);
  }
}