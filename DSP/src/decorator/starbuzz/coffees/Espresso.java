package decorator.starbuzz.coffees;

/**
 * @author nikoo28 on 10/26/17
 */
public class Espresso extends Beverage {

  public Espresso() {
    description = "Espresso";
  }

  @Override
  public double cost() {
    return 1.99;
  }
}
