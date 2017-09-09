import java.util.HashSet;
import java.util.Set;

public class JudgeRouteCircle {

  public boolean judgeCircle(String moves) {

    Set<String> locations = new HashSet<>();
    int x = 0;
    int y = 0;

    locations.add("0,0");

    for (int i = 0; i < moves.length(); i++) {

      switch (moves.charAt(i)) {

        case 'U':
          y++;
          break;

        case 'D':
          y--;
          break;

        case 'L':
          x--;
          break;

        case 'R':
          x++;
          break;
      }

      String move = Integer.toString(x) + "," + Integer.toString(y);
      if (locations.contains(move))
        return true;
      else
        locations.add(move);
    }

    return false;
  }

}
