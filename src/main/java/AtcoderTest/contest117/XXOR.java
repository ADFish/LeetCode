package AtcoderTest.contest117;

import java.util.Scanner;
import java.util.Arrays;

public class XXOR {
  public static void main(String[] args) {

    int n = 3;
    long k = 7;

    //Convert to binary string
    long[] aary = new long[]{1, 6, 3};

    //Convert to binary string
    String[] bsary = new String[n];
    int maxbslen = 0;
    System.out.println("===Input binary===");
    for (int i = 0; i < n; i++) {
      bsary[i] = Long.toBinaryString(aary[i]);
      System.out.println(bsary[i]);
      maxbslen = Math.max(maxbslen, bsary[i].length());
    }
    System.out.println();
    System.out.println(String.format("Max binary length: %s", maxbslen));
    System.out.println();

    //Count each bit in binary string
    long bitcount[] = new long[maxbslen];
    for (String bs : bsary) {
      for (int j = bs.length() - 1; j >= 0; j--) {
        if (bs.charAt(j) == '1') {
          bitcount[bs.length() - 1 - j]++;
        }
      }
    }

    for (int i = 0; i < bitcount.length; i++) {
      System.out.println(bitcount[i]);
    }
    System.out.println();

    //Calculate digits of x in binary
    int xdigit = Long.toBinaryString(k).length();
    System.out.println(String.format("xdigit = %d", xdigit));
    System.out.println();
    //Calculate x
    long x = 0;
    for (int i = xdigit - 1; i >= 0; i--) {
      long next = x + (long) Math.pow(2, i);
      if (next <= k) {
        if (i >= bitcount.length) {
          x = next;
        } else {
          if (bitcount[i] <= n / 2) {
            x = next;
          }
        }
      }//End next<=k condition
    }

    System.out.println(x);

    //Calculate f
    long f = 0;
    for (long a : aary) {
      f += x ^ a;
    }
    System.out.println(f);

  }
}