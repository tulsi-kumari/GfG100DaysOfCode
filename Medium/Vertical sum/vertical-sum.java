//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        ArrayList <Integer> ans=new ArrayList<>();
        int[] width=new int[2];
        width[0]=Integer.MAX_VALUE;
        width[1]=Integer.MIN_VALUE;
        getwidth(width,root,0);
        int lo=width[0];
        int hi=width[1];
        int w=hi-lo;
        for(int i=0;i<=w;i++){
            ans.add(0);
        }
        traverse(root,Math.abs(lo),ans);
        return ans;
    }
    public void getwidth(int[] width,Node root,int level){
         if(root==null){
            return ;
        }
        if(level<width[0]){
            width[0]=level;
        }
        if(level>width[1]){
            width[1]=level;
        }
        getwidth(width,root.left,level-1);
        getwidth(width,root.right,level+1);
    }
    public void traverse(Node root,int level, ArrayList <Integer> ans){
        if(root==null){
            return ;
        }
        int curr=ans.get(level)+root.data;
        ans.set(level,curr);
        traverse(root.left,level-1,ans);
        traverse(root.right,level+1,ans);
    }
}
