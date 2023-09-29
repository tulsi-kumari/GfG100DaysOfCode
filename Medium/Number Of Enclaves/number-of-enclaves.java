//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        //System.out.println(count);
        for(int i=0;i<grid[0].length;i++)
        {
            if(grid[0][i]==1)
            {
                int ret=dfs(0,i,grid);
            
            count-=ret;
            }
        }
        //System.out.println(count);
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][grid[0].length-1]==1)
            {
                int ret=dfs(i,grid[0].length-1,grid);
            
            count-=ret;
            }
        }
        //System.out.println(count);
        for(int i=0;i<grid[0].length;i++)
        {
            if(grid[grid.length-1][i]==1)
            {
                int ret=dfs(grid.length-1,i,grid);
            
            count-=ret;
            }
        }
        //System.out.println(count);
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==1)
            {
                int ret=dfs(i,0,grid);
            
            count-=ret;
            }
        }
        return count;
    }
    public int dfs(int i,int j,int[][] grid)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0)
        {
            return 0;
        }
        int count=1;
        grid[i][j]=0;
        count+=dfs(i+1,j,grid);
        count+=dfs(i-1,j,grid);
        count+=dfs(i,j+1,grid);
        count+=dfs(i,j-1,grid);
        return count;
    }
}