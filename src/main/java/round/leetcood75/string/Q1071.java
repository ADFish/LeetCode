package round.leetcood75.string;

public class Q1071 {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int l = Math.min(l1, l2);
        String result = "";

        if (l == 0) {
            return result;
        }

        for (int i = 1; i < l; i++) {
            String sub = str1.substring(0, i);
            if (isDivisor(sub, str1) && isDivisor(sub, str2)) {
                result = sub;
            }
        }

        return result;
    }

    private Boolean isDivisor(String sub, String str) {
        int subSize = sub.length();
        int size = str.length();

        if (size < subSize || size % subSize != 0) {
            return false;
        }

        int n = size / subSize;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sub);
        }

        return sb.toString().equals(str);

    }
}
