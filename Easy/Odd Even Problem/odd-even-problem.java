//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']+=1;
        }
        int x=0;
        int y=0;
        
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=0)
            {
                if(i%2==0)
                {
                   if(arr[i]%2!=0) y++; 
                }else
                {
                    if(arr[i]%2==0) x++; 
                }
            }
        }
        return (x+y)%2==0?"EVEN":"ODD";
    }
}
