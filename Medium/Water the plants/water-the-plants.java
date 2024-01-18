//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    public class Pair
    {
        int start;
        int end;
        Pair(int start,int end)
        {
            this.start=start;
            this.end=end;
        }
        public String toString()
        {
            return ""+start+";"+end+"";
        }
    }
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        ArrayList<Pair> range=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=gallery[i];
            if(x!=-1)
            {
               int s=i-x<0?0:i-x;
               int e=i+x>=n?n-1:i+x;
               range.add(new Pair(s,e));
            }
        }
        Collections.sort(range,(a,b)->{
            int a_s=a.start;
            int b_s=b.start;
            int a_e=a.end;
            int b_e=b.end;
            if(a_s==b_s)
            {
                return Integer.compare(a_e,b_e);
            }else
            {
                return Integer.compare(a_s,b_s);
            }
        });
        //System.out.println(range);
        if(range.get(0).start!=0)
        {
            return -1;
        }
        int count=0;
        int atmost_s=0;
        int j=0;
        while(atmost_s<n && j<range.size())
        {
            int max_e=Integer.MIN_VALUE;
            while(j<range.size() && range.get(j).start<=atmost_s)
            {
                max_e=Math.max(max_e,range.get(j).end);
                j++;
            }
            if(max_e<)
            {
                return -1;
            }else
            {
                count++;
                atmost_s=max_e+1;
                if(atmost_s>=n)
                {
                    break;
                }
            }
        }
        return count;
        
        
    }
}
