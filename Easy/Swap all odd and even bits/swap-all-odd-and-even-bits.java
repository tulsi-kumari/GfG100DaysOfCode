//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
	    // Your code
	    long oddmask=1;
	    long evenmask=2;
	    int i=0;
	   // System.out.println(Integer.toBinaryString(n));
	    while(i<16){
	        oddmask=(oddmask<<2)|1;
	        evenmask=((evenmask<<1)|1)<<1;
	        i++;
	    }
	   // System.out.println(Long.toBinaryString(oddmask));
	   // System.out.println(Long.toBinaryString(evenmask));
	    oddmask=(n&oddmask)<<1;
	    evenmask=(n&evenmask)>>1;
	   // System.out.println(Long.toBinaryString(oddmask));
	   // System.out.println(Long.toBinaryString(evenmask));
	    long ans=oddmask|evenmask;
	    return (int)ans;
	}
    
}

//{ Driver Code Starts.

class BitWise{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//taking n
		    
		    Solution obj = new Solution();
		    
		    //calling swapBits() method of class
		    //Swap
		    System.out.println(obj.swapBits(n));
		}
	}
}
// } Driver Code Ends