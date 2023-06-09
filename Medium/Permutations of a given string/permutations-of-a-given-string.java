//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        Set<String> set=new HashSet<>();
        
        helper("",S,set);
        List<String> ans=new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    public void helper(String p,String up,Set<String> ans){
        if(up.length()==0){
            ans.add(new String(p));
            return;
        }
        char ch=up.charAt(0);
        up=up.substring(1);
        for(int i=p.length();i>=0;i--){
            String f=p.substring(0,i);
            String l=p.substring(i,p.length());
            helper(f+ch+l,up,ans);
        }
    }
}