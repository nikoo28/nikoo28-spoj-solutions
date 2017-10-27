package decorator.starbuzz.coffees;

/**
 * @author nikoo28 on 10/26/17
 */
public class DarkRoast extends Beverage {

  public DarkRoast() {
    description = "DarkRoast";
  }

  @Override
  public double cost() {
    return .99;
  }
}
