//{ Driver Code Starts
//Initial Template for JAVA

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

public class Tree {
    
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
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
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    public static class Pair{
        Node node;
        int curr;
        Pair(Node node,int curr){
            this.node=node;
            this.curr=curr;
        }
    }
    public static void width(Node root,int curr,int[] minmax){
        if(root==null) return;
        minmax[0]=Math.min(curr,minmax[0]);
        minmax[1]=Math.max(curr,minmax[1]);
        width(root.left,curr-1,minmax);
        width(root.right,curr+1,minmax);
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        int[] minmax=new int[2];
        width(root,0,minmax);
        int wid=minmax[1]-minmax[0]+1;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<wid;i++){
            list.add(new ArrayList<Integer>());
        }
        
        vertical(list,root,Math.abs(minmax[0]));
        //System.out.println(list);
        ArrayList <Integer> ans=new ArrayList<>();
        for(ArrayList<Integer> al:list){
            if(al.size()==0) continue;
            ans.add(al.get(0));
        }
        return ans;
        
    }
    public static void vertical(ArrayList<ArrayList<Integer>> list,Node root,int curr){
        if(root==null){
            return;
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,curr));
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair p=q.poll();
                list.get(p.curr).add(p.node.data);
                if(p.node.left!=null){
                   q.offer(new Pair(p.node.left,p.curr-1));
                }
                if(p.node.right!=null){
                    q.offer(new Pair(p.node.right,p.curr+1)); 
                }
            }
        }
    }
}