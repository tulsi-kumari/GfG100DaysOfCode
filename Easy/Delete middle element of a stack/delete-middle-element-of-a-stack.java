//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        //Stack<Integer> temp=new Stack<>();
        int remove=0;
        remove=sizeOfStack/2;
        //System.out.println(remove);
        removemid(s,remove);
        // while(remove-->0){
        //     temp.push(s.pop());
        // }
        // s.pop();
        // while(!temp.isEmpty()){
        //     s.push(temp.pop());
        // }
    } 
    public void removemid(Stack<Integer>s,int remove){
        if(remove==0){
            s.pop();
            return;
        }
        int temp=s.pop();
        removemid(s,remove-1);
        s.push(temp);
    }
}

