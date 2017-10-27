package decorator.starbuzz.coffees;

/**
 * @author nikoo28 on 10/26/17
 */
public abstract class Beverage {

  String description = "unknown beverage";

  public String getDescription() {
    return description;
  }

  public abstract double cost();

}
