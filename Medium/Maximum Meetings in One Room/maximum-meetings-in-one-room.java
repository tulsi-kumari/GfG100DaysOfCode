//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<ArrayList<Integer>> in=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(i+1);
            temp.add(S[i]);
            temp.add(F[i]);
            in.add(temp);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Collections.sort(in,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> o1,ArrayList<Integer> o2)
            {
                if(o1.get(2)>o2.get(2))
                {
                   return 1; 
                }else if(o1.get(2)<o2.get(2))
                {
                    return -1;
                }else
                {
                    return 0;
                }
            }
        });
        int end=-1;
        for(int i=0;i<N;i++){
            if(in.get(i).get(1)>end)
            {
                ans.add(in.get(i).get(0));
                end=in.get(i).get(2);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}
        
