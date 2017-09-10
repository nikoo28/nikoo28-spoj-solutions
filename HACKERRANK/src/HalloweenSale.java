import java.util.Scanner;

public class HalloweenSale {

  static int howManyGames(int gamePrice, int deduction, int constantAmount, int money) {
    // Return the number of games you can buy

    int games = 0;
    while (money >= gamePrice) {
      money -= gamePrice;
      games++;
      gamePrice = Math.max(gamePrice - deduction, constantAmount);
    }
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
