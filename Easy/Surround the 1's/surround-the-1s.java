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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    solve(matrix,ans,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(ans[i][j]!=0 && ans[i][j]%2==0)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void solve(int[][] mat,int[][] ans,int i,int j)
    {
        if(isValid(i-1,j,mat))
        {
            ans[i-1][j]+=1;
        }
        if(isValid(i+1,j,mat))
        {
            ans[i+1][j]+=1;
        }
        if(isValid(i,j-1,mat))
        {
            ans[i][j-1]+=1;
        }
        if(isValid(i,j+1,mat))
        {
            ans[i][j+1]+=1;
        }
        if(isValid(i-1,j-1,mat))
        {
            ans[i-1][j-1]+=1;
        }
        if(isValid(i-1,j+1,mat))
        {
            ans[i-1][j+1]+=1;
        }
        if(isValid(i+1,j-1,mat))
        {
            ans[i+1][j-1]+=1;
        }
        if(isValid(i+1,j+1,mat))
        {
            ans[i+1][j+1]+=1;
        }
        
    }
    public boolean isValid(int i,int j,int[][] mat)
    {
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]==0)
        {
            return false;
        }
        return true;
    }
}