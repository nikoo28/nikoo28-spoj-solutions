package factory.pizzastorefranchise;

import factory.pizzastorefranchise.pizza.Pizza;

public class PizzaTestDrive {

  public static void main(String[] args) {

    PizzaStore nyStore = new NYStylePizzaFactory();
    PizzaStore chicagoStore = new ChicagoStylePizzaFactory();

    Pizza pizza = nyStore.orderPizza("cheese");
    System.out.println("Ethan ordered a " + pizza.getName() + "\n");

    pizza = chicagoStore.orderPizza("cheese");
    System.out.println("Joel ordered a " + pizza.getName() + "\n");

    pizza = nyStore.orderPizza("clam");
    System.out.println("Ethan ordered a " + pizza.getName() + "\n");

    pizza = chicagoStore.orderPizza("clam");
    System.out.println("Joel ordered a " + pizza.getName() + "\n");
  }
}