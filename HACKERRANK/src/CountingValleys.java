import java.io.*;

public class CountingValleys {

  public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int steps;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    steps = Integer.parseInt(bufferedReader.readLine());
    String sequence = bufferedReader.readLine();
    int level = 0;
    int valleyCount = 0;
    for (int i = 0; i < sequence.length(); i++) {
      if (level == 0 && sequence.charAt(i) == 'D') {
        valleyCount++;
      }
      if (sequence.charAt(i) == 'U')
        level++;
      if (sequence.charAt(i) == 'D')
        level--;
    }

    System.out.println(valleyCount);
  }
}