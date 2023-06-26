//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static long mod=1000000007;
    static int nCr(int n, int r)
    {
        if(r>n){
            return 0;
        }
        long[] prev=new long[r+1];
        long[] curr=new long[r+1];
        prev[0]=1;
        curr[0]=1;
         if(r == n || r == 0){
            return 1;
        }
            for(int j=0;j<prev.length;j++){
                prev[j]=1;
            }
        

        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                   if(j>i){
                       curr[j]=0;
                   }else if(j==i){
                       curr[j]=1;
                    }else{
                       curr[j]=(prev[j-1]+prev[j])%mod;
                   }
                    
                
            } 
            prev=curr;
            curr=new long[r+1];
            curr[0]=1;
        }
        
        
        return (int)((prev[r])%mod);
        
    }
    // static long nCr(int n, int r,long[][] dp)
    // {
    //     // code here
    //     if(r>n){
    //         return 0;
    //     }
    //     if(r==0){
    //         return 1;
    //     }
    //     if(r==n){
    //         return 1;
    //     }
    //     if(dp[n][r]!=-1){
    //         return dp[n][r];
    //     }
    //     long ans=(dp[n-1][r-1]!=-1?dp[n-1][r-1]:nCr(n-1,r-1,dp))+(dp[n-1][r]!=-1?dp[n-1][r]:nCr(n-1,r,dp));
        
        
        
    //     return (int)(ans%mod);
        
    // }
}