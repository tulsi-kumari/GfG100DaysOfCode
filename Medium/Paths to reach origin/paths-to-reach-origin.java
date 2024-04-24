//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    static Integer[][] dp;
    static int mod=1000000007;
    public static int ways(int n, int m)
    {
        // complete the function
        dp=new Integer[n+1][m+1];
        return solve(n,m);
    }
    public static int solve(int x,int y)
    {
        if(x==0 && y==0) return 1;
        
        if(dp[x][y]!=null) return dp[x][y];
        
        if(x==0) return dp[x][y]=solve(x,y-1)%mod;
        
        if(y==0) return dp[x][y]=solve(x-1,y)%mod;
        
        return dp[x][y]=(solve(x,y-1)%mod+solve(x-1,y)%mod)%mod;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends