//{ Driver Code Starts
import java.util.Scanner;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    int length(Node n){
        int ret =0;
        while(n!=null){
            ret++;
            n = n.next;
        }
        return ret;
    }
    
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        while(head1 !=null && head1.data ==0){
            head1 = head1.next;
        }
        while(head2 !=null && head2.data ==0){
            head2 = head2.next;
        }
        int n1 = length(head1);
        int n2 = length(head2);
        if(n1==0 && n2 ==0){
            return new Node(0);
        }
        if(n2>n1){
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        if(n1==n2){
            Node tmp1 = head1;
            Node tmp2 = head2;
            while(tmp1.data == tmp2.data){
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
                if(tmp1 == null){
                    return new Node(0);
                }
            }
            if(tmp2.data>tmp1.data){
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node ans = null;
        Node tmp1 = head1;
        Node tmp2 = head2;
        while(tmp1 != null){
            int less =0;
            if(tmp2!= null){
                less = tmp2.data;
            }
            if(tmp1.data<less){
                if(tmp1.next!=null){
                    tmp1.next.data-=1;
                }
                tmp1.data+=10;
            }
            Node ne = new Node(tmp1.data-less);
            ne.next = ans;
            ans = ne;
            tmp1=tmp1.next;
            if(tmp2!=null){
                tmp2= tmp2.next;
            }
        }
        while(ans!=null && ans.next !=null && ans.data==0){
            ans = ans.next;
        }
        return ans;
    }
}
        
