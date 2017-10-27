package factory.actualpizzastore.factory;

import factory.actualpizzastore.ingredients.cheese.Cheese;
import factory.actualpizzastore.ingredients.clams.Clams;
import factory.actualpizzastore.ingredients.dough.Dough;
import factory.actualpizzastore.ingredients.pepperoni.Pepperoni;
import factory.actualpizzastore.ingredients.sauce.Sauce;
import factory.actualpizzastore.ingredients.veggies.Veggies;

import java.util.List;

/**
 * @author nikoo28 on 10/27/17
 */
public interface PizzaIngredientFactory {

  public Dough createDough();

  public Sauce createSauce();

  public Cheese createCheese();

  public List<Veggies> createVeggies();

  public Pepperoni createPepperoni();

  public Clams createClam();

}
