package com.gzl.tesla;

import org.junit.Test;

import java.util.concurrent.ForkJoinWorkerThread;

public class NumberWays {

    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;

        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
            if(dp[i] >= 1000000007){
                dp[i] = dp[i]%1000000007;
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        int n = 10;
        System.out.println("numWays(n) = " + numWays(n));
    }
}
