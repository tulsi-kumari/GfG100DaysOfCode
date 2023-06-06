//{ Driver Code Starts
//Initial Template for Java
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    static Node pre,suc;
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
	            int k=Integer.parseInt(br.readLine());
        	    pre=null;
        	    suc=null;
                findPreSuc(root,k);
                if(pre!=null){
                    System.out.print(pre.data+" ");
                }else{
                    System.out.print("-1 ");
                }
                if(suc!=null){
                    System.out.println(suc.data);
                }else{
                    System.out.println("-1 ");
                }
        }
    }
  
// } Driver Code Ends



//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
    ArrayList<Node> al=new ArrayList<>();
    inorderTraversal(root,al);
    // for(Node n:al){
    //     System.out.print(n.data+" ");
    // }
    //System.out.println();
    findPreSucc(al,key,0,al.size()-1);
    
}

public static void findPreSucc(ArrayList<Node> al,int key,int i,int j){
    
    if(i>j && i<al.size() && j>=0){
        pre=al.get(j);
        suc=al.get(i);
        return;
    }
    if(i>j){
        if(i<al.size()){
           suc=al.get(i); 
        }
        
        if(j>=0){
            pre=al.get(j);
        }
        
        return;
    }
    
    int mid=i+(j-i)/2;
    
    //System.out.println(mid+" "+al.get(mid).data);
    if(al.get(mid).data<key){
        findPreSucc(al,key,mid+1,j);
    }else if(al.get(mid).data>key){
        findPreSucc(al,key,i,mid-1);
    }else{
        if(mid-1>=0){
            pre=al.get(mid-1);
        }
        
        if(mid+1<=al.size()-1){
            suc=al.get(mid+1);
        }
    }
    
    return;
    
}

public static void inorderTraversal(Node root,ArrayList<Node> al){
    if(root==null){
        return;
    }
    inorderTraversal(root.left,al);
    al.add(root);
    //System.out.print(root.data + " ");
    inorderTraversal(root.right,al);
}

}