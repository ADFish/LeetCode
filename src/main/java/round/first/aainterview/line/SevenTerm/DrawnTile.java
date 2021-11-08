package round.first.aainterview.line.SevenTerm;

public class DrawnTile {
  public static void main(String[] args) {

    try {
      int m = 5;
      int n = 4;
      if (m % 2 != 0 && n % 2 != 0) {
        System.out.println(0);
        return;
      }

      int tiles = m * n;
      int k = tiles / 2;
      long result = factorial(tiles) / (2 * factorial(k) * factorial(tiles - k));
      System.out.println(result);

    } catch (NumberFormatException e) {
      System.exit(1);
    }

  }

  public static long factorial(int number) {
    long result = 1;
    for(int i = 1; i <= number; i++){
      result = (result * i) % 1000000007;
    }
    return result;
  }
}
