package dailyPractice.jianzhi;

public class Q17 {
    public int[] printNumbers(int n) {
        StringBuffer string = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            string.append(9);
        }
        int max = Integer.parseInt(string.toString());

        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
