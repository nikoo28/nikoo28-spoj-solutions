package decorator.starbuzz.coffees;

/**
 * @author nikoo28 on 10/26/17
 */
public class HouseBlend extends Beverage {

  public HouseBlend() {
    description = "House Blend Coffee";
  }

  @Override
  public double cost() {
    return .89;
  }
}
