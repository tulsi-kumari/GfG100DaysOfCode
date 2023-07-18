//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        Integer[][] dp=new Integer[str.length()][str.length()];
        return solve(0,str,0,dp);
    }
    public int solve(int i,String str,int j,Integer[][] dp){
        if(i>=str.length()||j>=str.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        char f=str.charAt(i);
        char s=str.charAt(j);
        if(f==s && i!=j){
            return dp[i][j]=1+solve(i+1,str,j+1,dp);
        }else{
            return dp[i][j]=Math.max(solve(i+1,str,j,dp),solve(i,str,j+1,dp));
        }
    }
}