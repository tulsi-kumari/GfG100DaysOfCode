//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    long mod=1000000007;
    //c1==c2->c1+c2+c3+(c1+1)=cps(c1m)+cps(mc2)+1;
    //c2!=c2->c1+c2+c3+(c1-c1)=cps(c1m)+cps(mc2)-cps(m);
    long countPS(String str)
    {
        // Your code here
        int n=str.length();
        long[][] dp=new long[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=3; 
                    }else{
                        dp[i][j]=2;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                       dp[i][j]=((dp[i][j-1]+dp[i+1][j])%mod +1)%mod; 
                    }else{
                        dp[i][j]=(mod+(dp[i][j-1]+dp[i+1][j])%mod-dp[i+1][j-1] )%mod;
                    }
                }
                
            }
        }
        return dp[0][n-1]%mod;
    }
}