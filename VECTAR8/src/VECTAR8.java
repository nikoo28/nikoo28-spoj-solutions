import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * Created by nikoo28 on 16-07-2016.
 */
public class VECTAR8 {

  public static PrintWriter mOut;
  public static FasterScanner mFScanner;

  public static void main(String[] args) {

    mFScanner = new FasterScanner();
    mOut = new PrintWriter(System.out);

    int[] fearfulList = {2, 3, 5, 7, 13, 17, 23, 37, 43, 47, 53, 67, 73, 83, 97, 113, 137, 167, 173, 197, 223, 283, 313, 317, 337, 347, 353, 367, 373, 383, 397, 443, 467, 523, 547, 613, 617, 643, 647, 653, 673, 683, 743, 773, 797, 823, 853, 883, 937, 947, 953, 967, 983, 997, 1223, 1283, 1367, 1373, 1523, 1613, 1823, 1997, 2113, 2137, 2347, 2383, 2467, 2617, 2647, 2683, 2797, 2953, 3137, 3167, 3313, 3347, 3373, 3467, 3547, 3613, 3617, 3643, 3673, 3797, 3823, 3853, 3947, 3967, 4283, 4337, 4373, 4397, 4523, 4547, 4643, 4673, 4937, 4967, 5113, 5167, 5197, 5347, 5443, 5647, 5653, 5683, 5743, 5953, 6113, 6173, 6197, 6317, 6337, 6353, 6367, 6373, 6397, 6547, 6653, 6673, 6823, 6883, 6947, 6967, 6983, 6997, 7283, 7523, 7547, 7643, 7673, 7823, 7853, 7883, 7937, 8167, 8317, 8353, 8443, 8467, 8647, 9137, 9173, 9283, 9337, 9397, 9467, 9547, 9613, 9643, 9743, 9883, 9967, 12113, 12347, 12647, 12953, 13313, 13613, 13967, 15443, 15647, 15683, 16547, 16673, 16823, 16883, 18353, 18443, 21283, 21523, 21613, 21997, 23167, 24337, 24373, 24547, 24967, 26113, 26317, 26947, 27283, 27673, 27823, 27883, 29137, 29173, 31223, 32467, 32647, 32797, 33347, 33547, 33613, 33617, 33797, 33967, 34283, 34337, 34673, 36353, 36373, 36653, 36947, 36997, 37547, 37643, 37853, 38167, 38317, 39397, 39883, 42467, 42683, 42797, 42953, 43313, 43613, 43853, 45197, 45953, 46337, 46997, 48353, 48647, 49547, 49613, 51283, 51613, 53617, 54547, 54673, 56113, 56197, 56983, 57283, 57853, 59467, 59743, 61223, 61283, 61613, 62137, 62347, 62383, 62467, 62617, 62683, 63313, 63347, 63467, 63617, 63823, 63853, 64283, 64373, 64937, 65167, 65647, 66173, 66337, 66373, 66653, 66883, 66947, 67523, 67547, 67853, 67883, 68443, 69337, 69467, 72383, 72467, 72617, 72647, 72797, 72953, 73547, 73613, 73643, 73673, 73823, 75167, 75347, 75653, 75683, 75743, 76367, 76673, 76883, 78167, 78317, 78467, 79283, 79337, 79397, 79613, 79967, 81223, 81283, 81373, 83137, 83617, 84523, 84673, 84967, 86113, 86197, 86353, 87523, 87547, 87643, 87853, 89137, 91283, 91367, 91373, 91823, 91997, 92347, 92383, 92467, 92647, 92683, 93967, 94397, 94547, 95443, 96337, 96353, 96823, 96997, 97283, 97523, 97547, 97673, 97883, 98317, 98443, 98467, 99137, 99173, 99397, 99643, 121283, 121523, 121997, 124337, 126317, 132647, 133967, 136373, 139397, 139883, 162683, 163853, 181283, 184523, 184967, 186113, 187547, 192347, 192383, 195443, 196337, 213613, 215443, 231223, 233347, 233617, 234673, 236653, 236947, 237547, 242467, 242797, 243613, 261223, 264283, 266947, 267523, 272383, 273613, 273643, 275167, 276673, 276883, 279337, 279397, 279613, 279967, 291367, 291373, 291997, 294397, 296353, 297523, 299137, 313613, 318443, 326113, 326947, 327673, 327823, 332467, 336353, 336373, 336653, 336997, 337853, 338167, 342467, 343313, 345953, 346337, 348353, 356113, 356197, 357283, 361223, 362137, 362347, 363313, 364373, 364937, 366173, 367547, 367853, 367883, 368443, 372797, 373613, 373823, 375743, 378167, 378317, 378467, 379283, 379397, 381223, 381373, 384673, 387853, 391283, 391367, 391373, 391823, 392347, 392383, 392467, 392647, 395443, 396353, 396997, 397283, 397547, 397673, 398467, 399137, 399173, 399643, 421997, 424547, 424967, 427283, 427883, 429137, 432797, 433967, 439883, 453617, 454547, 454673, 459467, 462467, 463313, 463823, 465167, 466373, 481373, 492467, 492647, 493967, 496997, 498467, 499397, 513313, 516673, 516883, 534283, 536353, 536947, 537547, 537853, 542467, 542683, 542797, 543313, 543853, 549547, 563467, 564373, 564937, 566173, 566653, 566947, 567883, 573673, 576883, 578167, 578317, 578467, 579283, 579613, 579967, 594397, 597523, 597673, 612113, 613967, 616547, 616673, 621997, 626113, 626317, 626947, 627673, 629137, 631223, 632647, 633613, 633797, 633967, 636353, 636653, 636947, 636997, 638317, 642683, 642797, 642953, 649613, 653617, 656113, 659467, 661613, 662617, 663823, 663853, 666173, 667547, 667883, 672953, 673613, 673643, 675347, 675743, 676883, 686197, 686353, 687523, 691997, 692347, 692467, 692647, 693967, 696823, 697523, 697673, 721283, 721613, 721997, 723167, 724547, 724967, 727673, 727823, 729173, 732467, 738317, 739397, 751613, 753617, 759467, 763823, 766373, 781283, 783137, 786197, 787547, 789137, 792383, 792647, 793967, 796337, 798443, 812347, 813613, 816547, 816883, 818353, 833347, 833617, 834283, 837853, 843613, 845197, 846997, 848647, 861613, 866653, 867547, 869467, 872383, 872647, 872953, 873643, 875683, 878167, 878467, 879283, 891823, 891997, 894547, 896353, 912647, 912953, 915683, 918353, 918443, 921523, 924337, 924967, 926113, 932647, 933613, 933797, 933967, 934673, 946997, 951283, 956113, 959467, 961283, 961613, 962617, 962683, 964283, 964373, 965647, 966337, 966373, 966653, 966883, 969467, 973547, 973823, 975743, 976883, 979283, 979337, 981283, 981373, 983617, 986113, 986197, 987523, 995443, 997547, 998443, 1111111};
    int[] result = new int[1000003];

    int fearfulListIndex = 0;
    int fearfulCount = 0;
    for (int i = 0; i < 1000003; i++) {
      if (i > fearfulList[fearfulListIndex]) {
        result[i] = fearfulCount++;
        fearfulListIndex++;
      } else
        result[i] = fearfulCount;
    }

    int T = mFScanner.nextInt();
    for (int i = 0; i < T; i++) {
      int N = mFScanner.nextInt();
      mOut.println(result[N + 2]);
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
