package factory.actualpizzastore.store;

import factory.actualpizzastore.factory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

  PizzaIngredientFactory ingredientFactory;

  public CheesePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  void prepare() {

    System.out.println("Preparing " + name);

    dough = ingredientFactory.createDough();
    sauce = ingredientFactory.createSauce();
    cheese = ingredientFactory.createCheese();
  }
}