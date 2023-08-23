//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<int[]> result = new ArrayList<>();
        // initialize two arrays one for rows and cols each that represents
        // change in direction [i, j]
        // left [0,-1], right[0,1], up [-1, 0], down [1,0]
        // left-top [-1,-1], right-top [-1,1], right-bottom [1,1], left-bottom [1,-1]
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1}; //for directions
        // n square the entire matrix
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //check if the first character matches with a cell
                if(grid[i][j] == word.charAt(0)){
                    // check in all directions (total 8 directions)
                    for(int dir=0;dir<8;dir++){
                        int newrow = i+dx[dir];
                        int newcol = j+dy[dir];
                        int k;
                        for(k=1;k<word.length();k++){
                            if(newrow >= rows || newcol >= cols || newrow < 0 || newcol < 0){
                                break;
                            }
                            if(grid[newrow][newcol] != word.charAt(k)){
                                break;
                            }
                            newrow += dx[dir];
                            newcol += dy[dir];
                        }
                        if(k == word.length()){
                            int[] coord = {i, j};
                            boolean alreadyExists = false;
                            for(int[] points : result){
                                if(points[0] == coord[0] && points[1] == coord[1]){
                                    alreadyExists = true;
                                    break;
                                }
                            }
                            if(!alreadyExists){
                                result.add(coord);
                            }
                        }
                    }
                }
            }
        }
        int[][] resultant = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            resultant[i] = result.get(i);
        }
        return resultant;
    }
}