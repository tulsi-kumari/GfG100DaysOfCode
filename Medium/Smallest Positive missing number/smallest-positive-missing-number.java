//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        for(int i=1;i<=size+1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return size+2;
        // int j=0;
        // int pos=1;
        // Arrays.sort(arr);
        // while(j<size && arr[j]<=0){
        //     j++;
        // }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(arr[j]+" "+j);
        // if(j==size){
        //     return pos;
        // }
        // for(int i=j;i<size;i++){
        //     if(arr[i]==pos){
        //         pos++;
        //     }else{
        //         return pos;
        //     }
        // }
        // return pos;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends