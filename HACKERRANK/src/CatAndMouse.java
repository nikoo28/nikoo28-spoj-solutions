import java.util.*;

public class CatAndMouse {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      int x = in.nextInt();
      int y = in.nextInt();
      int z = in.nextInt();
      if (Math.abs(x - z) > Math.abs(y - z))
        System.out.println("Cat B");
      else if (Math.abs(x - z) < Math.abs(y - z))
        System.out.println("Cat A");
      else
        System.out.println("Mouse C");
    }


  }
}

