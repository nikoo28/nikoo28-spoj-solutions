package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikoo28 on 4/13/19 8:48 PM
 */

public class CamelMatch {

  public static List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> result = new ArrayList<>();

    char[] patternArr = pattern.toCharArray();

    // Start for each string in the query array
    for (String query : queries) {

      // Match it with the pattern
      boolean isMatch = match(query.toCharArray(), patternArr);

      // Pass the result
      result.add(isMatch);
    }

    return result;
  }

  private static boolean match(char[] queryArr, char[] patternArr) {

    int j = 0; // pattern pointer

    // i is the query pointer
    for (int i = 0; i < queryArr.length; i++) {

      // If char[i] == char[j], we need to advance both the pointers.
      if (j < patternArr.length && queryArr[i] == patternArr[j]) {
        j++;
      } else if (queryArr[i] >= 'A' && queryArr[i] <= 'Z') {

        // If the query character is a uppercase letter, then return false.
        return false;
      }
    }

    // Just verify that pattern pointer reaches its length limit
    return j == patternArr.length;
  }

  public static void main(String[] args) throws java.lang.Exception {
    String[] queries = {"StudyAlgorithms", "StudyAlgorithmsTest", "StanAlluring", "SimulationAlteration", "StopStayAlive"};
    String pattern = "StAl";

    List<Boolean> results = camelMatch(queries, pattern);
    for (Boolean result : results) {
      System.out.println(result);
    }
  }
}
