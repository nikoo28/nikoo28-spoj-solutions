import java.util.*;

/**
 * Created by nikoo28 on 6/18/17.
 */
public class CutTheSticks {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    List<Integer> sticks = new ArrayList<>(N);
    for (int i = 0; i < N; i++) {
      int num = scanner.nextInt();
      sticks.add(num);
    }

    while (sticks.size() != 0) {
      System.out.println(sticks.size());

      int min = Integer.MAX_VALUE;
      for (Integer stick : sticks) {
        if (stick < min)
          min = stick;
      }

      for (int i = 0; i < sticks.size(); i++) {
        if (sticks.get(i) == min)
          sticks.set(i, 0);
        else
          sticks.set(i, sticks.get(i) - min);
      }
      sticks.removeAll(Collections.singletonList(0));
    }

  }

}
