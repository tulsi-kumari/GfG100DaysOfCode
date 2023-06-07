//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends
//User function Template for Java

class Solution

{
    static int mod=1000000007;
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        // Your code goes here
        long[] dp=new long[N+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=N;i++){
            for(int j=0;j<i;j++){
                dp[i]= (dp[i]%mod  +  ((dp[j]%mod)*(dp[i-j-1]%mod))%mod)%mod;
            }
        }
        //System.out.println(Arrays.toString(dp));
        
        return (int)(dp[N]%mod);
        
        
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}

// } Driver Code Ends