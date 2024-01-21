//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        int ans = Integer.MAX_VALUE;
        
        outerloop:
        for(int i = 0; i <= 1 << n; i++){
            for(int j = 0; j < m; j++)
            if(!((1 << (edges[j][0] - 1) & i) != 0 || (1 << (edges[j][1] - 1) & i) != 0)) continue outerloop;
            ans = Math.min(ans, Integer.bitCount(i));
        }
        return ans;
    }
    // public static HashMap<String,Integer> dp;
    // public static int vertexCover(int n, int m, int[][] edges) {
    //     // code here
    //     dp=new HashMap<>();
    //     return solve(0,m,edges,new TreeSet<Integer>());
    // }
    // public static int solve(int i,int m,int[][] edges,TreeSet<Integer> set)
    // {
    //     if(i>=m)
    //     {
    //         return 0;
    //     }
    //     String key=""+i+"$";
    //     for(int item:set)
    //     {
    //         key+=""+item+"%";
    //     }
    //     if(dp.containsKey(key))
    //     {
    //         return dp.get(key);
    //     }
    //     int f=edges[i][0];
    //     int s=edges[i][1];
    //     if(!set.contains(f) && !set.contains(s))
    //     {
    //         int ans=0;
    //         int min=Integer.MAX_VALUE;
    //         //take f
    //         set.add(f);
    //         min=Math.min(min,1+solve(i+1,m,edges,set));
    //         set.remove(f);
    //         //take s
    //         set.add(s);
    //         min=Math.min(min,1+solve(i+1,m,edges,set));
    //         set.remove(s);
    //         //take both
    //         set.add(f);
    //         set.add(s);
    //         min=Math.min(min,2+solve(i+1,m,edges,set));
    //         set.remove(f);
    //         set.remove(s);
    //         //return
    //         ans+=min;
    //         dp.put(key,ans);
    //         return ans;
    //     }else if(!set.contains(f))
    //     {
    //         int ans=0;
    //         int min=Integer.MAX_VALUE;
    //         //dont take
    //         min=Math.min(min,solve(i+1,m,edges,set));
    //         //take f
    //         set.add(f);
    //         min=Math.min(min,1+solve(i+1,m,edges,set));
    //         set.remove(f);
    //         //return 
    //         ans+=min;
    //         dp.put(key,ans);
    //         return ans;
    //     }else if(!set.contains(s))
    //     {
    //         int ans=0;
    //         int min=Integer.MAX_VALUE;
    //         //dont take
    //         min=Math.min(min,solve(i+1,m,edges,set));
    //         //take sec
    //         set.add(s);
    //         min=Math.min(min,1+solve(i+1,m,edges,set));
    //         set.remove(s);
    //         //return
    //         ans+=min;
    //         dp.put(key,ans);
    //         return ans;
    //     }
    //     int ret=solve(i+1,m,edges,set);
    //     dp.put(key,ret);
    //     return ret;
    // }
}
        
