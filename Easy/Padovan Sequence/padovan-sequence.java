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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        int mod=1000000007;
        int f=1;
        int s=1;
        int t=1;
        int i=3;
        if(n==1||n==2) return 1;
        while(i<=n)
        {
            int curr=(s%mod+f%mod)%mod;
            f=s%mod;
            s=t%mod;
            t=curr%mod;
            i++;
        }
        return t;
        
    }
    
}
