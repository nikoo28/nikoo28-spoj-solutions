import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * Created by nikoo28 on 16-07-2016.
 */
public class SHUBH1307 {

    static int[] stack;
    static int top;
    static int[] sums;
    static int counter;
    static int K;
    public static PrintWriter mOut;
    public static FasterScanner mFScanner;

    public static void main(String[] args) {

        mFScanner = new FasterScanner();
        mOut = new PrintWriter(System.out);

        int cases = mFScanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int N, M;
            N = mFScanner.nextInt();
            M = mFScanner.nextInt();
            K = mFScanner.nextInt();

            int[][] grid = new int[N][M];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    grid[j][k] = mFScanner.nextInt();
                }
            }

            counter = 0;
            sums = new int[10000000];
            stack = new int[N * M];
            top = 0;
            printAllPaths(grid, N, M);

            int result = -1;
            for (int j = 0; j < counter; j++) {
                if (sums[j] <= K && sums[j] > result)
                    result = sums[j];
            }
            mOut.println(result);
            System.gc();
        }
        mOut.flush();
        mOut.close();
    }

    private static void printAllPaths(int[][] matrix, int m, int n) {
        if (m == 0 || n == 0)
            return;

        stack[top++] = matrix[m - 1][n - 1];
        if (m == 1 && n == 1) {
            calculateSum();
        }

        printAllPaths(matrix, m - 1, n);
        printAllPaths(matrix, m, n - 1);
        printAllPaths(matrix, m - 1, n - 1);
        top--;
    }

    private static void calculateSum() {
        for (int i = top - 1; i > 0; i--) {
            sums[counter] += stack[i];
            if (sums[counter] > K)
                return;
        }
        sums[counter] += stack[0];
        counter++;
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
