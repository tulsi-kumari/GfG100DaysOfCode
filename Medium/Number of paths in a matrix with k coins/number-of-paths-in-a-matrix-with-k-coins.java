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
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long countPaths(int i,int j,int arr[][],int collected,int k,long dp[][][]){
        if(collected>k) return 0;
        if(i==0 && j==0){
            collected+=arr[i][j];
            if(collected==k) return 1;
            return 0;
        }
        if(dp[i][j][collected]!=-1) return dp[i][j][collected];
        long left=0,up=0;
        if(i>0) left+=countPaths(i-1,j,arr,collected+arr[i][j],k,dp);
        if(j>0) up+=countPaths(i,j-1,arr,collected+arr[i][j],k,dp);
        return dp[i][j][collected]=left+up;
    }
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        long dp[][][]=new long[n][n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return countPaths(n-1,n-1,arr,0,k,dp);
    }
    
}