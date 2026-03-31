package round.leetcood75.string;

public class QGCDS {
    public String gdc (String str1, String str2){
        int l1 = str1.length();
        int l2 = str2.length();
        int min = Math.min(l1, l2);
        String res = "";
        if(min == 0){
            return "";
        }

        for (int i = 1; i < min; i++) {
            String sub = str2.substring(0, i);
            if (isSubstring(sub, str1) && isSubstring(sub, str2)){
                res = sub;
            }
        }
        return res;
    }

    private Boolean isSubstring(String sub, String str){
        int subSize = sub.length();
        int strSize = str.length();
        if(subSize > strSize || strSize % subSize != 0) {
            return false;
        }
        int n = strSize / subSize;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(sub);
        }
        return str.equals(stringBuilder.toString());
    }
}
