//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int K = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int C = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.printf("%.6f\n" , ob.waterOverflow(K,R,C));
        }
    }
}
// } Driver Code Ends


class Solution {
    static double waterOverflow(int K, int R, int C) {
        // code here
        double[][] dp=new double[R+5][R+5];
        dp[0][0]=(double)K;
        for(int i=0;i<R+2;i++){
            boolean flag=true;
            for(int j=0;j<=i;j++){
                double total= dp[i][j];
                if(dp[i][j]>1){
                    flag=false;
                    double spare=dp[i][j]-1;
                    dp[i+1][j]+=spare/2;
                    dp[i+1][j+1]+=spare/2;
                    dp[i][j]=1;
                }
                
            }
            if(flag){
                i=R+2;
            }
        }
        // for(double[] t:dp){
        //     System.out.println(Arrays.toString(t));
        // }
        
        
        return dp[R-1][C-1];
        
    }
}