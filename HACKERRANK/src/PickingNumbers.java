import java.util.*;

public class PickingNumbers {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }

    int maxCount = 0;
    for (int i = 0; i < n; i++) {

      int num1 = a[i];

      int count = 0;
      int contender1 = num1 - 1;
      int contender2 = num1 + 1;
      for (int j = 0; j < n; j++) {

        int num2 = a[j];
        if (num2 == contender1 || num2 == num1) {
          if (i == j)
            continue;

          if (Math.abs(num1 - num2) == 1 || Math.abs(num1 - num2) == 0)
            count++;
        }

      }

      if (count > maxCount)
        maxCount = count;

      count = 0;
      for (int j = 0; j < n; j++) {

        int num2 = a[j];
        if (num2 == contender2 || num2 == num1) {
          if (i == j)
            continue;

          if (Math.abs(num1 - num2) == 1 || Math.abs(num1 - num2) == 0)
            count++;
        }

      }
      if (count > maxCount)
        maxCount = count;

    }

    System.out.println(maxCount + 1);
  }
}

