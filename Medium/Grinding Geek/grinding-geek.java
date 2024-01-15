//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    Integer[][] dp;
    public int max_courses(int n, int total, int[] cost) {
        // code here
        dp=new Integer[total+1][n+1];
        return solve(cost,total,n,0);
    }
    public int solve(int[] cost,int total,int n,int i)
    {
        if(i>=n)
        {
            return 0;
        }
        if(dp[total][i]!=null) return dp[total][i];
        int curr=cost[i];
        if(curr<=total)
        {
            int take=1+solve(cost,(int)Math.floor((double)total-(double)(curr*0.1)),n,i+1);
            int notTake=solve(cost,total,n,i+1);
            return dp[total][i]= Math.max(take,notTake);
        }else
        {
            return dp[total][i]= solve(cost,total,n,i+1);
        }
        
    }
}

