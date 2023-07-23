//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        if(head==null||head.next==null){
            return head;
        }
        Node head0=new Node(-1);
        Node head1=new Node(-1);
        Node head2=new Node(-1);
        Node temp0=head0;
        Node temp1=head1;
        Node temp2=head2;
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data==0)
            {
                temp0.next=temp;
                temp0=temp0.next;
            }else if (temp.data==1)
            {
                temp1.next=temp;
                temp1=temp1.next;
            }
            else if (temp.data==2)
            {
                temp2.next=temp;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        temp1.next=head2.next;
        temp0.next=head1.next;
        
        temp2.next=null;
        return head0.next;
        
    }
}


