//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
	// Your code here
	int sum=Arrays.stream(A).sum();
	int max=0;
	int s0=0;
	for(int i=0;i<n;i++){
	    s0+=A[i]*i;
	}
	max=Math.max(max,s0);
	int j=0;
	while(j<n-1){
	    int s=s0+sum - (n*A[n-j-1]);
	    max=Math.max(max,s);
	    s0=s;
	    j++;
	}
	return max;
    }	
}
