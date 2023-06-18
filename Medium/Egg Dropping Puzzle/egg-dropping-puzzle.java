//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    //minimum attempts to locate where the critical floor 
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int[][] dp=new int[n+1][k+1];
	    for(int[] i:dp){
	        Arrays.fill(i,-1);
	    }
	   return  help(n,k,dp);
	}
	static int help(int e,int f,int[][] dp){
	    if (f==0){
	        return 0;
	    }
	    if(e==1){
	        return f;
	    }
	    
	    if (f==1){
	        return 1;
	    }
	    if(dp[e][f]!=-1){
	        return dp[e][f];
	    }
	    int min=Integer.MAX_VALUE;
	    for(int k=1;k<=f;k++){
	        int low=0;
	        if(dp[e-1][k-1]!=-1){
	            low=dp[e-1][k-1];
	        }else{
	            low=help(e-1,k-1,dp);
	            dp[e-1][k-1]=low;
	        }
	         int high=0;
	        if(dp[e][f-k]!=-1){
	            high=dp[e][f-k];
	        }else{
	            high=help(e,f-k,dp);
	            dp[e][f-k]=high;
	        }
	        int temp=1+Math.max(low,high);
	        min=Math.min(min,temp);
	    }
	    return dp[e][f]= min;
	}
}