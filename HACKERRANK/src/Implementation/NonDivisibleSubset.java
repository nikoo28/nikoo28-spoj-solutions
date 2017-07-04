package Implementation;

import java.util.*;

/**
 * Created by nikoo28 on 6/18/17.
 */
public class NonDivisibleSubset {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();

    List<Integer> S = new ArrayList<>(n);
    Map<Integer, Integer> numberFrequencyCount = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int num = scanner.nextInt();
      int rem = num % k;
      if (numberFrequencyCount.containsKey(rem)) {
        int count = numberFrequencyCount.get(rem);
        count++;
        numberFrequencyCount.put(rem, count);
      } else
        numberFrequencyCount.put(rem, 1);
    }

    if (k == 0 || k == 1) {
      System.out.println("1");
      System.exit(0);
    }

    int count = 0;
    Set<Integer> numbersParsed = new HashSet<>();
    for (Map.Entry<Integer, Integer> integerIntegerEntry : numberFrequencyCount.entrySet()) {

      if (numbersParsed.contains(integerIntegerEntry.getKey()))
        continue;

      int num1 = integerIntegerEntry.getKey();
      if (num1 == 0) {
        count++;
        continue;
      }

      int freq1 = integerIntegerEntry.getValue();
      if (k % 2 == 0 && num1 == k / 2) {
        count++;
        continue;
      }

      int compliment = k - num1;
      if (numberFrequencyCount.containsKey(compliment)) {
        int freq2 = numberFrequencyCount.get(compliment);
        if (freq2 > freq1)
          count += freq2;
        else
          count += freq1;

        numbersParsed.add(num1);
        numbersParsed.add(compliment);
      } else {
        count += freq1;
        numbersParsed.add(num1);
      }

    }


    System.out.println(count);


//    while (true) {
//
//      List<Integer> votes = new ArrayList<>(S.size());
//      for (int i = 0; i < S.size(); i++) {
//        votes.add(0);
//      }
//      boolean flag = true;
//      for (int i = 0; i < S.size(); i++) {
//        for (int j = 0; j < S.size(); j++) {
//          if (i == j)
//            continue;
//          if (votes.get(i) > 1 ||
//              votes.get(j) > 1)
//            continue;
//          if ((S.get(i) + S.get(j)) % k == 0) {
//            flag = false;
//            votes.set(i, votes.get(i) + 1);
//            votes.set(j, votes.get(j) + 1);
//          }
//        }
//      }
//
//      if (flag)
//        break;
//
//      int max = Integer.MIN_VALUE;
//      int numToRemove = 0;
//      for (int i = 0; i < votes.size(); i++) {
//        if (max < votes.get(i)) {
//          max = votes.get(i);
//          numToRemove = S.get(i);
//        }
//      }
//
//      S.remove((Integer) numToRemove);
//    }
//
//    System.out.println(S.size());

  }

}
