//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    public static ArrayList<Node> path;
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        path=new ArrayList<>();
        findpath(target,root);
        int ans=0;
        for(int i=0;i<path.size();i++)
        {
            Node prev=(i==0)?null:path.get(i-1);
            int curr=solve(path.get(i),prev);
            ans=Math.max(ans,i+curr);
        }
        return ans;
    }
    public static int solve(Node node,Node prev)
    {
        int ans=0;
        if(node.left!=null && node.left!=prev)
        {
           ans=Math.max(ans,1+solve(node.left,prev)); 
        }
        if(node.right!=null && node.right!=prev)
        {
            ans=Math.max(ans,1+solve(node.right,prev)); 
        }
        return ans;
    }
    public static boolean findpath(int target,Node root)
    {
        if(root==null) return false;
        
        if(root.data==target)
        {
            path.add(root);
            return true;
        }
        boolean left=findpath(target,root.left);
        if(left)
        {
            path.add(root);
            return true;
        }
        boolean right=findpath(target,root.right);
        if(right)
        {
            path.add(root);
            return true; 
        }
        return false;
    }
}