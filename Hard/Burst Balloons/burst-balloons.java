//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int n, int[] arr) {
    // code here
    int[][] dp=new int[n][n];
    for(int g=0;g<n;g++){
        for(int i=0,j=g;j<n;j++,i++){
            if(g==0){
                dp[i][j]=(i==0?1:arr[i-1])*arr[i]*(j==n-1?1:arr[j+1]);
            }else{
                int maxLocal=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int left=(k==i?0:dp[i][k-1]);
                    int right=(k==j?0:dp[k+1][j]);
                    int pf=(i==0?1:arr[i-1])*arr[k]*(j==n-1?1:arr[j+1]);
                    maxLocal=Math.max(maxLocal,left+right+pf);
                }
                dp[i][j]=maxLocal;
            }
        }
    }
    // for(int[] i : dp){
    //          System.out.println(Arrays.toString(i));
    //      }
    
    return dp[0][n-1];

  }
}
     