package factory.pizzastorefranchise.pizza;

import factory.pizzastorefranchise.PizzaStore;

/**
 * @author nikoo28 on 10/27/17
 */
public class ChicagoStylePizzaStore extends PizzaStore {

  @Override
  Pizza createPizza(String type) {

    if (type.equals("cheese")) return new ChicagoStyleCheesePizza();
    else if (type.equals("veggie")) return new ChicagoStyleVeggiePizza();
    else if (type.equals("clam")) return new ChicagoStyleClamPizza();
    else if (type.equals("pepperoni")) return new ChicagoStylePepperoniPizza();
    else return null;
  }
}
