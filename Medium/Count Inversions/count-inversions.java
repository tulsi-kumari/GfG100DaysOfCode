//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long ans=0;
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
       mergesort(0,(int)N-1,arr);
       long res=ans;
       ans=0;
       return res;
    }
    static long[] mergesort(int s,int e,long arr[]){
        if(s==e){
            return new long[]{arr[s]};
        }
        int mid=s+(e-s)/2;
        long[] left=mergesort(s,mid,arr);
        long[] right=mergesort(mid+1,e,arr);
        return merge(left,right);
        
    }
    static long[] merge(long[] left,long[] right){
        int n=left.length;
        int m=right.length;
        long[] num=new long[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(left[i]<=right[j]){
                num[k]=left[i];
                k++;
                i++;
            }else if(left[i]>right[j]){
                ans+=(long)(n-i);
                num[k]=right[j];
                j++;
                k++;
                
            }
        }
        while(i<n){
             num[k]=left[i];
                k++;
                i++;
        }
        while(j<m){
            num[k]=right[j];
                j++;
                k++;
        }
        return num;
    }
}