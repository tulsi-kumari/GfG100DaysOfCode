//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
        if(n==1)
        {
            return matrix[0][0];
        }
        if(n==2)
        {
            return ((matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]));
        }
        int det=0;
        for(int j=0;j<n;j++)
        {
            det+=matrix[0][j]*cofactor(matrix,n,0,j);
        }
        return det;
    }
    static int cofactor(int[][] matrix,int n,int row,int col)
    {
        int[][] submatrix=new int[n-1][n-1];
        int smr=0;
        int smc=0;
        for(int i=0;i<n;i++)
        {
            if(i!=row)
            {
                smc=0;
                for(int j=0;j<n;j++)
                {
                    if(j!=col)
                    {
                        submatrix[smr][smc]=matrix[i][j];
                        smc++;
                    }
                }
                smr++;
            }
        }
        return (int)Math.pow(-1,row+col)*determinantOfMatrix(submatrix , n - 1);
    }
}

