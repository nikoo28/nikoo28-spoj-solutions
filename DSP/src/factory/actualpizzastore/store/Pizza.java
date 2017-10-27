package factory.actualpizzastore.store;

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
public abstract class Pizza {

  String name;

  Dough dough;
  Sauce sauce;
  List<Veggies> veggiesList;
  Cheese cheese;
  Pepperoni pepperoni;
  Clams clam;

  abstract void prepare();

  void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
  }

  void box() {
    System.out.println("Place pizza in official PizzaStore box");
  }

  public void setName(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  public String toString() {

    StringBuffer result = new StringBuffer();

    result.append("---- " + name + " ----\n");

    if (dough != null) {
      result.append(dough);
      result.append("\n");
    }

    if (sauce != null) {
      result.append(sauce);
      result.append("\n");
    }

    if (cheese != null) {
      result.append(cheese);
      result.append("\n");
    }

    if (veggiesList != null) {
      for (int i = 0; i < veggiesList.size(); i++) {
        result.append(veggiesList.get(i));
        if (i < veggiesList.size() - 1) {
          result.append(", ");
        }
      }
      result.append("\n");
    }

    if (clam != null) {
      result.append(clam);
      result.append("\n");
    }

    if (pepperoni != null) {
      result.append(pepperoni);
      result.append("\n");
    }

    return result.toString();
  }

}
