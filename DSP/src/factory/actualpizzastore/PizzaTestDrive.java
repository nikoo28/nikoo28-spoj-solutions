package factory.actualpizzastore;

import factory.actualpizzastore.store.ChicagoPizzaStore;
import factory.actualpizzastore.store.NYPizzaStore;
import factory.actualpizzastore.store.Pizza;
import factory.actualpizzastore.store.PizzaStore;

public class PizzaTestDrive {

  public static void main(String[] args) {

    PizzaStore nyStore = new NYPizzaStore();
    PizzaStore chicagoStore = new ChicagoPizzaStore();

    Pizza ethanPizza = nyStore.orderPizza("cheese");
    System.out.println("Ethan ordered a " + ethanPizza + "\n");

    Pizza joelPizza = chicagoStore.orderPizza("clam");
    System.out.println("Joel ordered a " + joelPizza + "\n");

    System.out.println("NIKOO ordered a " + chicagoStore.orderPizza("veggie") + "\n");
  }
}