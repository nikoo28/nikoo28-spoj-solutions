import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactorisation {

  /**
   * Created by nikhil.lohia on 08/07/2017.
   */

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long N = scanner.nextLong();
    Set<Long> primeFactors = new HashSet<>();

    while (N % 2 == 0) {
      N /= 2;
      primeFactors.add(2L);
    }

    for (long j = 3; j <= Math.sqrt(N); j += 2) {
      while (N % j == 0) {
        N /= j;
        primeFactors.add(j);
      }
    }

    if (N > 2)
      primeFactors.add(N);

    for (Long primeFactor : primeFactors) {
      System.out.print(primeFactor + " ");
    }

  }
}
