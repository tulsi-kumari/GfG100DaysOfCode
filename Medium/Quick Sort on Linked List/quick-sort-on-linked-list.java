//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node node)
    {
        //Your code here
        if(node==null||node.next==null)
        {
            return node;
        }
        int len=findlen(node);
        int mid=len/2;
        Node pivotNode=findPivot(node,mid);
        Node[] seg=segregate(node,pivotNode);
        Node left=quickSort(seg[0]);
        Node right=quickSort(seg[2]);
        return merge(left,seg[1],right);
    }
    public static Node merge(Node left,Node node,Node right)
    {
        if(left!=null && right!=null)
        {
            Node leftTail=findTail(left);
            leftTail.next=node;
            node.next=right;
            return left;
        }else if(left==null && right==null)
        {
            return node;
        }else if(left==null)
        {
            node.next=right;
            return node;
        }
            Node leftTail=findTail(left);
            leftTail.next=node;
            return left;
        
    }
    public static Node findTail(Node head)
    {
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        return temp;
    }
    public static Node[] segregate(Node node,Node pivot)
    {
        Node small=new Node(-1);
        Node large=new Node(-1);
        Node s=small;
        Node l=large;
        Node curr=node;
        while(curr!=null)
        {
            if(curr!=pivot)
            {
                if(curr.data<=pivot.data)
                {
                    s.next=curr;
                    s=s.next;
                }else if(curr.data>pivot.data)
                {
                    l.next=curr;
                    l=l.next;
                }
                
            }
            curr=curr.next;
        }
        s.next=null;
        l.next=null;
        pivot.next=null;
        return new Node[]{small.next,pivot,large.next};
    }
    public static Node findPivot(Node node,int mid)
    {
        Node curr=node;
        while(mid-->0)
        {
            curr=curr.next;
        }
        return curr;
    }
    public static int findlen(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int len=0;
        Node curr=node;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        return len;
    }
    
    
}