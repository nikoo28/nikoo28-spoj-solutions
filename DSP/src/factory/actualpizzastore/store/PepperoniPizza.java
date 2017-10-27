package factory.actualpizzastore.store;

import factory.actualpizzastore.factory.PizzaIngredientFactory;
import factory.actualpizzastore.store.Pizza;

public class PepperoniPizza extends Pizza {

  PizzaIngredientFactory ingredientFactory;

  public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  void prepare() {

    System.out.println("Preparing " + name);

    dough = ingredientFactory.createDough();
    sauce = ingredientFactory.createSauce();
    cheese = ingredientFactory.createCheese();
    veggiesList = ingredientFactory.createVeggies();
    pepperoni = ingredientFactory.createPepperoni();
  }
}