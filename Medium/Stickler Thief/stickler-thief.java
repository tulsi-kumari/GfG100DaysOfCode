//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    Integer[] dp;
    public int FindMaxSum(int arr[], int n)
    {
        if(n==0)
        {
            
        }
        dp=new Integer[n+1];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public int solve(int i,int[] arr)
    {
        if(i>=arr.length)
        {
            return 0;
        }
        if(dp[i]!=null)
        {
            return dp[i];
        }
        int notTake=solve(i+1,arr);
        int take=arr[i]+solve(i+2,arr);
        return dp[i]= Math.max(notTake,take);
        
    }
}