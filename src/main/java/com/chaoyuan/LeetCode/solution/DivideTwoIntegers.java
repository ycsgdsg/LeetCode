package com.chaoyuan.LeetCode.solution;

/**
 * Created by chaoyuan on 1/10/2017.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean flag = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            flag = true;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){
            ans = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            ans = flag ? (int)-lans : (int)lans;
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers di = new DivideTwoIntegers();
        int result = di.divide(10, 3);
        System.out.println(result);

    }
}
