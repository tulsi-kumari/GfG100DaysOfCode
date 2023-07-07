//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        Node root=new Node(level[0]);
        if(level.length==1){
            return root;
        }
        //your code here
        
        int idx=0;
        while(inord[idx]!=level[0]){
            idx++;
        }
        HashSet<Integer> leftset=new HashSet<>();
        int[] inleft=new int[idx];
        for(int i=0;i<idx;i++){
            inleft[i]=inord[i];
            leftset.add(inord[i]);
        }
        
        
        int[] inright=new int[inord.length-idx-1];
        for(int i=idx+1;i<inord.length;i++){
            inright[i-idx-1]=inord[i];
        }
        int[] levelleft=new int[inleft.length];
        int ll=0;
        int[] levelright=new int[inright.length];
        int lr=0;
        for(int i=1;i<level.length;i++){
            if(leftset.contains(level[i])){
                levelleft[ll]=level[i];
                ll++;
            }else{
                levelright[lr]=level[i];
                lr++;
            }
        }
        
        root.left=buildTree(inleft,levelleft);
        root.right=buildTree(inright,levelright);
        return root;
    }
    
   
}


