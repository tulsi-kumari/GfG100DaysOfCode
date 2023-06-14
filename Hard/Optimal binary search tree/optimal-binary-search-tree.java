//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[][] dp=new int[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                if(g==0){
                    dp[i][j]=freq[j];
                }else if(g==1){
                    dp[i][j]=Math.min(2*freq[i]+freq[j],2*freq[j]+freq[i]);
                }else{
                    int localMin=Integer.MAX_VALUE;
                    int addOn=0;
                    for(int l=i;l<=j;l++){
                      addOn+=freq[l];
                    }
                    //System.out.println(addOn);
                    for(int k=i;k<=j;k++){
                        int left=(k==i?0:dp[i][k-1]);
                        int right=(k==j?0:dp[k+1][j]);
                        localMin=Math.min(localMin,left+right);
                    }
                    dp[i][j]=localMin+addOn;
                }
            }
        }
        // for(int[] t:dp){
            
        //     System.out.println(Arrays.toString(t));
        // }
        return dp[0][n-1];
    }
}
