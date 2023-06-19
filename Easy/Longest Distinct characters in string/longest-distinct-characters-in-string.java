//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=1;
        int i=0;
        int j=0;
       
            while(j<S.length()){
                char ch=S.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)>1){
                    while(i<j && map.get(ch)!=1){
                        char cha=S.charAt(i);
                        if(map.get(cha)==1){
                            map.remove(cha);
                        }else{
                            map.put(cha,map.get(cha)-1);
                        }
                        i++;
                    }
                }
                ans=Math.max(ans,j-i+1);
                
                j++;
            }
            
            return ans;
        
    }
}