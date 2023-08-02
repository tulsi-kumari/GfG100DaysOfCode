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
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public String toString(){
            return "("+this.x+","+this.y+")";
        }
    }
    int shortestDistance(int N, int M, int arr[][], int X, int Y) {
        // code here
       
            if(arr[0][0]==0){
                return -1;
            }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,0));
        int ti[]={0,-1,1,0}; 
        int tj[]={1,0,0,-1}; 
        int[][] dist=new int[N][M];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        //int ans=0;
        while(!q.isEmpty())
        {
             //System.out.println(q);
            //ans++;
            
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;
                if(x==X && y==Y){
                    return dist[x][y];
                }
                arr[x][y]=0;
                 for(int k=0;k<4;k++)
                 {
                     int newi=x+ti[k];
                     int newj=y+tj[k];
                     if(isValid(newi,newj,x,y,arr,N,M)){
                         if(dist[newi][newj]>dist[x][y]+1){
                             dist[newi][newj]=dist[x][y]+1;
                             q.offer(new Pair(newi,newj));
                         }
                         
                     }
                 }
                
               
            
        
        }
        return -1;
    }
    boolean isValid(int i,int j,int x,int y,int arr[][],int n,int m){
        if(i<0||j<0||i>=n||j>=m||arr[i][j]==0||(i==x&&j==y)){
            return false;
        }
        return true;
    }
};