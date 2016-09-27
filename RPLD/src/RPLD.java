import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by nikoo28 on 16-07-2016.
 */
public class RPLD {

    public static PrintWriter mOut;
    public static FasterScanner mFScanner;

    public static void main(String[] args) {

        mFScanner = new FasterScanner();
        mOut = new PrintWriter(System.out);

        int T = mFScanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N, R;
            N = mFScanner.nextInt();
            R = mFScanner.nextInt();

            boolean isPossible = true;
            Set<String> dataSet = new HashSet<>();
            for (int j = 0; j < R; j++) {
                int studentId = mFScanner.nextInt();
                int subjectId = mFScanner.nextInt();
                String entry = studentId + " " + subjectId;
                if (dataSet.contains(entry))
                    isPossible = false;
                else
                    dataSet.add(entry);
            }

            if (isPossible)
                mOut.println("Scenario #" + (i + 1) + ": possible");
            else
                mOut.println("Scenario #" + (i + 1) + ": impossible");
        }

        mOut.flush();
        mOut.close();
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
