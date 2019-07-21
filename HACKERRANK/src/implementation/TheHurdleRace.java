package implementation;

import java.util.Scanner;

public class TheHurdleRace {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] height = new int[n];
    for(int height_i=0; height_i < n; height_i++){
      height[height_i] = in.nextInt();
    }
    // your code goes here

    int maxHeight = height[0];
    for (int i : height) {
      if (i > maxHeight)
        maxHeight = i;
    }

    if (k >= maxHeight)
      System.out.println("0");
    else
      System.out.println(maxHeight - k);


  }
}

