import java.util.*;

/**
 * Created by nikoo28 on 12/18/17 11:01 PM
 */

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {

    if (strs == null || strs.length == 0)
      return new ArrayList<List<String>>();

    Map<String, List<String>> stringAnagramsMap = new HashMap<>();
    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = String.valueOf(arr);

      if (stringAnagramsMap.containsKey(key)) {
        stringAnagramsMap.get(key).add(s);
        continue;
      }

      stringAnagramsMap.put(key, new ArrayList<String>());
    }

    List<List<String>> resultList = new ArrayList<>();
    for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
      resultList.add(stringAnagrams.getValue());
    }
    return resultList;
  }

}
