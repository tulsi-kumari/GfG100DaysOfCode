//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        int n=S.length();
        boolean[][] dp=new boolean[n][n];
        String ans="";
        int maxLen=0;
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=true;
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        ans=S.substring(i,j+1);
                    }
                }else if(g==1){
                    char s1=S.charAt(i);
                    char s2=S.charAt(j);
                    
                    if(s1==s2){
                        dp[i][j]=true;
                    }
                    if(dp[i][j]==true&&j-i+1>maxLen){
                        maxLen=j-i+1;
                        ans=S.substring(i,j+1);
                    }
                }else{
                    char s1=S.charAt(i);
                    char s2=S.charAt(j);
                    
                    if(s1==s2){
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]==true&&j-i+1>maxLen){
                        maxLen=j-i+1;
                        ans=S.substring(i,j+1);
                    }
                }
                
                
            }

        }
        
        // for(int[] t: dp){
        //     System.out.println(Arrays.toString(t));
        // }
                    
            return ans;
        
    }
}