package decorator.starbuzz.coffees;

/**
 * @author nikoo28 on 10/26/17
 */
public class Decaf extends Beverage {

  public Decaf() {
    description = "Decaf";
  }

  @Override
  public double cost() {
    return 1.05;
  }
}
