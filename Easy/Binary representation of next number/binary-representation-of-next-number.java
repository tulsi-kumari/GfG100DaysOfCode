//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        int i=s.length()-1;
        StringBuilder sb=new StringBuilder(s); 
        while(i>=0)
        {
            if(sb.charAt(i)=='0')
            {
                sb.setCharAt(i,'1');
                break;
            }else
            {
                sb.setCharAt(i,'0');
            }
            i--;
        }
        if(i<0)
        {
            
            sb.insert(0,'1');
        }
        String ans=sb.toString();
        ans = ans.replaceAll("^[0]*", "");
        return ans;
        
    }
}