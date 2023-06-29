//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int nextHappy(int N){
        // code here
        int i=N+1;
        while(!isHappyNumber(i)){
            i++;
        }
        return i;
    }
    public static boolean isHappyNumber(int n){
        HashSet<Integer> set=new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int temp=0;
            while(n!=0){
                temp+=Math.pow(n%10,2);
                n=n/10;
            }
            n=temp;
        }
        if(n==1){
            return true;
        }
        return false;
    }
}