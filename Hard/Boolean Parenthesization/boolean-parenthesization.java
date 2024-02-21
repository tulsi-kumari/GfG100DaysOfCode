//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int countWays(int n, String S){
        int mod=1003;
        // code here
        char[] bool=new char[n/2+1];
        char[] op=new char[n/2];
        int boolIdx=0;
        int opIdx=0;
        for(int i=0;i<n;i++){
            if(i%2!=0){
                op[opIdx++]=S.charAt(i);
            }else{
                bool[boolIdx++]=S.charAt(i);
            }
        }
        
        
        int m=bool.length;
        int[][] dpt=new int[m][m];
        int[][] dpf=new int[m][m];
        for(int g=0;g<m;g++){
            for(int i=0,j=g;j<m;j++,i++){
                if(g==0){
                    if(bool[i]=='T'){
                        dpt[i][j]=1;
                        dpf[i][j]=0;
                    }else{
                        dpt[i][j]=0;
                        dpf[i][j]=1;
                    }
                }else{
                    for(int k=i;k<j;k++){
                        int ltc=dpt[i][k]%mod;
                        int rtc=dpt[k+1][j]%mod;
                        int lfc=dpf[i][k]%mod;
                        int rfc=dpf[k+1][j]%mod;
                        
                        
                        if(op[k]=='&'){
                            dpt[i][j]=(dpt[i][j]+(ltc*rtc)%mod)%mod;
                            dpf[i][j]=(dpf[i][j]+(lfc*rfc)%mod+(ltc*rfc)%mod+(rtc*lfc)%mod)%mod;
                        }else if(op[k]=='|'){
                            dpt[i][j]=(dpt[i][j]+(ltc*rtc)%mod+(ltc*rfc)%mod+(rtc*lfc)%mod)%mod;
                            dpf[i][j]=(dpf[i][j]+(lfc*rfc)%mod)%mod;
                        }else{
                            dpt[i][j]=(dpt[i][j]+(ltc*rfc)%mod+(lfc*rtc)%mod)%mod;
                            dpf[i][j]=(dpf[i][j]+(ltc*rtc)%mod+(lfc*rfc)%mod)%mod;
                        }
                    }
                }
            }
        }
        
        return dpt[0][m-1];
    }
}