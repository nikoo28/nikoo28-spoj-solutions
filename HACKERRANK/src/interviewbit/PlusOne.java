package interviewbit;

/**
 * @author nikoo28 on 11/14/17
 */
public class PlusOne {

  public static int[] plusOne(int[] A) {

    int carry = 0;
    int len = A.length;

    boolean all9 = false;

    while (true) {

      if (len == 0) {
        all9 = true;
        break;
      }

      if (A[len - 1] == 9) {
        A[len - 1] = 0;
        carry = 1;
      } else {
        A[len - 1] = A[len - 1] + 1;
        carry = 0;
      }

      len--;
      if (carry == 0)
        break;
    }

    if (all9) {
      int[] result = new int[A.length + 1];
      result[0] = 1;
      return result;
    }

    int zeroes = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0)
        zeroes++;
      else
        break;
    }

    int[] result = new int[A.length - zeroes];
    for (int i = zeroes; i < A.length; i++) {
      result[i - zeroes] = A[i];
    }
    return result;

  }

  public static void main(String[] args) {

    int[] A = {0, 0, 0, 3, 7, 6, 4, 0, 5, 5, 5};

    for (int i : plusOne(A)) {
      System.out.println(i);
    }

  }

}
