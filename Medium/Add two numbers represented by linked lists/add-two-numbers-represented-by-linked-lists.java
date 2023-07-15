//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        if(first==null){
            return second;
        }
        if(second==null){
            return first;
        }
        // code here
        // return head of sum list
        Node num1=reverse(first);
        Node num2=reverse(second);
        //print(num1);
        //print(num2);
        Node head=new Node(-1);
        Node ftemp=num1;
        Node stemp=num2;
        Node anstemp=head;
        int carry=0;
        while(ftemp!=null && stemp!=null){
            int sum=ftemp.data+stemp.data+carry;
            int in=sum%10;
            carry=sum/10;
            Node node=new Node(in);
            anstemp.next=node;
            anstemp=anstemp.next;
            ftemp=ftemp.next;
            stemp=stemp.next;
        }
        //print(head);
        while(ftemp!=null){
            int sum=ftemp.data+carry;
            int in=sum%10;
            carry=sum/10;
            Node node=new Node(in);
            anstemp.next=node;
            anstemp=anstemp.next;
            ftemp=ftemp.next;           
        }
        //print(head);
        while(stemp!=null){
            int sum=stemp.data+carry;
            int in=sum%10;
            carry=sum/10;
            Node node=new Node(in);
            anstemp.next=node;
            anstemp=anstemp.next;
            stemp=stemp.next;             
        }
        //print(head);
        while(carry!=0){
            int sum=carry;
            int in=sum%10;
            carry=sum/10;
            Node node=new Node(in);
            anstemp.next=node;
            anstemp=anstemp.next;            
        }
        Node x=head;
        head=head.next;
        x.next=null;
        //print(head);
        Node ans=reverse(head);
        return ans;
    }
    static void print(Node n){
        Node temp=n;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    static Node reverse(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node dummy=new Node(-1);
        dummy.next=head;
        Node prev=dummy;
        Node curr=head;
        Node fwd=curr.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=fwd;
            if(fwd!=null){
                fwd=fwd.next;
            }
        }
        head.next=null;
        return prev;
    }
}