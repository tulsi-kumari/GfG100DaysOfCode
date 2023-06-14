//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int N=sc.nextInt();
                    String S=sc.next();
                        
                    Solution obj = new Solution();
                    
                    
                    System.out.println(obj.CountPS(S,N));
                    
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountPS(String str, int N)
    {
        //code here
        int n=str.length();
        int ans=0;
        boolean[][] dp=new boolean[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=true;
                       ans++;
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=dp[i+1][j-1];
                       if(dp[i][j]){
                           ans++;
                       }
                    }else{
                        dp[i][j]=false;;
                    }
                }
                
            }
        }
        return ans;
    }
}