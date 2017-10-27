package factory.pizzastorefranchise;

import factory.pizzastorefranchise.pizza.Pizza;

/**
 * @author nikoo28 on 10/27/17
 */
public abstract class PizzaStore {

  public Pizza orderPizza(String type) {

    Pizza pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  abstract Pizza createPizza(String type);
}
