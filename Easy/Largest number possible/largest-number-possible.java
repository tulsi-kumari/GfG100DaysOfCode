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
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean flag;
    static String findLargest(int N, int S){
        // code here
        // flag=false;
        // String ret=solve(N,S);
        // if(flag||(ret.charAt(0)=='0'&& N>1))
        // {
        //     return "-1";
        // }
        // return ret;
        if(N==1 && S>9 || N>1 && S==0){
            return "-1";
        } 
        if((9*N)<S){
            return "-1";
        }
        String s="";
        while(N>0){
            if(S>9){
                 s=s+"9"; 
                 S-=9;
            }
            else{ 
                s=s + Integer.toString(S);
                S=0;
            }
            N--;
        }
       
        return s;
    }
    static String solve(int N, int S){
        // code here
        if(N==0)
        {
            if(S!=0)
            {
                flag=true;
                return "-1";
                
            }
            return "";
        }
        if(S<9)
        {
           String ret=""+S;
           return ret+solve(N-1,0);
        }
        return "9"+solve(N-1,S-9);
    }
}