package GoldmanSachsCodeSprint;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuyMaximumStocks {

  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
    return map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
        ));
  }

  static long buyMaximumProducts(int n, long k, int[] a) {
    // Complete this function
    Map<Integer, Integer> dayStocksMap = new HashMap<>();
    int day = 1;
    for (int i : a) {
      dayStocksMap.put(day, i);
      day++;
    }
    Map<Integer, Integer> sortedByStockValueMap = sortByValue(dayStocksMap);

    long stocksPurchased = 0;
    long remainingValue = k;

    for (Map.Entry<Integer, Integer> stockValueEntry : sortedByStockValueMap.entrySet()) {
      int stockValue = stockValueEntry.getValue();
      int maxPossibleStock = stockValueEntry.getKey();

      if (stockValue * maxPossibleStock < remainingValue) {
        stocksPurchased += maxPossibleStock;
        remainingValue -= (stockValue * maxPossibleStock);
        continue;
      }

      stocksPurchased += (remainingValue) / stockValue;
      break;
    }

    return stocksPurchased;

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    long k = in.nextLong();
    long result = buyMaximumProducts(n, k, arr);
    System.out.println(result);
    in.close();
  }

}
