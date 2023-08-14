//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
       Arrays.sort(arr2);
       ArrayList<Integer> ans=new ArrayList<>();
       for(int num:arr1)
       {
           int count=bs(arr2,num,n);
           if(count==-1)
           {
               ans.add(0);
               continue;
           }
           ans.add(count+1);
       }
       return ans;
    }
    public static int bs(int[] arr,int num,int n)
    {
        int s=0;
        int e=n-1;
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]>num)
            {
                e=mid-1;
            }else{
                ans=mid;
                s=mid+1;
            }
        }
        return ans;
    }
}