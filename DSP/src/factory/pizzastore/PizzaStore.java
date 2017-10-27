package factory.pizzastore;

import factory.pizzastore.pizza.Pizza;

/**
 * @author nikoo28 on 10/27/17
 */
public class PizzaStore {

  SimplePizzaFactory simplePizzaFactory;

  public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
    this.simplePizzaFactory = simplePizzaFactory;
  }

  public Pizza orderPizza(String type) {

    Pizza pizza = simplePizzaFactory.createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
