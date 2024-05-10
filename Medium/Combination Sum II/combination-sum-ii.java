//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        ans=new ArrayList<>();
        Arrays.sort(arr);
        solve(0,arr,n,k,new ArrayList<Integer>());
        return ans;
    }
    public void solve(int idx,int[] arr,int n,int k, List<Integer> lis)
    {
        if(k==0)
        {
            List<Integer> temp=new ArrayList<>(lis);
            ans.add(temp);
            return;
        }
         for(int i=idx; i<n; i++){
            if(i>idx && arr[i] == arr[i-1] ) continue;
            if(arr[idx] > k) break;
            
            lis.add(arr[i]);
            solve(i+1, arr,n, k-arr[i], lis);
            lis.remove(lis.size() - 1);
        }
    }
}
