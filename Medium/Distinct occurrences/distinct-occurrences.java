//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    Integer[][] dp;
    int mod=1000000007;
    int  subsequenceCount(String s, String t)
    {
	// Your code here
	    dp=new Integer[s.length()+1][t.length()+1];
	    return solve(0,0,s,t);
    }
    int solve(int i,int j,String s,String t)
    {
        if(j>=t.length()) return 1;
        if(i>=s.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]= (solve(i+1,j+1,s,t)%mod+solve(i+1,j,s,t)%mod)%mod;
        }
        
            return dp[i][j]= (solve(i+1,j,s,t)%mod);
        
    }
}