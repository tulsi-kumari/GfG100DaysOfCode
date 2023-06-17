//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isScramble(String S1,String S2)
    {
        HashMap<String ,Boolean> mp=new HashMap<>();
        return help(S1,S2,mp);
    }
    static boolean help(String str1,String str2, HashMap<String ,Boolean> mp){
        if(str1.equals(str2)){
            return true;
        }
        if(str1.length()!=str2.length()){
            return false;
        }
        String key="";
        key+=str1+" ";
        key+=str2;
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        for(int k=1;k<str1.length();k++){
            if(
                (
                 help(str1.substring(0,k),str2.substring(0,k),mp) 
                      &&
                 help(str1.substring(k,str1.length()),str2.substring(k,str2.length()),mp)
                )  
                 
                 ||
                 
                
               (
                   help(str1.substring(0,k),str2.substring(str2.length()-k,str2.length()),mp)
                                            &&
                    help(str1.substring(k,str1.length()),str2.substring(0,str2.length()-k),mp)
                )
            ){
                mp.put(key,true);
                  return true;
            }
        }
        mp.put(key,false);
        return false;
    }
}
