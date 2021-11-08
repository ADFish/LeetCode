package round.first.aainterview.Rakuten;

public class XOR {
  public static void main(String[] args) {
    System.out.println(solution(1, 6));
  }

  public static int solution(int M, int N) {
    // write your code in Java SE 8
    int result = M;
    String nString = Integer.toBinaryString(N);
    int length = nString.length();
    String mString = interpolate(Integer.toBinaryString(M), length);
    //System.out.println(mString);
    //System.out.println(nString);
    for (int i = M + 1; i <= N; i++) {
      String temp = interpolate(Integer.toBinaryString(i), length);
      result = countXOR(interpolate(Integer.toBinaryString(result), length), temp);
    }
    return result;

  }

  private static String interpolate(String m, int length) {
    if (m.length() == length) {
      return m;
    } else {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < length - m.length(); i++) {
        builder.append(0);
      }
      builder.append(m);
      return builder.toString();
    }
  }

  private static int countXOR(String m, String n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < m.length(); i++) {
      char mChar = m.charAt(i);
      char nChar = n.charAt(i);
      if (mChar == nChar) {
        builder.append(0);
      } else {
        builder.append(1);
      }
    }

    String resultString = builder.toString();
    int result = 0;
    int j = 0;
    for (int i = resultString.length() - 1; i >= 0; i--) {
      if (resultString.charAt(i) != '0') {
        result += Math.pow(2, j);
      }
      j = j + 1;
    }
    return result;
  }

}
