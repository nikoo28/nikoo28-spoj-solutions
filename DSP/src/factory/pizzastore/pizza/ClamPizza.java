package factory.pizzastore.pizza;

/**
 * @author nikoo28 on 10/27/17
 */
public class ClamPizza extends Pizza {

  public ClamPizza() {
    name = "Clam Pizza";
    dough = "Thin crust";
    sauce = "White garlic sauce";
    toppings.add("Clams");
    toppings.add("Grated parmesan cheese");
  }

}
