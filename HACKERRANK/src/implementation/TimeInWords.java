package implementation;

import java.util.Scanner;

/**
 * Created by nikoo28 on 6/28/17.
 */
public class TimeInWords {

  static void toWords(int h, int m) {

    String[] numbers = {"", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};

    String currentTime = "";

    // **** at hour ****

    if (m == 0) {
      currentTime = numbers[h] + " o' clock";
    }

    // **** at quarter past ****

    else if (m == 15) {
      currentTime = "quarter past " + numbers[h];
    }

    // **** at half hour ****

    else if (m == 30) {
      currentTime = "half past " + numbers[h];
    }

    // **** at quarter before ****

    else if (m == 45) {
      currentTime = "quarter to " + numbers[h + 1];
    }

    // **** before half hour ****

    else if (m < 30) {
      currentTime = numbers[m] + " minute" + (m <= 1 ? "" : "s") + " past " + numbers[h];
    }

    // **** past half hour ****

    else {
      currentTime = numbers[60 - m] + " minute" + ((60 - m) <= 1 ? "" : "s") + " to " + numbers[h + 1];
    }

    // **** display the current time ****

    System.out.println(currentTime);
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int h = scanner.nextInt();
    int m = scanner.nextInt();

    toWords(h, m);

  }

}
