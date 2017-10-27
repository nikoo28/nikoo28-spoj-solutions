package factory.pizzastore.pizza;

/**
 * @author nikoo28 on 10/27/17
 */
public class PepperoniPizza extends Pizza {

  public PepperoniPizza() {
    name = "Pepperoni Pizza";
    dough = "Crust";
    sauce = "Marinara sauce";
    toppings.add("Sliced Pepperoni");
    toppings.add("Sliced Onion");
    toppings.add("Grated parmesan cheese");
  }

}
