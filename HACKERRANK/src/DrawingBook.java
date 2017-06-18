import java.util.*;

public class DrawingBook {

  private static int solve(int n, int p) {
    // Complete this function
    int min = (n / 2) - (p / 2);
    if (min > p / 2)
      min = p / 2;
    return min;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int p = in.nextInt();
    int result = solve(n, p);
    System.out.println(result);
  }
}

