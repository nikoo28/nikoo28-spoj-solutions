import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SaveThePrisoner {

  static int saveThePrisoner(int n, int m, int s){
    // Complete this function

    if (m > n)
      m = m % n;


    int poison = s + m - 1;
    if (poison == 0)
      return n;
    if (poison <= n)
      return poison;

    return poison - n;

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      int m = in.nextInt();
      int s = in.nextInt();
      int result = saveThePrisoner(n, m, s);
      System.out.println(result);
    }
  }
}

