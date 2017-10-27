package factory.actualpizzastore.factory;

import factory.actualpizzastore.ingredients.cheese.Cheese;
import factory.actualpizzastore.ingredients.cheese.MozzarellaCheese;
import factory.actualpizzastore.ingredients.clams.Clams;
import factory.actualpizzastore.ingredients.clams.FrozenClams;
import factory.actualpizzastore.ingredients.dough.Dough;
import factory.actualpizzastore.ingredients.dough.ThickCrustDough;
import factory.actualpizzastore.ingredients.pepperoni.Pepperoni;
import factory.actualpizzastore.ingredients.pepperoni.SlicedPepperoni;
import factory.actualpizzastore.ingredients.sauce.PlumTomatoSauce;
import factory.actualpizzastore.ingredients.sauce.Sauce;
import factory.actualpizzastore.ingredients.veggies.BlackOlives;
import factory.actualpizzastore.ingredients.veggies.EggPlant;
import factory.actualpizzastore.ingredients.veggies.Spinach;
import factory.actualpizzastore.ingredients.veggies.Veggies;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nikoo28 on 10/27/17
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

  @Override
  public Dough createDough() {
    return new ThickCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new PlumTomatoSauce();
  }

  @Override
  public Cheese createCheese() {
    return new MozzarellaCheese();
  }

  @Override
  public List<Veggies> createVeggies() {

    List<Veggies> veggiesList = new ArrayList<>();

    veggiesList.add(new BlackOlives());
    veggiesList.add(new Spinach());
    veggiesList.add(new EggPlant());

    return null;
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClam() {
    return new FrozenClams();
  }
}
