//{ Driver Code Starts
//Initial Template for Java

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
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   int[] disc;
    int[] reach;
    boolean[] visited;
    int counter=0;
    public ArrayList<ArrayList<Integer>> criticalConnections(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        disc=new int[V];
        reach=new int[V];
        visited=new boolean[V];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfs(ans,adj,i,-1);
			}
		}
        Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> o1,ArrayList<Integer> o2){
                if(o1.get(0)>o2.get(0))
                {
                    return 1;
                }else if(o1.get(0)<o2.get(0))
                {
                    return -1;
                }else
                {
                    return o1.get(1)-o2.get(1);
                }
            }
        });
        return ans;
    }
    public void dfs (ArrayList<ArrayList<Integer>> ans,ArrayList<ArrayList<Integer>> adj,int root,int parent)
    {
        visited[root]=true;
        disc[root]=reach[root]=counter++;
        ArrayList<Integer> list=adj.get(root);
        for(int child:list){
            if(child==parent){
                continue;
            }
            
            if(visited[child]){
                reach[root]=Math.min(reach[root],reach[child]);
            }else{
                dfs(ans,adj,child,root);
                reach[root]=Math.min(reach[root],reach[child]);
                if(reach[child]>disc[root]){
                    ArrayList<Integer> temp=new ArrayList<>();
                    if(root<child){
                        temp.add(root);
                        temp.add(child);
                    }else{
                        temp.add(child);
                        temp.add(root);
                    }
                    ans.add(temp);
                }
            }
        }
    }
}