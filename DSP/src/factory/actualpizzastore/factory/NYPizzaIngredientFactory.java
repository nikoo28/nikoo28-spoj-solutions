package factory.actualpizzastore.factory;

import factory.actualpizzastore.ingredients.cheese.Cheese;
import factory.actualpizzastore.ingredients.cheese.ReggianoCheese;
import factory.actualpizzastore.ingredients.clams.Clams;
import factory.actualpizzastore.ingredients.clams.FreshClams;
import factory.actualpizzastore.ingredients.dough.Dough;
import factory.actualpizzastore.ingredients.dough.ThinCrustDough;
import factory.actualpizzastore.ingredients.pepperoni.Pepperoni;
import factory.actualpizzastore.ingredients.pepperoni.SlicedPepperoni;
import factory.actualpizzastore.ingredients.sauce.MarinaraSauce;
import factory.actualpizzastore.ingredients.sauce.Sauce;
import factory.actualpizzastore.ingredients.veggies.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nikoo28 on 10/27/17
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThinCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new MarinaraSauce();
  }

  @Override
  public Cheese createCheese() {
    return new ReggianoCheese();
  }

  @Override
  public List<Veggies> createVeggies() {

    List<Veggies> veggiesList = new ArrayList<>();

    veggiesList.add(new Garlic());
    veggiesList.add(new Onion());
    veggiesList.add(new Mushroom());
    veggiesList.add(new RedPepper());

    return null;
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClam() {
    return new FreshClams();
  }
}
