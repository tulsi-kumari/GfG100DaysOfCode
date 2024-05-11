//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(in.readLine());

            Solution ob = new Solution();
            List<Long> ans = new ArrayList<>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(n);
            for (int i = 0; i < ans.size(); i++) out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Long> jugglerSequence(long n) {
        // code here
        List<Long> ans=new ArrayList<>();
        while(n!=1l)
        {
            ans.add(n);
            if(n%2==0)
            {
               n=(long)Math.floor(Math.sqrt(n));
            }else
            {
                n=(long)Math.floor(Math.pow(n,1.5));
            }
        }
        ans.add(1l);
        return ans;
    }
}