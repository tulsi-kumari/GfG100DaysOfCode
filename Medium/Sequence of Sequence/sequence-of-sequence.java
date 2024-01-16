//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Integer[][] dp;
    static int numberSequence(int m, int n)
    {
        // code here
        dp=new Integer[n+1][m+1];
        return solve(0,m,n,0);
    }
    static int solve(int idx,int m,int n ,int last)
    {
        if(idx==n && last<=m )
        {
            return 1;
        }
        if(last>m)
        {
            return 0;
        }
        if(dp[idx][last]!=null) return dp[idx][last];
        int ans=0;
        for(int i=(idx==0?1:last*2);i<=m;i++)
        {
            ans+=solve(idx+1,m,n,i);
        }
        return dp[idx][last]= ans;
    }
}