//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] nums, int N, int k) {
        // code here
        int s=Arrays.stream(nums).max().getAsInt();
        int e=Arrays.stream(nums).sum();
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int div=calc(mid,nums);
            //System.out.println(s+" "+e+" "+ mid+" "+div);
            if(div>k){
                s=mid+1;
            }else{
                ans=mid;
                e=mid-1;
            }
            
        }
        return ans;
    }
    public static int calc(int max,int[] nums){
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
              count++;
                sum=nums[i];
            }
        }
        count++;
        return count;
    }
};