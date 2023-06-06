//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int arr[][]){
        int[][] dp =new int[n][m];
        
        int max=0;
        for(int i=0;i<n;i++){
            dp[i][m-1]=arr[i][m-1];
            max=Math.max(max,dp[i][m-1]);
        }

        for(int i=0;i<m;i++){
            dp[n-1][i]=arr[n-1][i];
            max=Math.max(max,dp[n-1][i]);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(arr[i][j]!=0){
                    int x=Math.min(dp[i+1][j],dp[i+1][j+1]);
                    x=Math.min(x,dp[i][j+1]);
                    dp[i][j]=x+1;
                    max=Math.max(max,dp[i][j]);
                }
            }


        }
        return max;
    }
    
}