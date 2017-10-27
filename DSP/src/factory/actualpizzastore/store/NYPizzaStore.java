package factory.actualpizzastore.store;

import factory.actualpizzastore.factory.NYPizzaIngredientFactory;
import factory.actualpizzastore.factory.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {

  protected Pizza createPizza(String item) {

    Pizza pizza = null;
    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    if (item.equals("cheese")) {

      pizza = new CheesePizza(ingredientFactory);
      pizza.setName("NY Style Cheese Pizza");

    } else if (item.equals("veggie")) {

      pizza = new VeggiePizza(ingredientFactory);
      pizza.setName("NY Style Veggie Pizza");

    } else if (item.equals("clam")) {

      pizza = new ClamPizza(ingredientFactory);
      pizza.setName("NY Style Clam Pizza");

    } else if (item.equals("pepperoni")) {

      pizza = new PepperoniPizza(ingredientFactory);
      pizza.setName("NY Style Pepperoni Pizza");

    }
    return pizza;
  }
}