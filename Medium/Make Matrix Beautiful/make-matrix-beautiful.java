//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        int maxrowsum=Integer.MIN_VALUE;
        int[] rowsum=new int[matrix.length];
        int it=0;
        for(int i=0;i<matrix.length;i++)
        {
            int curr=Arrays.stream(matrix[i]).sum();
            rowsum[it++]=curr;
            maxrowsum=Math.max(maxrowsum,curr);
        }
        int maxcolsum=Integer.MIN_VALUE;
        it=0;
        int[] colsum=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            int sum=0;
            for(int j=0;j<matrix.length;j++)
            {
                sum+=matrix[j][i];
               
            }
             colsum[it++]=sum;
             maxcolsum=Math.max(maxcolsum,sum);
            
        }
        int max=Math.max(maxrowsum,maxcolsum);
        int ans=0;
        for(int i=0;i<rowsum.length;i++)
        {
            ans+=max-rowsum[i];
        }
        return ans;
    }
}
        
