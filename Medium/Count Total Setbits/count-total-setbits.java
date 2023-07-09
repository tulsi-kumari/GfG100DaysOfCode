//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countBits(int n){
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        // code here
        int i=0;
        while((1<<i)<=n){
            i++;
        }
        i--;
        int x=i;
        int ansuptox=(1<<x-1)*x;
        int restlsb=n-(1<<x) +1;
        return ansuptox+restlsb+countBits(n-(1<<x));
    }
}