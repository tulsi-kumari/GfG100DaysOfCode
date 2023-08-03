//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public class Edge implements Comparable<Edge>{
        int u;
        int v;
        int wt;
        Edge(int u,int v,int wt)
        {
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
        @Override
        public int compareTo(Edge o){
            return this.wt-o.wt;
        }
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int[] dist=new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		for(int i=0;i<M-1;i++){
		    for(int[] row:edges){
		        int f=row[0];
		        int s=row[1];
		        int w=row[2];
		        if(dist[f]!=Integer.MAX_VALUE&&dist[f]+w<dist[s])
		        {
		            dist[s]=dist[f]+w;
		        }
		    }
		}
		for(int i=0;i<N;i++){
		    if(dist[i]==Integer.MAX_VALUE){
		        dist[i]=-1;
		    }
		}
		return dist;
// 		PriorityQueue<Edges> pq=new PriorityQueue<>();
// 		for(int[] edge:edges)
// 		{
// 		    pq.add(new Edge(edge[0],edge[1],edge[2]));
// 		}
// 		int[] dist=new int[N];
// 		Arrays.fill(dist,Integer.MAX_VALUE);
// 		dist[0]=0;
// 		boolean[] visited=new boolean[N];
// 		visited[0]=true;
// 		while(!pq.isEmpty()){
// 		    Edge e=pq.poll()
// 		}
	}
}