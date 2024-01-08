//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	// Your code here
	 if(node1==null && node2==null)
	 {
	     return node1;
	 }
	
	    Node dummyMerged=new Node(0);
	    dummyMerged.next=null;
	    Node dummyTemp=dummyMerged;
	    
	    Node n1temp=node1;
	    Node n2temp=node2;
	    
	    while(n1temp!=null && n2temp!=null)
	    {
	        if(n1temp.data<=n2temp.data)
	        {
	            dummyTemp.next=n1temp;
	            dummyTemp=n1temp;
	            n1temp=n1temp.next;
	        }else{
	            dummyTemp.next=n2temp;
	            dummyTemp=n2temp;
	            n2temp=n2temp.next;
	        }
	    }
	    
	    while(n1temp!=null)
	    {
	        dummyTemp.next=n1temp;
	        dummyTemp=n1temp;
	        n1temp=n1temp.next;
	    }
	    
	    while(n2temp!=null)
	    {
	       dummyTemp.next=n2temp;
	       dummyTemp=n2temp;
	       n2temp=n2temp.next;	        
	    }
	    
	    return rev(dummyMerged.next);
	    
    }
    Node rev(Node head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        Node prev =null;
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
