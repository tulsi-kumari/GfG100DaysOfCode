//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int[] ans=new int[k];
        int idx=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b)
            {
                if(Math.abs(a-x)<Math.abs(b-x))
                {
                    return -1;
                }else if(Math.abs(a-x)>Math.abs(b-x))
                {
                    return 1;
                }else
                {
                    
                    if(a>b) return -1;
                    else if(b>a) return 1;
                    else return 0;
                }
            }
        });
        for(int num:arr){
            pq.offer(num);
        }
        
        while(!pq.isEmpty() && idx<k)
        {
            int poll=pq.poll();
            if(poll!=x) ans[idx++]=poll;
        }
        return ans;
        
    }
}
