//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
       long [][] dp=new long[N+1][sum+1];
       for(int i=0;i<=N;i++)
       {
           dp[i][0]=1;
       }
       for(int i=1;i<=N;i++)
       {
           for(int j=1;j<=sum;j++)
           {
               
               if(j>=coins[i-1])
               {
                   dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
               }else
               {
                   dp[i][j]=dp[i-1][j];
               }
           }
           //System.out.println(Arrays.toString(dp[i]));
       }
        return dp[N][sum];
    }
    public long solve(int coins[],int i, int N, int sum,Long[][] dp)
    {
        if(sum==0)
        {
            return 1;
        }
        if(sum<0)
        {
            return 0;
        }
        if(i>=N)
        {
            return 0;
        }
        if(dp[i][sum]!=null)
        {
            return dp[i][sum];
        }
        long take=solve(coins,i,N,sum-coins[i],dp);
        long nottake=solve(coins,i+1,N,sum,dp);
        return dp[i][sum]= take+nottake;
    }
}