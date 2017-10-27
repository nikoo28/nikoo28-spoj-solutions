package factory.pizzastore;

import factory.pizzastore.pizza.Pizza;

/**
 * @author nikoo28 on 10/27/17
 */
public class TestDrivePizzaStore {

  public static void main(String[] args) {

    PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());

    Pizza orderedPizza = pizzaStore.orderPizza("cheese");

    System.out.println(orderedPizza.toString());
  }

}
