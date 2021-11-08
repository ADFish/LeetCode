package round.first.math;

public class PowerOfThree {
  public static void main(String[] args) {
    isPowerOfThree(243);
  }
  /**
   * @param n: an integer
   * @return: if n is a power of three
   */
  public static boolean isPowerOfThree(int n) {
    // Write your code here
    double result = Math.log10(n) / Math.log10(3);
    System.out.println(result);
    if(result % 1 == 0 ) {
      return true;
    } else {
      return false;
    }

  }
}
