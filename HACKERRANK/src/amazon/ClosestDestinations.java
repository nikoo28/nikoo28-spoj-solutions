package amazon;

import java.util.*;

/**
 * Created by nikoo28 on 11/13/18 1:41 AM
 */

public class ClosestDestinations {

  List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
                                           int numDeliveries) {
    if (numDeliveries > numDestinations)
      return allLocations;


    TreeMap<Float, List<List<Integer>>> closestDestinations = new TreeMap<>();
    for (List<Integer> point : allLocations) {
      float dist = (float) Math.sqrt(point.get(0) * point.get(0) + point.get(1) * point.get(1));
      List<List<Integer>> temp = new ArrayList<>();
      if (closestDestinations.containsKey(dist))
        temp = closestDestinations.get(dist);
      temp.add(point);
      closestDestinations.put(dist, temp);
    }
    ArrayList<List<Integer>> result = new ArrayList<>();
    while (numDeliveries > 0) {
      List<List<Integer>> temp = closestDestinations.get(closestDestinations.firstKey());
      for (List<Integer> l : temp) {
        result.add(l);
        numDeliveries--;
      }
      closestDestinations.remove(closestDestinations.firstKey());
    }
    return result;
  }


  List<List<Integer>> ClosestX1destinations(int numDestinations, List<List<Integer>> allocations,
                                            int numDeliveries) {
    HashMap<List<Integer>, Integer> treemap = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < numDestinations; i++) {
      double dist = Math.pow(allocations.get(i).get(0), 2) + Math.pow(allocations.get(i).get(1), 2);
      treemap.put(allocations.get(i), (int) dist);
    }
    Map sortedMap = sortByValues(treemap);
    Iterator i = sortedMap.entrySet().iterator();
    int k = 0;
    while (i.hasNext() && k < numDeliveries) {
      Map.Entry me = (Map.Entry) i.next();
      k++;
      result.add((List) me.getKey());
    }
    return result;
  }

  static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
    Map<K, V> sortedByValues = new TreeMap<>((k1, k2) -> {
      int compare = map.get(k1).compareTo(map.get(k2));
      if (compare == 0)
        return 1;
      else
        return compare;
    });
    sortedByValues.putAll(map);
    return sortedByValues;

  }

  public static List<List<Integer>> findClosest(int[] x, int[] y, int target){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int[] pair = new int[2];
    int bestDiff = Integer.MIN_VALUE;
    int xIndex = 0;
    int yIndex = y.length - 1;
    //while left doesn't reach left end and right doesn't reach right end
    while(xIndex < x.length && yIndex >= 0){
      int xValue = x[xIndex];
      int yValue = y[yIndex];
      int diff = xValue + yValue - target;
      //values greater than target, y pointer go right
      if(diff > 0){
        yIndex--;
        while(yIndex > 0 && yValue == y[yIndex - 1]) yIndex--;
      }else{//combined == 0 which match target and < 0 which means the sum is less than target
        //duplicates result, just add
        if(diff == bestDiff){
          result.add(Arrays.asList(xValue, yValue));
        }
        //found better pair, clear array and add new pair
        else if(diff > bestDiff){
          result.clear();
          result.add(Arrays.asList(xValue, yValue));
          bestDiff = diff;
        }
        xIndex++;
      }
    }
    return result;
  }

  // Driver program to test above functions
  public static void main(String args[])
  {
    ClosestDestinations ob = new ClosestDestinations();
    int ar1[] = {8, 9, 15};
    int ar2[] = {8, 11, 12};
    int m = ar1.length;
    int n = ar2.length;
    int x = 20;
    List<List<Integer>> closest = ob.findClosest(ar1, ar2, x);
    for (List<Integer> integers : closest) {
      System.out.println(integers);
    }

  }
}
