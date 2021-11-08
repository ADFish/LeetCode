package round.first.aainterview.line.SevenTerm;

public class InverseFibonacci {
  public static void main(String[] args) {
    long n = 4;
    if (n <= 1) {
      System.out.println(n);
    }

    long a = 0, b = 1, c = 1;
    long res = 1;

    while (c < n) {
      c = a + b;
      res++;
      a = b;
      b = c;
    }

    if (c != n) {
      System.out.println(-1);
    } else {
      System.out.println(res);
    }

  }
}
