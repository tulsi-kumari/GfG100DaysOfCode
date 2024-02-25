//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    Long[][] dp;
    public long count(int n) {
        // Add your code here.
        dp=new Long[3][n+1];
        int[] arr=new int[]{3,5,10};
        return solve(0,arr,n);
    }
    public long solve(int i,int[] arr,int n)
    {
        if(n==0) return 1;
        if(n<3) return 0;
        if(i>=3) return 0;
        if(dp[i][n]!=null) return dp[i][n];
        return dp[i][n]= solve(i,arr,n-arr[i])+solve(i+1,arr,n);
    }
}