//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //normal bfs add
        boolean[] visited=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsadd(st,visited,adj,i);
            }
        }
        visited=new boolean[V];
        adj=reverse(adj,V);
        int ans=0;
        while(!st.isEmpty()){
            if(!visited[st.peek()]){
                dfs(visited,adj,st.pop());
                ans++;
            }else{
                st.pop();
            }
        }
        return ans;
        
    }
    public ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj,int V){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            ArrayList<Integer> al=adj.get(i);
            for(int j=0;j<al.size();j++){
                int x=al.get(j);
                ans.get(x).add(i);
            }
        }
        return ans;
    }
    public void dfsadd(Stack<Integer> st,boolean[] visited,ArrayList<ArrayList<Integer>> adj,int x){
        if(visited[x]){
            return;
        }
        visited[x]=true;
        ArrayList<Integer> list=adj.get(x);
        for(int y:list){
            dfsadd(st,visited,adj,y);
        }
        st.add(x);
        
    }
    public void dfs(boolean[] visited,ArrayList<ArrayList<Integer>> adj,int x){
        if(visited[x]){
            return;
        }
        visited[x]=true;
        ArrayList<Integer> list=adj.get(x);
        for(int y:list){
            dfs(visited,adj,y);
        }
    }
}
