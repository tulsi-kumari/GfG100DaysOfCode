//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int[] s={0,0};
        int[] e={n-1,n-1};
        int count=0;
        
        while(s[0]<n && s[1]<n && e[0]>=0 && e[1]>=0){
            int f=mat1[s[0]][s[1]];
            int sec=mat2[e[0]][e[1]];
            if(f+sec==x){
                if(s[1]==n-1){
                    s[0]++;
                    s[1]=0;
                }else{
                    s[1]++;
                }
                if(e[1]==0){
                    e[0]--;
                    e[1]=n-1;
                }else{
                    e[1]--;
                }
                
                count++;
            }else if(f+sec<x){
                if(s[1]==n-1){
                    s[0]++;
                    s[1]=0;
                }else{
                    s[1]++;
                }
            }else{
                if(e[1]==0){
                    e[0]--;
                    e[1]=n-1;
                }else{
                    e[1]--;
                }
                
            }
        }
        return count;
    }
}