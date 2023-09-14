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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
   final int M = 1000000007 ; 
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[n+1][sum+1];
	    for(int i=0;i<=n;i++)
	    {
	        dp[i][0]=1;
	    }
	    for(int i=1;i<=n;i++)
	    {
	        for(int j=0;j<=sum;j++)
	        {
	            if(arr[i-1]>j)
	            {
	                dp[i][j]=dp[i-1][j];
	            }else
	            {
	                dp[i][j]=(dp[i-1][j-arr[i-1]]%M+dp[i-1][j]%M)%M;
	            }
	        }
	    }
	    return dp[n][sum];
	} 
	public int solve(int i,int arr[],int n, int sum,HashMap<String,Integer> map)
	{ 
	    // Your code goes here
	    if(sum==0)
	    {
	        int j = i;
            int countZeros = 1;
            while (j < arr.length && arr[j] == 0) {
                countZeros++; 
                j++; 
            }
            return countZeros; 
	    }
	    if(i>=n)
	    {
	        return 0;
	    }
	    String key=""+i+"$"+sum;
	    if(map.containsKey(key))
	    {
	        return map.get(key);
	    }
	    int take=0,nottake=0;
	    if(arr[i]>sum)
	    {
	        nottake=solve(i+1,arr,n,sum,map)%M;
	    }else
	    {
	        take=solve(i+1,arr,n,sum-arr[i],map)%M;
	        nottake=solve(i+1,arr,n,sum,map)%M;
	    }
	    map.put(key,(take+nottake)%M);
	    return map.get(key);
	} 
}