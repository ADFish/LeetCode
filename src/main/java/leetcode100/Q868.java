package leetcode100;

public class Q868 {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        int count = 0;
        int prevIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (count > 1) {
                    res = Math.max(res, i - prevIndex);
                }
                prevIndex = i;
            }
        }

        return res;
    }
}
