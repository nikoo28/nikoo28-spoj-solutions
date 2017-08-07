import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenFibonacciNumbers {

  public static void main(String[] args) {

    List<Long> evenFibonacciList = new ArrayList<>();

    evenFibonacciList.add(0L);
    evenFibonacciList.add(2L);
    evenFibonacciList.add(8L);
    evenFibonacciList.add(34L);
    evenFibonacciList.add(144L);
    evenFibonacciList.add(610L);
    evenFibonacciList.add(2584L);
    evenFibonacciList.add(10946L);
    evenFibonacciList.add(46368L);
    evenFibonacciList.add(196418L);
    evenFibonacciList.add(832040L);
    evenFibonacciList.add(3524578L);
    evenFibonacciList.add(14930352L);
    evenFibonacciList.add(63245986L);
    evenFibonacciList.add(267914296L);
    evenFibonacciList.add(1134903170L);
    evenFibonacciList.add(4807526976L);
    evenFibonacciList.add(20365011074L);
    evenFibonacciList.add(86267571272L);
    evenFibonacciList.add(365435296162L);
    evenFibonacciList.add(1548008755920L);
    evenFibonacciList.add(6557470319842L);
    evenFibonacciList.add(27777890035288L);
    evenFibonacciList.add(117669030460994L);
    evenFibonacciList.add(498454011879264L);
    evenFibonacciList.add(2111485077978050L);
    evenFibonacciList.add(8944394323791464L);
    evenFibonacciList.add(37889062373143906L);

    Scanner scanner = new Scanner(System.in);
    int cases = scanner.nextInt();
    for (int i = 0; i < cases; i++) {

      int N = scanner.nextInt();

      long sum = 0;
      for (Long aLong : evenFibonacciList) {
        if (N > aLong)
          sum += aLong;
        else
          break;
      }

      System.out.println(sum);
    }

    scanner.close();
  }
}
