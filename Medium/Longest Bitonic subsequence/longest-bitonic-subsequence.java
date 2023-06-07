//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        int n=arr.length;
        // Code here
        int[] LIS=new int [n];
        int[] LDS=new int [n];
        LIS[0]=1;
        LDS[n-1]=1;
        for(int i=1;i<n;i++){
            int localMax=0;
            for(int j=i-1;j>=0 ;j--){
                if(arr[j]<arr[i] && LIS[j]>localMax){
                    localMax=LIS[j];
                }
            }
            LIS[i]=localMax+1;
        }
        //System.out.println(Arrays.toString(LIS));
        for(int i=n-2;i>=0;i--){
            int localMax=0;
            for(int j=i+1;j<n ;j++){
                if(arr[j]<arr[i] && LDS[j]>localMax){
                    localMax=LDS[j];
                }
            }
            LDS[i]=localMax+1;
        }
        //System.out.println(Arrays.toString(LDS));
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,LIS[i]+LDS[i]-1);
        }
        return ans;
    }
}