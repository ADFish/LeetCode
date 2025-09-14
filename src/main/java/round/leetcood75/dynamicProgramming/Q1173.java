package round.leetcood75.dynamicProgramming;

public class Q1173 {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if( n <= 2) return 1;
        int tn = 0;
        int tn1 = 1;
        int tn2 = 1;
        int tn3 = 0;

        for(int i = 0; i <= n - 3 ; i++) {
            tn3 = tn + tn1 + tn2;
            tn = tn1;
            tn1 = tn2;
            tn2 = tn3;
        }
        return tn3;
    }
}
