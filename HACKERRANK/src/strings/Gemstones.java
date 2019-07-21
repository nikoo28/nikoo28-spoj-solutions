package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by nikhil.lohia on 07/17/2017.
 */
class Gemstones {

  static int gemstones(String[] arr) {
    // Complete this function

    String str = arr[0];
    Set<String> characterSet = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      characterSet.add(String.valueOf(str.charAt(i)));
    }

    for (int i = 1; i < arr.length; i++) {

      String x = arr[i];
      Set<String> toRemove = new HashSet<>();
      for (String character : characterSet) {
        if (x.contains(character))
          continue;
        else
          toRemove.add(character);
      }

      characterSet.removeAll(toRemove);
      if (characterSet.isEmpty())
        break;
    }

    return characterSet.size();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] arr = new String[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.next();
    }
    int result = gemstones(arr);
    System.out.println(result);
  }
}

