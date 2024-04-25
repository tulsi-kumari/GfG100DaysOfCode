//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-2;i++)
        {
            for(int j=0;j<m-2;j++)
            {
                max=Math.max(max,calc(i,j,mat));
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
    int calc(int x,int y,int mat[][])
    {
        int ans=0;
        for(int i=y;i<y+3;i++)
        {
            ans+=mat[x][i];
        }
        for(int i=y;i<y+3;i++)
        {
            ans+=mat[x+2][i];
        }
        ans+=mat[x+1][y+1];
        return ans;
    }
};