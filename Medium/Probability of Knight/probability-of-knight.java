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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean isValid(int i,int j,int n){
        if(i<0||j<0||i>=n||j>=n){
            return false;
        }
        return true;
    }
    public double findProb(int N, int start_x, int start_y, int step)
    {
        // Code here
        double[][] curr=new double[N][N];
        curr[start_x][start_y]=1;
        double[][] next=new double[N][N];
        for(int k=0;k<step;k++){
            for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int ni=0;
                int nj=0;
                if(curr[i][j]!=0){
                    ni=i+1;
                    nj=j+2;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i+1;
                    nj=j-2;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i-1;
                    nj=j+2;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i-1;
                    nj=j-2;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i-2;
                    nj=j+1;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i+2;
                    nj=j+1;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i-2;
                    nj=j-1;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    ni=i+2;
                    nj=j-1;
                    if(isValid(ni,nj,N)){
                        next[ni][nj]+=(curr[i][j])/8.0;
                    }
                    
                }
            }
        }
        
        curr=next;
        next=new double[N][N];
        }
        double ans=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans+=curr[i][j];
            }
        }
        return ans;
    }
}