//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        Node sHead=new Node(-1);
        Node sdum=sHead;
        Node eHead=new Node(-1);
        Node edum=eHead;
        Node lHead=new Node(-1);
        Node ldum=lHead;
        Node curr=node;
        while(curr!=null)
        {
            if(curr.data<x)
            {
                sdum.next=curr;
                
                sdum=sdum.next;
            }else if(curr.data>x)
            {
                ldum.next=curr;
                ldum=ldum.next;
            }else{
                edum.next=curr;
                edum=edum.next;
            }
            curr=curr.next;
        }
        
        if(eHead.next==null)
        {
            sdum.next=lHead.next;
            ldum.next=null;
            
        }else
        {
            sdum.next=eHead.next;
            edum.next=lHead.next;
            ldum.next=null;
        }
        
        return sHead.next;
    }
}