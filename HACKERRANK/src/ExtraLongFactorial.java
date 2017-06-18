import java.util.*;
import java.math.BigInteger;

public class ExtraLongFactorial {

  private static BigInteger factorial(int N) {
    // Initialize result
    BigInteger f = new BigInteger("1");

    // Multiply f with 2, 3, ...N
    for (int i = 2; i <= N; i++)
      f = f.multiply(BigInteger.valueOf(i));

    return f;
  }

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner n = new Scanner(System.in);
    System.out.println(factorial(n.nextInt()));
  }
}