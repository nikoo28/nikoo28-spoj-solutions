import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * Created by nikoo28 on 9/26/16.
 */
public class CPP {

  public static PrintWriter mOut;
  public static FasterScanner mFScanner;

  public static void main(String[] args) {

    mFScanner = new FasterScanner();
    mOut = new PrintWriter(System.out);

    int numberOfPoints;
    numberOfPoints = mFScanner.nextInt();

    int n = numberOfPoints;

    int[][] points = new int[numberOfPoints][2];
    int i = 0;

    while (n != 0) {

      points[i][0] = mFScanner.nextInt();
      points[i][1] = mFScanner.nextInt();
      i++;
      n--;
    }

    // Sort the co-ordinates based on x
    quickSortOnX(points, 0, numberOfPoints - 1);

    // Print the points
//    for (int[] point : points) {
//      for (int i1 : point) {
//        System.out.print(i1 + ",");
//      }
//      System.out.println();
//    }

    // Brute force method
//    for (int j = 0; j < i; j++) {
//      for (int k = 0; k < i; k++) {
//        if (j == k)
//          continue;
//        double distance = findDistance(points[j][0], points[k][0], points[j][1], points[k][1]);
//
//        if (distance < minDistance)
//          minDistance = distance;
//      }
//    }

    double minDistance = getMinDistance(points, 0, numberOfPoints-1);

    mOut.println((double) Math.round(minDistance * 1000000d) / 1000000d);
    mOut.flush();
    mOut.close();
  }

  public static void quickSortOnX(int[][] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;

    if (low >= high)
      return;

    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle][0];

    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i][0] < pivot) {
        i++;
      }

      while (arr[j][0] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;
        temp = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = temp;
        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j)
      quickSortOnX(arr, low, j);

    if (high > i)
      quickSortOnX(arr, i, high);
  }

  public static void quickSortOnY(int[][] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;

    if (low >= high)
      return;

    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle][1];

    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i][1] < pivot) {
        i++;
      }

      while (arr[j][1] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;
        temp = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = temp;
        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j)
      quickSortOnY(arr, low, j);

    if (high > i)
      quickSortOnY(arr, i, high);
  }

  private static double getMinDistance(int[][] points, int low, int high) {

    if (points.length < 2)
      return Double.MAX_VALUE;

    if (points.length == 2)
      return findDistance(points[0][0], points[1][0], points[0][1], points[1][1]);

    int middle = low + (high - low) / 2;
    double minLeft = getMinDistance(points, 0, middle-1);
    double minRight = getMinDistance(points, middle, high);

    double min = minLeft > minRight ? minRight : minLeft;

    int middleValueOfXCordinate = points[middle][0];
    double leftThreshold = middleValueOfXCordinate - min;
    double rightThreshold = middleValueOfXCordinate + min;



    return 0;
  }

  /**
   * Method to find the euclidean distance b/w 2 points
   *
   * @return a double value if the distance
   * @params co-ordinates of 2 points
   */
  private static double findDistance(int x1, int x2, int y1, int y2) {

    double dx = x2 - x1;
    double dy = y2 - y1;
    dx = Math.pow(dx, 2.0);
    dy = Math.pow(dy, 2.0);
    double sum = dx + dy;
    return Math.sqrt(sum);
  }

}

class FasterScanner {
  private InputStream mIs;
  private byte[] buf = new byte[1024];
  private int curChar;
  private int numChars;

  public FasterScanner() {
    this(System.in);
  }

  public FasterScanner(InputStream is) {
    mIs = is;
  }

  public int read() {
    if (numChars == -1)
      throw new InputMismatchException();
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = mIs.read(buf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (numChars <= 0)
        return -1;
    }
    return buf[curChar++];
  }

  public String nextLine() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
      c = read();
    } while (!isEndOfLine(c));
    return res.toString();
  }

  public String nextString() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    StringBuilder res = new StringBuilder();
    do {
      res.appendCodePoint(c);
      c = read();
    } while (!isSpaceChar(c));
    return res.toString();
  }

  public long nextLong() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    long res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public int nextInt() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    int res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public boolean isSpaceChar(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  public boolean isEndOfLine(int c) {
    return c == '\n' || c == '\r' || c == -1;
  }

}
