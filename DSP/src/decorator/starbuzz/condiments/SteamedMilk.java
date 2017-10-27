package decorator.starbuzz.condiments;

import decorator.starbuzz.coffees.Beverage;

/**
 * @author nikoo28 on 10/26/17
 */
public class SteamedMilk extends CondimentDecorator {

  Beverage beverage;

  public SteamedMilk(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ",SteamedMilk";
  }

  @Override
  public double cost() {
    return .10 + beverage.cost();
  }
}
