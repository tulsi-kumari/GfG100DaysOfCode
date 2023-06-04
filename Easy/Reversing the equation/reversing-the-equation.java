//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
        StringBuilder sb=new StringBuilder();
        sb.append(S);
        sb.reverse();
        String ans=sb.toString();
        
        char[] arr=ans.toCharArray();
        //System.out.println(Arrays.toString(arr));
        int i=0;
        int j=0;
        while(i<S.length()&&j<S.length()){
            
            while(j<S.length() &&( ans.charAt(j)!='+' && ans.charAt(j)!='-' && ans.charAt(j)!='/' && ans.charAt(j)!='*') ){
               //System.out.println(ans.charAt(j));
                j++;
            }
            //System.out.println(i + " " + j);
          reverse(arr,i,j-1);
          
         // System.out.println(Arrays.toString(arr));
          i=j+1;
          j=i;
        }
        return String.copyValueOf(arr);
    }
   
    void reverse(char[] str ,int i,int j){
        while(i<=j){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
    }
}