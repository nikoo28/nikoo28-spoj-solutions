import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by nikhil.lohia on 6/28/2017.
 */
public class BeautifulTriplets {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int d = scanner.nextInt();
    int[] arr = new int[n];
    int count = 0;
    Set<Integer> numberSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
      numberSet.add(arr[i]);
    }

    for (int i = 0; i < n; i++) {
      if (numberSet.contains(arr[i] + d) && numberSet.contains(arr[i] + (2 *d)))
        count++;
    }

    System.out.println(count);

  }

}

