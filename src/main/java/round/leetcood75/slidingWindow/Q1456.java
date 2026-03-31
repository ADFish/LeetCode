package round.leetcood75.slidingWindow;

import java.util.*;

public class Q1456 {
    public int maxVowels(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        Set<Character> charSet = new HashSet<>();
        charSet.add('a');
        charSet.add('e');
        charSet.add('i');
        charSet.add('o');
        charSet.add('u');

        char[] chars = s.toCharArray();

        int count = 0;
        for(int i = 0; i < k; i++){
            if(charSet.contains(chars[i])){
                count++;
            }
        }

        int max = count;

        for(int i = k; i < chars.length; i++){
            if(charSet.contains(chars[i])){
                count++;
            }
            if(charSet.contains(chars[i - k])){
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

}
