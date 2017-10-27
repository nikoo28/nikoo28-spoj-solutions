package decorator.starbuzz.condiments;

import decorator.starbuzz.coffees.Beverage;

/**
 * @author nikoo28 on 10/26/17
 */
public class Mocha extends CondimentDecorator {

  Beverage beverage;

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ",Mocha";
  }

  @Override
  public double cost() {
    return .20 + beverage.cost();
  }
}
