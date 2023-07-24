//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int m)
    {
        //Your code here
        if(m>n){
            return -1;
        }
        int e=Arrays.stream(arr).sum();
        int s=-1;
        for(int num:arr){
            s=Math.max(s,num);
        }
        int ans=-1;
        //System.out.println("1hi");
        while(s<=e){
            int mid=s+(e-s)/2;
            int div=calc(mid,arr,n);
            //System.out.println(mid+" "+div);
            if(div<=m){
                ans=mid;
                e=mid-1;
            }else if(div>m){
                s=mid+1;
            }
        }
        return ans;
    }
    
    public static int calc(int maxsum,int[] arr,int n){
        int i=0;
        int sum=0;
        int count=0;
        while(i<n){
            while(i<n&&sum+arr[i]<=maxsum){
                sum+=arr[i];
                i++;
            }
            count++;
            sum=0;
        }
        return count;
    }
};