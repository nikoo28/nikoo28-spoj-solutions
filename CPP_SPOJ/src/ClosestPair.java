import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by nikoo28 on 9/26/16.
 */
class Main {

  public static void main(String[] args) {

    FasterScanner mFScanner = new FasterScanner();
    PrintWriter mOut = new PrintWriter(System.out);

    List<Point> points = new ArrayList<>();

    int numberOfPoints;
    numberOfPoints = mFScanner.nextInt();

    int n = numberOfPoints;

    while (n != 0) {

      points.add(new Point(mFScanner.nextInt(), mFScanner.nextInt()));
      n--;
    }

    Pair dqClosestPair = divideAndConquer(points);

    mOut.println((double) Math.round(dqClosestPair.distance * 1000000d) / 1000000d);
    mOut.flush();
    mOut.close();
  }


  public static class Point {

    public final double x;
    public final double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }

  public static class Pair {
    public Point point1 = null;
    public Point point2 = null;
    public double distance = 0.0;

    public Pair() {
    }

    public Pair(Point point1, Point point2) {
      this.point1 = point1;
      this.point2 = point2;
      calcDistance();
    }

    public void update(Point point1, Point point2, double distance) {
      this.point1 = point1;
      this.point2 = point2;
      this.distance = distance;
    }

    public void calcDistance() {
      this.distance = distance(point1, point2);
    }

    public String toString() {
      return point1 + "-" + point2 + " : " + distance;
    }
  }

  private static double distance(Point p1, Point p2) {
    double xdist = p2.x - p1.x;
    double ydist = p2.y - p1.y;
    return Math.hypot(xdist, ydist);
  }

  private static Pair bruteForce(List<? extends Point> points) {
    int numPoints = points.size();
    if (numPoints < 2)
      return null;
    Pair pair = new Pair(points.get(0), points.get(1));
    if (numPoints > 2) {
      for (int i = 0; i < numPoints - 1; i++) {
        Point point1 = points.get(i);
        for (int j = i + 1; j < numPoints; j++) {
          Point point2 = points.get(j);
          double distance = distance(point1, point2);
          if (distance < pair.distance)
            pair.update(point1, point2, distance);
        }
      }
    }
    return pair;
  }

  private static void sortByX(List<? extends Point> points) {
    Collections.sort(points, new Comparator<Point>() {
          public int compare(Point point1, Point point2) {
            if (point1.x < point2.x)
              return -1;
            if (point1.x > point2.x)
              return 1;
            return 0;
          }
        }
    );
  }

  private static void sortByY(List<? extends Point> points) {
    Collections.sort(points, new Comparator<Point>() {
          public int compare(Point point1, Point point2) {
            if (point1.y < point2.y)
              return -1;
            if (point1.y > point2.y)
              return 1;
            return 0;
          }
        }
    );
  }

  private static Pair divideAndConquer(List<? extends Point> points) {
    List<Point> pointsSortedByX = new ArrayList<>(points);
    sortByX(pointsSortedByX);
    List<Point> pointsSortedByY = new ArrayList<>(points);
    sortByY(pointsSortedByY);
    return divideAndConquer(pointsSortedByX, pointsSortedByY);
  }

  private static Pair divideAndConquer(List<? extends Point> pointsSortedByX, List<? extends Point> pointsSortedByY) {
    int numPoints = pointsSortedByX.size();
    if (numPoints <= 3)
      return bruteForce(pointsSortedByX);

    int dividingIndex = numPoints >>> 1;
    List<? extends Point> leftOfCenter = pointsSortedByX.subList(0, dividingIndex);
    List<? extends Point> rightOfCenter = pointsSortedByX.subList(dividingIndex, numPoints);

    List<Point> tempList = new ArrayList<>(leftOfCenter);
    sortByY(tempList);
    Pair closestPair = divideAndConquer(leftOfCenter, tempList);

    tempList.clear();
    tempList.addAll(rightOfCenter);
    sortByY(tempList);
    Pair closestPairRight = divideAndConquer(rightOfCenter, tempList);

    if (closestPairRight.distance < closestPair.distance)
      closestPair = closestPairRight;

    tempList.clear();
    double shortestDistance = closestPair.distance;
    double centerX = rightOfCenter.get(0).x;
    for (Point point : pointsSortedByY)
      if (Math.abs(centerX - point.x) < shortestDistance)
        tempList.add(point);

    for (int i = 0; i < tempList.size() - 1; i++) {
      Point point1 = tempList.get(i);
      for (int j = i + 1; j < tempList.size(); j++) {
        Point point2 = tempList.get(j);
        if ((point2.y - point1.y) >= shortestDistance)
          break;
        double distance = distance(point1, point2);
        if (distance < closestPair.distance) {
          closestPair.update(point1, point2, distance);
          shortestDistance = distance;
        }
      }
    }
    return closestPair;
  }

}

class FasterScanner {
  private final InputStream mIs;
  private final byte[] buf = new byte[1024];
  private int curChar;
  private int numChars;

  public FasterScanner() {
    this(System.in);
  }

  private FasterScanner(InputStream is) {
    mIs = is;
  }

  private int read() {
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

  private boolean isSpaceChar(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  private boolean isEndOfLine(int c) {
    return c == '\n' || c == '\r' || c == -1;
  }

}
