import java.util.Scanner;

// My submission.
// Fails a test case

public class HalloweenSale {

  static int howManyGames(int gamePrice, int deduction, int constantAmount, int money) {
    // Return the number of games you can buy

    int games = 0;

    if (gamePrice > money)
      return 0;

    if (gamePrice == money)
      return 1;

    money -= gamePrice;
    games++;
    while (gamePrice > constantAmount && money > gamePrice) {
      gamePrice -= deduction;
      if (gamePrice < constantAmount || gamePrice < 0)
        break;
      money -= gamePrice;
      if (money > 0)
        games++;
    }

    if (money < constantAmount)
      return games;

    int remainingGames = money / constantAmount;
    games += remainingGames;

    return games;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int p = in.nextInt();
    int d = in.nextInt();
    int m = in.nextInt();
    int s = in.nextInt();
    int answer = howManyGames(p, d, m, s);
    System.out.println(answer);
    in.close();
  }

}
