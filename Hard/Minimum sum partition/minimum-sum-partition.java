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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	   int sum=Arrays.stream(arr).sum();
	   HashMap<String,Integer> map=new HashMap<>();
	   int min=solve(arr,0,sum,0,map);
	   
	   
	   return min;
	} 
	public int solve(int[] arr,int i,int sum,int tempSum,HashMap<String,Integer> map){
	    if(i==arr.length){
	        return Math.abs(sum-2*tempSum);
	    }
	    String key=""+i+"@"+tempSum;
	    if(map.containsKey(key)){
	        return map.get(key);
	    }
	    int ans=Math.min(solve(arr,i+1,sum,tempSum+arr[i],map),solve(arr,i+1,sum,tempSum,map));
	    map.put(key,ans);
	    return ans;
	}
}
