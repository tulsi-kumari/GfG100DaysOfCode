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
            int N = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            long A[] = new long[N];
            for(int i = 0; i < N; i++)
                A[i] = Long.parseLong(arr[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long mod=1000000007;
    static int countBits(int n, long arr[])
    {
        // code here
        long ans=0;
        for(int i=0;i<31;i++){
            long counton=0;
            for(long val:arr){
                if((val&(1<<i))!=0){
                    counton=(counton+1)%mod;
                }
            }
            long countoff=(arr.length-counton)%mod;
             ans=(ans+(2*((counton%mod) * (countoff%mod))%mod)%mod)%mod;
        }
        return (int)(ans%mod);
    }
    
}