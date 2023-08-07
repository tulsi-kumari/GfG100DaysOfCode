//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        boolean ret= solve(0,0,grid);
        //printGrid(grid);
        return ret;
    }
    static boolean solve(int x,int y,int[][] grid)
    {
        if(x==9)
        {
            return true;
        }
        int nr=0;
        int nc=0;
        if(y+1==9)
        {
            nr=x+1;
            nc=0;
        }else{
            nr=x;
            nc=y+1;
        }
        //System.out.print(grid[x][y]+"hi");
        if(grid[x][y]==0)
        {
            for(int k=1;k<=9;k++ )
            {
                if(isValid(k,x,y,grid))
                {
                    grid[x][y]=k;
                    //System.out.print(grid[x][y]+"hello");
                    boolean ret=solve(nr,nc,grid);
                    if(ret)
                    {
                        return true;
                    }
                    grid[x][y]=0;
                }
            }
            
        }else{
            boolean ret=solve(nr,nc,grid);
           if(ret)
            {
                return true;
            }
        }
        return false;
    }
    static boolean isValid(int x,int i,int j,int[][] grid)
    {   
        for(int k=0;k<9;k++)
        {
            if(grid[i][k]==x)
            {
                return false;
            }
            if(grid[k][j]==x)
            {
                return false;
            }
            if(grid[3*(i/3)+k/3][3*(j/3)+k%3]==x)
            {
                return false;
            }
        }
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}