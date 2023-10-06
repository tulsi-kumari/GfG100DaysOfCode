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

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
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
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        if (odd.next == null || odd.next.next == null) return;
        Node orgHead=new Node(-1);
        Node cutHead=new Node(-1);
        Node org=orgHead;
        Node cut=cutHead;
        Node temp=odd;
        while(temp!=null)
        {
            org.next=temp;
            org=org.next;
            temp=temp.next;
            if(temp!=null)
            {
                cut.next=temp;
                cut=cut.next;
                temp=temp.next;
            }
        }
        org.next=null;
        cut.next=null;
        Node rev=reverse(cutHead.next);
        org.next=rev;
        odd= orgHead.next;
        
    }
    public static Node reverse(Node head)
    {
        if(head==null||head.next==null) return head;
        Node prev=null;
        Node curr=head;
        Node fwd=curr.next;
        while(curr!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=fwd;
            if(fwd!=null)
            {
                fwd=fwd.next;
            }
        }
        return prev;
    }
}
