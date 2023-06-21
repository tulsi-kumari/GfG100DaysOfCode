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
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);

            Solution ob = new Solution();
            System.out.println(ob.sumOfNaturals(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod=(int)1e9+7;
    static int sumOfNaturals(int n) {
        if(n==0){
            return 0;
        }
        // code here
        long ans=0;
        if(n%2==0){
            ans=(((long)n%mod)/2)%mod;
            ans=(ans%mod * ((long)(n%mod +1 )))%mod;
        }else{
            ans=(((long)(n%mod +1 ))/2)%mod;
            ans=(ans%mod * ((long)n%mod))%mod;
        }
        return (int)ans;
    }
};