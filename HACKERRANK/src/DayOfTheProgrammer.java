import java.util.*;

public class DayOfTheProgrammer {

  private static String solve(int year) {
    // Complete this function

    return (256 - (5 * 31 + 2 * 30 + (((year < 1918 && year % 4 == 0) ||
        (year > 1918 && (year % 400 == 0 ||
            (year % 4 == 0 && year % 100 != 0)))) ? 29 : (year == 1918 ? 15 : 28)))) + ".09." + year;

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int year = in.nextInt();
    String result = solve(year);
    System.out.println(result);
  }
}

