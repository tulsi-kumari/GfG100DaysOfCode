//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int mod=(int)1e9+7;
    int distinctSubsequences(String str) {
        // code here
        int n=str.length();
        int[] prev=new int[n];
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(str.charAt(i))){
                prev[i]=mp.get(str.charAt(i));
                mp.put(str.charAt(i),i);
            }else{
                mp.put(str.charAt(i),i);
                prev[i]=-1;
            }
        }
        
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<n+1;i++){
            dp[i]=(2*(dp[i-1]%mod))%mod;
            if(prev[i-1]!=-1){
                dp[i]=(mod + dp[i]-dp[prev[i-1]])%mod;
            }
        }
        
        return dp[n];
    }
    
}