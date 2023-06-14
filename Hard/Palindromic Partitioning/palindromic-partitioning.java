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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        boolean[][] isPalin=new boolean[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                if(g==0){
                   isPalin[i][j]=true; 
                }else if(g==1){
                    if(str.charAt(i)==str.charAt(j)){
                       isPalin[i][j]=true; 
                    }else{
                        isPalin[i][j]=false;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        isPalin[i][j]=isPalin[i+1][j-1];
                    }else{
                        isPalin[i][j]=false;
                    }
                }
            }
        }
        // for(boolean[] t:isPalin){

        //     System.out.println(Arrays.toString(t));
        // }
        
        int [][] dp=new int[n][n];
        for(int g=1;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                if(!isPalin[i][j]){
                    if(g==1){
                        dp[i][j]=1;
                    }else{
                        int minLocal=Integer.MAX_VALUE;
                       for(int k=i;k<j;k++){
                           minLocal=Math.min(minLocal,dp[i][k]+dp[k+1][j]);
                       }
                       dp[i][j]=minLocal+1;
                    }
                }
            }
        }
        // for(int[] t:dp){

        //     System.out.println(Arrays.toString(t));
        // }
        return dp[0][n-1];
    }
}