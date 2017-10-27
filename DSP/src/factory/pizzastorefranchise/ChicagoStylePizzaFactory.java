package factory.pizzastorefranchise;

import factory.pizzastorefranchise.PizzaStore;
import factory.pizzastorefranchise.pizza.*;

/**
 * @author nikoo28 on 10/27/17
 */
public class ChicagoStylePizzaFactory extends PizzaStore {

  @Override
  Pizza createPizza(String type) {

    if (type.equals("cheese")) return new ChicagoStyleCheesePizza();
    else if (type.equals("veggie")) return new ChicagoStyleVeggiePizza();
    else if (type.equals("clam")) return new ChicagoStyleClamPizza();
    else if (type.equals("pepperoni")) return new ChicagoStylePepperoniPizza();
    else return null;
  }
}
