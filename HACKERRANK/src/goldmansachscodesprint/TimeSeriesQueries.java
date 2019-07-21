package goldmansachscodesprint;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TimeSeriesQueries {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    long[] t = new long[n];
    for (int t_i = 0; t_i < n; t_i++) {
      t[t_i] = in.nextLong();
    }
    long[] p = new long[n];
    for (int p_i = 0; p_i < n; p_i++) {
      p[p_i] = in.nextLong();
    }

    Map<Long, Long> timeValueMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      timeValueMap.put(t[i], p[i]);
    }

    for (int a0 = 0; a0 < q; a0++) {

      long result = -1;
      int _type = in.nextInt();
      int v = in.nextInt();

      if (_type == 1) {

        for (Map.Entry<Long, Long> longLongEntry : timeValueMap.entrySet()) {
          long time = longLongEntry.getKey();
          long value = longLongEntry.getValue();
          if (value >= v) {
            result = time;
            break;
          }
        }
        System.out.println(result);
      } else {
        long max = Long.MIN_VALUE;
        boolean flag = false;
        for (Map.Entry<Long, Long> longLongEntry : timeValueMap.entrySet()) {
          long time = longLongEntry.getKey();
          long value = longLongEntry.getValue();
          if (time < v)
            continue;

          flag = true;
          if (max < value)
            max = value;
        }
        if (flag)
          System.out.println(max);
        else
          System.out.println(result);
      }
    }
    in.close();
  }
}

