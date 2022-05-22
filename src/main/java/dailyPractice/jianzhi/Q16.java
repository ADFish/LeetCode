package dailyPractice.jianzhi;

public class Q16 {
    public double myPow1(double x, int n) {
        double res = 1;
        int abs = n > 0 ? n : -1 * n;
        for (int i = 1; i <= abs; i++) {
            res *= x;
        }

        return n > 0 ? res : 1 / res;
    }

    public double myPow(double x, int n) {
        //将正数n和负数n都给转换为正数n
        //注意：Java 代码中 int32 变量n∈[−2147483648,2147483647]
        //因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错
        //我们此处一开始就把 n 用 long 存储
        long b = n;

        if (n < 0) {
            b = -b;
            x = 1 / x;
        }
        return culc(x, b);
    }

    //快速幂模版
    //递归的进行x的n次方计算
    public double culc(double base, long power) {

        double res = 1.0;

        while (power > 0) {
            //两种情况会进入if语句：
            //1.幂次若为奇数，提前多乘一次x
            //2.当幂次除到1，把x赋值给res
            if ((power & 1) == 1) {
                res *= base;
            }

            //幂次除以2
            power = power >> 1;

            //底数平方
            base = base * base;
        }

        return res;
    }


}
