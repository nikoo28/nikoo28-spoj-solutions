/**
 * @author nikoo28 on 9/16/17
 */
public class LongestUncommonSubsequence1 {

  public int findLUSlength(String a, String b) {

    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }

}
