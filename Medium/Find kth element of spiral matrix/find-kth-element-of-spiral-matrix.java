//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int arr[][], int n, int m, int k)
    {
	// Your code here
	int[] spiral=new int[m*n];
	int idx=0;
	int rowup=-1;
	int coldown=m;
	int colup=-1;
	int rowdown=n;
	int i=0;
	int j=0;
	while(idx< (m*n)){
	    boolean f1=true;
	    boolean f2=true;
	    boolean f3=true;
	    boolean f4=true;
	    while(j<coldown){
	        f1=false;
	        spiral[idx++]=arr[i][j];
	        j++;
	        k--;
	        if(k==0){
	            return spiral[idx-1];
	        }
	    }
	    rowup++;
	    i=rowup+1;
	    j=coldown-1;
	    //System.out.println(Arrays.toString(spiral) +" k="+k +" " +i+" "+j);
	    while(i<rowdown){
	        f2=false;
	        spiral[idx++]=arr[i][j];
	        i++;
	        k--;
	        if(k==0){
	            return spiral[idx-1];
	        }
	    }
	     coldown--;
	     i=rowdown-1;
	     j=coldown-1;
	    //System.out.println(Arrays.toString(spiral) +" k="+k+" " +i+" "+j);
	    while(j>colup){
	        f3=false;
	        spiral[idx++]=arr[i][j];
	        j--;
	        k--;
	        if(k==0){
	            return spiral[idx-1];
	        }
	    }
	    rowdown--;
	    i=rowdown-1;
	    j=colup+1;
	    //System.out.println(Arrays.toString(spiral)+" k="+k+" " +i+" "+j);
	    while(i>rowup){
	        f4=false;
	        spiral[idx++]=arr[i][j];
	        i--;
	        k--;
	        if(k==0){
	            return spiral[idx-1];
	        }
	    }
	    colup++;
	    i=rowup+1;
	    j=colup+1;
	    if(f1 && f2 && f3 && f4){
	        break;
	    }
	   // System.out.println(Arrays.toString(spiral) +" k="+k+" " +i+" "+j);
	    //System.out.println(rowup + " "+colup+" "+rowdown+" "+coldown);
	    
	    
	}
	return 0;
    }
}