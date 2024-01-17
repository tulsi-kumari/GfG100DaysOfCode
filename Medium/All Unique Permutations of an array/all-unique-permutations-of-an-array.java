//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static HashMap<Integer,Integer> lastOc;
    static ArrayList<ArrayList<Integer>> ans;
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        lastOc=new HashMap<>();
        Collections.sort(arr);
        ans=new ArrayList<>();
        ArrayList<Integer> spots=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            spots.add(0);
        }
        solve(0,arr,n,spots);
         Collections.sort(ans,(a,b)->{
            int s = a.size();
            for(int i=0;i<s;i++){
                if(a.get(i)!=b.get(i))
                    return Integer.compare(a.get(i),b.get(i));
            }
            return Integer.compare(a.get(0),b.get(0));
            
        });
        return ans;
        
    }
    static void solve(int idx,ArrayList<Integer> arr,int n,ArrayList<Integer> spots)
    {
        if(idx>=n)
        {
            ArrayList<Integer> temp=new ArrayList<>(spots);
            ans.add(temp);
            return;
        }
        int curr=arr.get(idx);
        int last=lastOc.getOrDefault(curr,-1);
        for(int i=last+1;i<n;i++)
        {
            if(spots.get(i)==0)
            {
                
                spots.set(i,curr);
                // System.out.println(idx);
                // System.out.println(spots);
                lastOc.put(curr,i);
                solve(idx+1,arr,n,spots);
                spots.set(i,0);
                lastOc.put(curr,last);
                
            }
        }
        return;
        
    }
};