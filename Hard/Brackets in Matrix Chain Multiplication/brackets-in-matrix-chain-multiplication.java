//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    private static int get(int[] p, int n) {
        int[][] m = new int[n][n];
        int ans = 1000000000;

        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                m[i][i + L - 1] = Integer.MAX_VALUE;

                for (int k = i; k <= i + L - 2; k++) {
                    int q = m[i][k] + m[k + 1][i + L - 1] + p[i - 1] * p[k] * p[i + L - 1];

                    if (q < m[i][i + L - 1]) {
                        m[i][i + L - 1] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    private static int find(String s, int[] p) {
        List<int[]> arr = new ArrayList<>();
        int ans = 0;

        for (char t : s.toCharArray()) {
            if (t == '(') {
                arr.add(new int[]{-1, -1});
            } else if (t == ')') {
                int[] b = arr.remove(arr.size() - 1);
                int[] a = arr.remove(arr.size() - 1);
                arr.remove(arr.size() - 1);
                arr.add(new int[]{a[0], b[1]});
                ans += a[0] * a[1] * b[1];
            } else {
                arr.add(new int[]{p[t - 'A'], p[t - 'A' + 1]});
            }
        }

        return ans;
    }

    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            String result=ob.matrixChainOrder(p, n);
            if(get(p,n)==find(result,p))
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   public static class Pair{
       int val;
       String str;
       Pair(int val,String str){
           this.val=val;
           this.str=str;
       }
   }
   static String matrixChainOrder(int arr[], int n){
       // code here
       Pair[][] dp=new Pair[n-1][n-1];
       
       for(int d=0;d<dp.length;d++){
           for(int i=0,j=d;j<dp.length;i++,j++){
               if(d==0){
                   int val=0;
                   String s="";
                   s+=(char)('A'+i);
                   dp[i][j]=new Pair(val,s);
               }else if(d==1){
                   int val=arr[i]*arr[j]*arr[j+1];
                   String s="(";
                   s+=(char)('A'+i);
                   s+=(char)('A'+j);
                   s+=')'; 
                   dp[i][j]=new Pair(val,s);
               }else{
                   int min=Integer.MAX_VALUE;
                   String s="";
                   for(int k=i;k<j;k++){
                       int lc=dp[i][k].val;
                       int rc=dp[k+1][j].val;
                       
                       int mc=arr[i]*arr[k+1]*arr[j+1];
                       
                       int tc=lc+rc+mc;
                       
                       if(tc<min){
                           min=tc;
                           s="("+dp[i][k].str+dp[k+1][j].str+")";
                       }
                   }
                   dp[i][j]=new Pair(min,s);
               }
           }
       }
       return dp[0][dp.length-1].str;
   }
}