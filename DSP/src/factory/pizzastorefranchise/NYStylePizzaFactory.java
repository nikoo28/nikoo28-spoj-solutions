package factory.pizzastorefranchise;

import factory.pizzastorefranchise.pizza.*;

/**
 * @author nikoo28 on 10/27/17
 */
public class NYStylePizzaFactory extends PizzaStore {

  @Override
  Pizza createPizza(String type) {

    if (type.equals("cheese")) return new NYStyleCheesePizza();
    else if (type.equals("veggie")) return new NYStyleVeggiePizza();
    else if (type.equals("clam")) return new NYStyleClamPizza();
    else if (type.equals("pepperoni")) return new NYStylePepperoniPizza();
    else return null;
  }
}
