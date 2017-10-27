package decorator.starbuzz.condiments;

import decorator.starbuzz.coffees.Beverage;

/**
 * @author nikoo28 on 10/26/17
 */
public abstract class CondimentDecorator extends Beverage {

  public abstract String getDescription();

}
