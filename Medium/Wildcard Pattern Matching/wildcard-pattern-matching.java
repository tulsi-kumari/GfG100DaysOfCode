//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        int m=str.length();
        int n=pattern.length();
        boolean[][] dp=new boolean[n+1][m+1];
        for(int i=n;i>=0;i--){
            for(int j=m;j>=0;j--){
                if(i==n && j==m){
                    dp[i][j]=true;
                }else if(i==n){
                    dp[i][j]=false;
                }else if(j==m){
                    if(pattern.charAt(i)=='*'){
                        dp[i][j]=dp[i+1][j];
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    char p=pattern.charAt(i);
                    char s=str.charAt(j);
                    if(p=='*'){
                        dp[i][j]=dp[i+1][j]||dp[i][j+1];
                    }else if(p=='?'){
                        dp[i][j]=dp[i+1][j+1];
                    }else{
                        if(p==s){
                            dp[i][j]=dp[i+1][j+1];
                        }else{
                            dp[i][j]=false;
                        }
                    }
                }
            }
        }
        // for(boolean[] i:dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return dp[0][0]? 1:0;
        
    }
}
