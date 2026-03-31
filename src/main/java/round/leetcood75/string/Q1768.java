package round.leetcood75.string;

public class Q1768 {
    public String mergeAlternately(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        int size1 = char1.length;
        int size2 = char2.length;

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < size1 && i < size2){
            sb.append(char1[i]);
            sb.append(char2[i]);
            i++;
        }

        if(i < size1) {
            for(int j = i; j < size1; j++){
                sb.append(char1[j]);
            }
        }

        if(i < size2) {
            for(int j = i; j < size2; j++){
                sb.append(char2[j]);
            }
        }

        return sb.toString();
    }

}
