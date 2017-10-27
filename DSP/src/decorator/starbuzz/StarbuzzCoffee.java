package decorator.starbuzz;

import decorator.starbuzz.coffees.Beverage;
import decorator.starbuzz.coffees.DarkRoast;
import decorator.starbuzz.coffees.Espresso;
import decorator.starbuzz.coffees.HouseBlend;
import decorator.starbuzz.condiments.Mocha;
import decorator.starbuzz.condiments.Soy;
import decorator.starbuzz.condiments.Whip;

/**
 * @author nikoo28 on 10/26/17
 */
public class StarbuzzCoffee {

  public static void main(String args[]) {

    Beverage beverage = new Espresso();
    System.out.println(beverage.getDescription() + " $" + beverage.cost());

    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);
    System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    Beverage beverage3 = new HouseBlend();
    beverage3 = new Soy(beverage3);
    beverage3 = new Mocha(beverage3);
    beverage3 = new Whip(beverage3);
    System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
  }

}
