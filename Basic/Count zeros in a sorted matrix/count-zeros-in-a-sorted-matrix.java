//{ Driver Code Starts
import java.util.*;



class Count_0_In_Sorted_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new GfG().countZeros(arr, n));
		t--;
		}
	}
}
// } Driver Code Ends


class GfG
{
    /*you are required to complete this method*/
    int countZeros(int arr[][], int n)
    {
        // Your code here
        
        int r=0;
        int c=n-1;
        int ans=0;
        while(c>=0&&r<n)
        {
            if(arr[r][c]==0)
            {
                ans+=c+1;
                r++;
            }else{
                c--;
            }
        }
        return ans;
    }
}