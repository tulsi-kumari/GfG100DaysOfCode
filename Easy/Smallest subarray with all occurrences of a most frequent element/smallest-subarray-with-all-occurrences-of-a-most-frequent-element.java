//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int arr[], int n)
    {
        // Complete the function
        //map to record starting index;
        HashMap<Integer,Integer> smap=new HashMap<>();
        HashMap<Integer,Integer> fmap=new HashMap<>();
        int hf=0;
        int s=-1;
        int e=-1;
        int len=0;
        for(int i=0;i<n;i++){
            int curr=arr[i];
            Integer j=smap.get(curr);
            if(j==null){
                smap.put(curr,i);
            }
            fmap.put(curr,fmap.getOrDefault(curr,0)+1);
            if(fmap.get(curr)>hf){
                hf=fmap.get(curr);
                s=smap.get(curr);
                e=i;
                len=i-smap.get(curr)+1;
            }else if(fmap.get(curr)==hf){
                if(i-smap.get(curr)+1<len){
                    hf=fmap.get(curr);
                    s=smap.get(curr);
                    e=i;
                    len=i-smap.get(curr)+1;
                }
            }
            
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=s;i<=e;i++){
            ans.add(arr[i]);
        }
        return ans;
        
        
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends