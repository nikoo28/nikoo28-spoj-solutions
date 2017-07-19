package Strings;

import java.util.Scanner;

/**
 * Created by nikoo28 on 7/18/17.
 */
public class MakingAnagrams {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    int cArr[] = new int[26];
    int cArr1[] = new int[26];

    for (int i = 0; i < s1.length(); i++)
      cArr[s1.charAt(i) - 'a']++;
    for (int i = 0; i < s2.length(); i++)
      cArr1[s2.charAt(i) - 'a']++;

    int count = 0;
    for (int i = 0; i < 26; i++)
      count += Math.abs(cArr[i] - cArr1[i]);

    System.out.println(count);
  }

}
