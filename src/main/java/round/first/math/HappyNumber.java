package round.first.math;

import java.util.HashSet;

public class HappyNumber {

  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();

    while (n != 1) {
      if(set.contains(n)) {
        return false;
      }
      set.add(n);
      n = sumOfSquares(n);
    }

    return true;

  }

  private int sumOfSquares(int n) {
    int sum = 0;
    while (n != 0) {
      sum += (int) Math.pow(n % 10, 2);
      n = n / 10;
    }
    return sum;
  }
}
