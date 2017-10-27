package factory.actualpizzastore.store;

import factory.actualpizzastore.factory.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

  PizzaIngredientFactory ingredientFactory;

  public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  void prepare() {

    System.out.println("Preparing " + name);

    dough = ingredientFactory.createDough();
    sauce = ingredientFactory.createSauce();
    cheese = ingredientFactory.createCheese();
    veggiesList = ingredientFactory.createVeggies();
  }

  // Add a custom method to cut veggie pizza
  void cut() {
    System.out.println("Cutting GOGOGO");
  }
}