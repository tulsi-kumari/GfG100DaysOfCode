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
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int ans=-1;
        while(true)
        {
            boolean flag1=true;
            boolean flag2=true;
            while(map.size()<=k && j<s.length())
            {
                flag1=false;
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()>k)
                {
                    map.remove(ch);
                    ans=Math.max(ans,j-i);
                    break;
                }
                j++;
            }
            if(j==s.length() && map.size()==k)
            {
                ans=Math.max(ans,j-i);
            }
            while(map.size()==k)
            {
                flag2=false;
                char ch=s.charAt(i);
                if(map.get(ch)==1)
                {
                    map.remove(ch);
                    i++;
                    break;
                }else
                {
                    map.put(ch,map.get(ch)-1);
                }
                i++;
            }
            if(flag1 && flag2)
            {
                break;
            }
            
        }
        return ans;
    }
}