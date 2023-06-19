//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long[] kandane=kandane(a);
        long[] windowarr=windowArr(a,k);
        // System.out.println(Arrays.toString(kandane));
        // System.out.println(Arrays.toString(windowarr));
        long[] dp=new long[a.length];
        long ans=windowarr[(int)k-1];
        for(int i=(int)(k-1);i<n;i++){
            if(i==k-1){
                dp[i]=windowarr[i];
            }else{
               dp[i]=Math.max(windowarr[i],windowarr[i]+kandane[i-(int)k]);
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    public long[] windowArr(long[] arr,long k){
        long[] dp=new long[arr.length];
        long winSum=0;
        for(int i=0;i<(int)(k-1);i++){
            winSum+=arr[i];
        }
        for(int i=(int)(k-1);i<arr.length;i++){
            winSum+=arr[i];
            dp[i]=winSum;
            winSum-=arr[i-(int)(k-1)];
            
        }
        return dp;
    }
    public long[] kandane(long[] arr){
        long[] dp=new long[arr.length];
        long max=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum=(sum+arr[i]);
            if(sum<arr[i]){
                sum=arr[i];
            }
            dp[i]=sum;
            max=Math.max(dp[i],max);
        }
        
        return dp;
    }
}