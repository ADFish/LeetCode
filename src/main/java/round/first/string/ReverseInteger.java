package round.first.string;

public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(-123));
  }

  public static int reverse(int x) {
    int rev = 0;

    while (x != 0) {
      //How to deal with overflow?
      int tail = x % 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && tail > 7)) return 0;
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && tail < -8)) return 0;
      rev = rev * 10 + tail;
      x = x / 10;
    }

    return rev;
  }

}
