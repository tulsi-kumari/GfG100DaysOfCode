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
                    int m = sc.nextInt();
                    int a[] = new int[n];
                    int b[] = new int[m];
                    for(int i = 0;i<n;i++)
                        a[i] = sc.nextInt();
                    for(int i = 0;i<m;i++)
                        b[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxDotProduct(n, m, a, b));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    Integer[][] dp;
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		dp=new Integer[n+1][m+1];
		return solve(0,0,a,b,n,m);
	} 
	public int solve(int i,int j,int a[],int b[],int n,int m)
	{
	    if(i>=n||j>=m) return 0;
	    
	    if(dp[i][j]!=null) return dp[i][j];
	    int take=a[i]*b[j]+solve(i+1,j+1,a,b,n,m);
	    int nottake=0;
	    if(i-j<n-m)
	    {
	        nottake=0+solve(i+1,j,a,b,n,m);
	    }
	    return dp[i][j]= Math.max(take,nottake);
	}
}
