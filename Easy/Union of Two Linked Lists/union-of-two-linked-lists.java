//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    Set<Node> set=new TreeSet<>(new Comparator<Node>(){
	        public int compare(Node o1,Node o2){
	            if(o1.data>o2.data){
	                return 1;
	            }else if(o1.data<o2.data){
	                return -1;
	            }else{
	                return 0;
	            }
	        }
	    });
	    if(head1==null && head2==null){
	        return head1;
	    }
	    if(head1!=null){
	        Node temp1=head1;
	        while(temp1!=null){
	            set.add(temp1);
	            temp1=temp1.next;
	        }
	    }
	    if(head2!=null){
	        Node temp2=head2;
	        while(temp2!=null){
	            set.add(temp2);
	            temp2=temp2.next;
	        }
	    }
	    Node dummyHead=new Node(-1);
	    Node dummyTemp=dummyHead;
	    for(Node n:set){
	        dummyTemp.next=n;
	        dummyTemp=dummyTemp.next;
	    }
	    dummyTemp.next=null;
	    dummyHead=dummyHead.next;
	    return dummyHead;
	    
	}
}