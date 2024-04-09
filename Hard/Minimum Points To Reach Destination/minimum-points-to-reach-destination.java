//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Integer[][] dp;
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        dp=new Integer[m+1][n+1];
        return solve(0,0,m,n,points);
    }
    public int solve(int i,int j,int n,int m,int[][] points)
    {
        if(i==n-1 && j==m-1) return 1-points[i][j];
        
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        int op1=solve(i+1,j,n,m,points);
        int op2=solve(i,j+1,n,m,points);
        
        return dp[i][j]= Math.max(1,Math.min(op1,op2)-points[i][j]);
    }
}