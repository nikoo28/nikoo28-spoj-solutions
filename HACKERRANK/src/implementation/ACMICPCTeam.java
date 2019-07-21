package implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/20/17.
 */

public class ACMICPCTeam {

  public static void main(String[] args) {

    //Get input
    Scanner s = new Scanner(System.in);
    String[] firstLine = s.nextLine().split(" ");
    int people = Integer.parseInt(firstLine[0]);
    int topics = Integer.parseInt(firstLine[1]);
    int[][] a = new int[people][topics];
    for (int i = 0; i < people; i++) {
      int[] currentArray = new int[topics];
      String currentTopicList = s.nextLine();
      for (int j = 0; j < currentTopicList.length(); j++) {
        currentArray[j] = Integer.parseInt(currentTopicList.charAt(j) + "");
      }
      a[i] = currentArray;
    }

    //Solve
    int highest = -1;
    int bestTeams = 0;

    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        int knowledge = 0;
        for (int x = 0; x < topics; x++) {
          knowledge += (a[i][x] == 1 || a[j][x] == 1) ? 1 : 0;
        }
        if (knowledge > highest) {
          highest = knowledge;
          bestTeams = 1;
        } else if (knowledge == highest) {
          bestTeams += 1;
        }
      }
    }
    System.out.println(highest);
    System.out.println(bestTeams);
  }
}