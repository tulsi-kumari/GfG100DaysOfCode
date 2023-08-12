//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        // int[] dp=new int[a.length];
        // int fiMax=Integer.MIN_VALUE;
        // for(int i=0;i<size;i++)
        // {
        //     dp[i]=1;
        //     int max=Integer.MIN_VALUE;
        //     for(int j=i-1;j>=0;j--)
        //     {
        //         if(a[j]<a[i])
        //         {
        //             max=Math.max(max,dp[j]);
        //         }
        //     }
        //     if(max!=Integer.MIN_VALUE)
        //     {
        //         dp[i]+=max;
        //     }
        //     fiMax=Math.max(fiMax,dp[i]);
        // }
        //System.out.println(Arrays.toString(dp));
        //return fiMax;
         ArrayList<Integer> list =new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<size; i++){
            if(a[i] > list.get(list.size()-1)) {
                list.add(a[i]);
            }else{
                int pos = lowerBound(list, a[i]);
                list.set(pos, a[i]);
            }
        }
        return list.size();
    }
        public static int lowerBound(ArrayList<Integer> list, int elem){
            int s=0;
            int e=list.size();
            int mid=0;
            int ans=0;
        while(s<=e){
            mid = (s+e)/2;
            if(list.get(mid)>=elem)
            {
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
            
            
            
            
            // if(list.get(mid) >= elem){
            //     high = mid-1;
            // }else low = mid+1;
        }
        return ans;
    }
} 