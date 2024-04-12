//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            long Arr[] = new long[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) Arr[i] = Long.parseLong(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.pairAndSum(N, Arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long pairAndSum(int n, long arr[]) {
        // code here
        long ans=0;
        for(int bit=0;bit<32;bit++)
        {
            long count=0;
            for(int i=0;i<n;i++)
            {
                if((arr[i]&(1L<<bit))!=0) count++;
            }
            
            ans+= (1L<<bit)*(((count)*(count-1))/2);
        }
        return ans;
    }
}