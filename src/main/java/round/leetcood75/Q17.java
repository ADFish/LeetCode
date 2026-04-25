package round.leetcood75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17 {
    private static final Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();

        if (digits.length() == 0 || digits == null) return res;

        backTrack(digits, 0, res, new StringBuilder());

        return res;

    }

    private void backTrack(String digits, int index, List<String> res, StringBuilder path) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        String option = map.get(digits.charAt(index));
        for (char s : option.toCharArray()) {
            path.append(s);
            backTrack(digits, index + 1, res, path);
            path.deleteCharAt(index);
        }

    }


}
