// code obtained from studyalgorithms.com

public class SieveOfEratosthenes {

  static void sieveOfEratosthenes(int n) {

    // Create a boolean array "prime[0..n]" and initialize
    // all entries it as true. A value in isPrime[i] will
    // finally be false if i is Not a prime, else true.

    boolean isPrime[] = new boolean[n + 1];
    for (int i = 0; i < n; i++)
      isPrime[i] = true;

    for (int number = 2; number * number <= n; number++) {

      // If prime[p] is true, then it is a prime number
      // we need to ignore it and now mark all it's multiples
      if (isPrime[number] == true) {

        // Update all multiples of p
        for (int i = number * 2; i <= n; i += number)
          isPrime[i] = false;
      }
    }

    // Print all prime numbers
    // At this point only the numbers which are set as true are prime.
    for (int i = 2; i <= n; i++) {
      if (isPrime[i] == true)
        System.out.print(i + " ");
    }
  }

  public static void main(String[] args) {

    sieveOfEratosthenes(30);
  }
}