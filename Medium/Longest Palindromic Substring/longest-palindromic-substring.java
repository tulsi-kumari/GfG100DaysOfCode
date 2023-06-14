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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String str){
        // code here
        int n=str.length();
        int ans=0;
        String ansString="";
        boolean[][] dp=new boolean[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                    if(ans<j-i+1){
                        ans=j-i+1;
                        ansString=str.substring(i,j+1);
                    }
                }else if(g==1){
                    if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=true;
                       if(ans<j-i+1){
                        ans=j-i+1;
                        ansString=str.substring(i,j+1);
                    }
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=dp[i+1][j-1];
                       if(dp[i][j]){
                           if(ans<j-i+1){
                        ans=j-i+1;
                        ansString=str.substring(i,j+1);
                    }
                       }
                    }else{
                        dp[i][j]=false;;
                    }
                }
                
            }
        }
        return ansString;
    }
}