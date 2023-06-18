//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            q.add(i);
        }
        return help(q,K,true);
    }
    
    public static int help( ArrayDeque<Integer> q,int k,boolean f ){
        if(f){
            int cnt=k;
            while(cnt!=0){
                if(q.size()==1){
                    return q.poll();
                }
                cnt--;
                q.removeFirst();
            }
            return help(q,k,false);
        }else{
            int cnt=k;
            while(cnt!=0){
                if(q.size()==1){
                    return q.poll();
                }
                cnt--;
                q.removeLast();
            }
            return help(q,k,true);
        }
    }
}