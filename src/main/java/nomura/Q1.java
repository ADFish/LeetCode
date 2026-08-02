package nomura;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] A = new int[4];
        int[] B = new int[4];
        A[0] = 2;
        A[1] = -2;
        A[2] = -3;
        A[3] = 3;

        B[0] = 0;
        B[1] = 0;
        B[2] = 4;
        B[3] = -4;


        System.out.println(solution(A, B));

    }
    public static int solution(int[] A, int[] B) {
        // Implement your solution here
        int m = A.length;
        int n = B.length;
        int[] a = new int[m];
        int[] b = new int[n];

        int prefixA = 0;
        int prefixB = 0;
        System.out.println("a");
        for(int i = 0; i < m; i++) {
            prefixA += A[i];
            a[i] = prefixA;
            System.out.println(a[i]);
        }

        System.out.println("b");
        for(int i = 0; i < n; i++) {
            prefixB += B[i];
            b[i] = prefixB;
            System.out.println(b[i]);
        }

        int k = 0;
        int count = 0;

        System.out.println("k");
        while(k < m - 1 && k < n - 1) {
            if((a[k] == (a[m-1] - a[k])) && (b[k] == (b[n-1] - b[k])) && (a[k] == b[k])) {
                System.out.println(k);
                count++;
            }
            k++;
        }

        return count;

    }
}
