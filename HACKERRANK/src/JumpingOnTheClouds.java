import java.util.*;

public class JumpingOnTheClouds {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int c[] = new int[n];
    for (int c_i = 0; c_i < n; c_i++) {
      c[c_i] = in.nextInt();
    }

    int E = 100;
    int nextCloud = 0;
    while (true) {
      E--;
      nextCloud = (nextCloud + k) % n;

      if (c[nextCloud] == 1)
        E -= 2;

      if (nextCloud == 0)
        break;
    }

    System.out.println(E);
  }
}

