//{ Driver Code Starts
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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(st,i,visited,adj);
            }
        }
        int cand=st.peek();
        visited=new boolean[V];
        dfscheck(cand,visited,adj);
        for(boolean check:visited){
            if(!check){
                return -1;
            }
        }
        return st.peek();
    }
    public void dfs(Stack<Integer> st,int s,boolean[] visited,ArrayList<ArrayList<Integer>>adj){
        if(visited[s]==true) return;
        visited[s]=true;
        ArrayList<Integer> list=adj.get(s);
        for(int v:list){
            dfs(st,v,visited,adj);
        }
        st.push(s);
    }
    public void dfscheck(int s,boolean[] visited,ArrayList<ArrayList<Integer>>adj){
        if(visited[s]==true) return;
        visited[s]=true;
        ArrayList<Integer> list=adj.get(s);
        for(int v:list){
            dfscheck(v,visited,adj);
        }
    }
}