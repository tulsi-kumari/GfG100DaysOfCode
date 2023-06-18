//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        long[][] dp=new long[n+1][n+1];
	    for(long[] i:dp){
	        Arrays.fill(i,-1);
	    }
        return help(0,n-1,arr,dp);
    }
    static long help(int i,int j,int[] arr,long[][] dp){
        if(i>j || i>=arr.length || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
	        return dp[i][j];
	    }
        //if choose first
        int n=arr.length;
        long start=arr[i];
        long fs=0;
         if(i+2<n && dp[i+2][j]!=-1){
             fs=dp[i+2][j];
         }else{
             fs=help(i+2,j,arr,dp);
             if(i+2<n){
                 dp[i+2][j]=fs;
             }
         }
         long fe=0;
         if(i+1<n && j-1>=0 && dp[i+1][j-1]!=-1){
             fe=dp[i+1][j-1];
         }else{
             fe=help(i+1,j-1,arr,dp);
             if(i+1<n && j-1>=0){
                 dp[i+1][j-1]=fe;
             }
             
         }
         start+=Math.min(fs,fe);
         
         
        long end=arr[j];
        long es=0;
         if(i+1<n && j-1>=0 && dp[i+1][j-1]!=-1){
             es=dp[i+1][j-1];
         }else{
             es=help(i+1,j-1,arr,dp);
             if(i+1<n && j-1>=0 ){
                dp[i+1][j-1]=es;
             }
         }
         long ee=0;
         if(j-2>=0 && dp[i][j-2]!=-1){
             ee=dp[i][j-2];
         }else{
             ee=help(i,j-2,arr,dp);
             if(j-2>=0){
                dp[i][j-2]=ee;
             }
         }
         end+=Math.min(es,ee);
         
         
         return dp[i][j]= Math.max(start,end);
        
    }
}
