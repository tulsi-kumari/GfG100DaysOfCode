//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        for(char ch:map.keySet())
        {
            pq.offer(map.get(ch));
        }
        //System.out.println(pq);
        while(!pq.isEmpty() && k>0)
        {
            int fre=pq.poll();
            //System.out.println(fre);
            pq.offer(fre-1);
            k--;
        }
        //System.out.println(pq);
        int ans=0;
        while(!pq.isEmpty())
        {
            ans+=(int)(Math.pow(pq.poll(),2));
        }
        return ans;
    }
}