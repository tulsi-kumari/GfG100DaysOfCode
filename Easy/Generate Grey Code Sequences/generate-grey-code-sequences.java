//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

class GreyCode
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Solution g = new Solution();
			ArrayList <String> res = g.generateCode(n);
			for (String i : res) 
			    System.out.print (i + " ");
			System.out.println();
		t--;
		}
	}
}
// } Driver Code Ends


/*Returns an array of all n-bit gray codes sequence.
You are required to complete below method. */
class Solution
{
    ArrayList <String> generateCode(int n)
    {
	// Your code here
	if(n==1){
	    ArrayList<String> list=new ArrayList<>(Arrays.asList("0","1"));
	    return list;
	}
	ArrayList<String> prev=generateCode(n-1);
	ArrayList<String> curr=new ArrayList<>();
	for(int i=0;i<prev.size();i++){
	    curr.add("0" + prev.get(i));
	}
	for(int i=prev.size()-1;i>=0;i--){
	    curr.add("1"+prev.get(i));
	}
	
	return curr;
    }
}
