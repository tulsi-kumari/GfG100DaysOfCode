//{ Driver Code Starts
import java.util.*;
import java.io.*;
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

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
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
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        
        int len=findlen(node);
        int it=len/k;
        if(len%k!=0){
            it++;
        }
        Node temp=node;
        Node prev=null;
        boolean first=false;
        Node fihead=null;
        Node head=temp;
        while(it!=0&& head!=null){

            Node ttemp=head;
            int ktemp=k;
            while(ktemp>1&&ttemp.next!=null){
                ttemp=ttemp.next;
                ktemp--;
            }
            Node tail=ttemp;
            Node newHead=tail.next;
            Node ret=reverse(head,tail,tail.next);
            head=newHead;
            //print(ret);
            if(!first){
                fihead=ret;
                first=true;
            }
            if(prev!=null){
                Node ptemp=prev;
                while(ptemp.next!=null){
                    ptemp=ptemp.next;
                }
                ptemp.next=ret;

            }
            prev=ret;
            it--;
        }
        return fihead;
    }
    public static int findlen(Node head){
        Node temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
    public static Node reverse(Node head,Node tail,Node next){
        if(head==null||head.next==null){
            return head;
        }
        Node prev=new Node(-1);
        Node curr=head;
        Node fwd=curr.next;
        while(curr!=next){
            curr.next=prev;
            prev=curr;
            curr=fwd;
            if(fwd!=next){
                fwd=fwd.next;
            }
        }
        head.next=null;
        return prev;
    }
}

