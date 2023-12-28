//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean[][] dp;
    static boolean match(String wild, String pattern)
    {
        // code here
        dp=new Boolean[wild.length()][pattern.length()];
        return solve(0,0,wild,pattern);
    }
    static boolean solve(int i,int j,String wild,String pattern)
    {
        if(i==wild.length() && j==pattern.length())
        {
            return true;
        }
        if(i==wild.length()||j==pattern.length())
        {
            return false;
        }
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        char w=wild.charAt(i);
        char p=pattern.charAt(j);
        if(w==p||w=='?')
        {
            boolean ret=solve(i+1,j+1,wild,pattern);
            if(ret)
            {
                return dp[i][j]=true;
            }
        }else if(w=='*')
        {
            boolean ret=false;
            for(int k=j;k<=pattern.length();k++)
            {
                ret=solve(i+1,k,wild,pattern);
                if(ret)
                {
                    return dp[i][j]= true;
                }
            }
        }
            return dp[i][j]=false;
        
    }
}