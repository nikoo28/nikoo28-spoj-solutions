import java.util.HashSet;
import java.util.Set;

/**
 * Created by nikoo28 on 12/18/17 9:29 PM
 */

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {

    int i = 0;
    int j = 0;
    Set<Character> charSet = new HashSet<>();

    int length = 0;

    while (j < s.length()) {
      if (!charSet.contains(s.charAt(j))) {
        charSet.add(s.charAt(j));
        j++;
        length = Math.max(length, charSet.size());
      } else
        charSet.remove(s.charAt(i++));
    }

    return length;
  }

}
