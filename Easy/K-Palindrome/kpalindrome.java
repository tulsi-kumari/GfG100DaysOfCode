//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    //Boolean[][][] dp;
    public int kPalindrome(String str, int n, int k) {
        // code here
        // dp=new Boolean[n+1][n+1][k+1];
        // if(solve(str.toCharArray(),0,n-1,k)) return 1;
        // return 0;
        int[][] dp=new int[n+1][n+1];
        for(int gap=0;gap<n;++gap)
        {
            for(int i=0,j=gap;j<n;i++,j++)
            {
                if(i==j) dp[i][j]=0;
                else if(str.charAt(i)==str.charAt(j))
                {
                    dp[i][j]=dp[i+1][j-1];
                }else
                {
                    dp[i][j]=1+Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1]<=k?1:0;
     }
    // public boolean solve(char[] str,int i,int j,int k)
    // {
    //     if(i>j) return true;
    //     if(dp[i][j][k]!=null) return dp[i][j][k];
    //     if(str[i]==str[j])
    //     {
    //         return dp[i][j][k]=solve(str,i+1,j-1,k);
    //     }else if(k>0)
    //     {
    //         return dp[i][j][k]=solve(str,i+1,j,k-1)||solve(str,i,j-1,k-1);    
    //     }
        
    //     return dp[i][j][k]=false;
    // }
}