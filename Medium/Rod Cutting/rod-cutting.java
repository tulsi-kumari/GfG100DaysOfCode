//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp=new int[price.length+1][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return help(0,price,n,dp);
    }
    public int help(int i,int[] price,int target,int[][] dp){
        if(i==price.length||target<=0){
            return 0;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        if(i+1<=target){
            return dp[i][target] = Math.max(price[i]+help(i,price,target-i-1,dp),help(i+1,price,target,dp));
        }
        return dp[i][target] = help(i+1,price,target,dp);
    } 
}