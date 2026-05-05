package leetcode100;

import java.util.*;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (n < m ) return res;

        int[] sString = new int[26];
        int[] pString = new int[26];


        for (int i = 0; i < m; i++) {
           sString[s.charAt(i) - 'a']++;
           pString[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sString, pString)) res.add(0);

        for (int i = 1; i <= n - m; i++) {
            sString[s.charAt(i + m - 1) - 'a']++;
            sString[s.charAt(i - 1) - 'a']--;
            if (Arrays.equals(sString, pString)) res.add(i);
        }

        return res;

    }
}
