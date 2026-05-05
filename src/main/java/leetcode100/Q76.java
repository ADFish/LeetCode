package leetcode100;

import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) return "";

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int count = 0;

        int ansL = -1;
        int ansR = -1;

        while (right < sLen) {
            Character cur = s.charAt(right);
            if (tMap.containsKey(cur)) {
                sMap.put(cur, sMap.getOrDefault(cur, 0) + 1);
                if (sMap.get(cur).equals(tMap.get(cur))) {
                    count++;
                }
            }

            while (count == tMap.size()) {
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    ansL = left;
                    ansR = right;
                }

                Character remove = s.charAt(left);

                if (tMap.containsKey(remove)) {
                    if (sMap.get(remove).equals(tMap.get(remove))) {
                        count--;
                        sMap.put(remove, sMap.get(remove) - 1);
                    }
                }
                left++;
            }
            right++;
        }


        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);

    }
}
