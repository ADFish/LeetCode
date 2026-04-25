package round.leetcood75;

public class Q392 {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int j = 0;

        for (int i = 0; i < sChars.length; i++) {
            boolean find = false;
            while (j < t.length()) {
                if (tChars[j] == sChars[i]) {
                    find = true;
                    j++;
                    break;
                } else j++;
            }

            if(!find || j >  t.length()) return false;
        }

        return true;
    }
}
