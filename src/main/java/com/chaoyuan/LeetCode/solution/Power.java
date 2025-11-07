package com.chaoyuan.LeetCode.solution;

/**
 * Created by ycsgd on 2016/12/17.
 */
public class Power {

    public double myPow(double x, int m) {
        double temp=x;
        if(m==0)
            return 1;
        temp=myPow(x,m/2);
        if(m%2==0)
            return temp*temp;
        else
        {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
        }
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.myPow(8.88023, -3));
    }
}
