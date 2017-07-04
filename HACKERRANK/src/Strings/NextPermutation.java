package Strings;

/**
 * Created by nikoo28 on 7/4/17.
 */
public class NextPermutation {

  public static void nextPermutation(int[] num) {
    int n = num.length;
    if (n < 2)
      return;
    int index = n - 1;
    while (index > 0) {
      if (num[index - 1] < num[index])
        break;
      index--;
    }
    if (index == 0) {
      reverseSort(num, 0, n - 1);
      return;
    } else {
      int val = num[index - 1];
      int j = n - 1;
      while (j >= index) {
        if (num[j] > val)
          break;
        j--;
      }
      swap(num, j, index - 1);
      reverseSort(num, index, n - 1);
      return;
    }
  }

  public static void swap(int[] num, int i, int j) {
    int temp = 0;
    temp = num[i];
    num[i] = num[j];
    num[j] = temp;
  }

  public static void reverseSort(int[] num, int start, int end) {
    if (start > end)
      return;
    for (int i = start; i <= (end + start) / 2; i++)
      swap(num, i, start + end - i);
  }

  public static void main(String[] args) {
    String s = "abc";
    int[] x = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      x[i] = s.charAt(i);
    }
    nextPermutation(x);

    for (int i : x) {
      System.out.print((char) i);
    }
  }
}
