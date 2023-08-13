//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int i){
        // code here
        int n=(int)i;
        int[] t=new int[n+1];
        Arrays.fill(t,-1);
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        t[0]=0;
        t[1]=1;
        for(int j=2;j<=n;j++){
            t[j]=(t[(j-1)]%(int)1000000007+t[(j-2)]%(int)1000000007)%(int)1000000007;
        }
        return t[n];
    }
}