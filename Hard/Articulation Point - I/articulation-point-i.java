//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    int[] disc;
    int[] reach;
    boolean[] visited;
    int counter;
    int dfsfrom0;
    HashSet<Integer> set;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        disc=new int[V];
        reach=new int[V];
        visited=new boolean[V];
        counter=0;
        set=new HashSet<>();
        dfsfrom0=0;
        
        ArrayList<Integer> ans=new ArrayList<>();
        dfs(0,adj,ans,-1);
        if(dfsfrom0>1)
        {
            ans.add(0);
        }
        if(ans.size()==0)
        {
            ans.add(-1);
        }
        //System.out.println(Arrays.toString(disc));
        //System.out.println(Arrays.toString(reach));
        Collections.sort(ans);
        return ans;
        
        
    }
    public void dfs(int root,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,int parent){
        visited[root]=true;
        disc[root]=counter;
        reach[root]=counter;
        counter++;
        ArrayList<Integer> list=adj.get(root);
        for(int child:list)
        {
            if(child==parent){
                continue;
            }
            if(visited[child])
            {
                reach[root]=Math.min(reach[root],disc[child]);
            }else
            {
                if(root==0){
                    dfsfrom0++;
                }
                dfs(child,adj,ans,root);
                //take reach
                reach[root]=Math.min(reach[root],reach[child]);
                //check if i am an articulation point
                if(reach[child]>=disc[root] && parent!=-1)
                {
                    if(!set.contains(root)){
                        set.add(root);
                        ans.add(root);
                    }
                }
            }
        }
    }
}