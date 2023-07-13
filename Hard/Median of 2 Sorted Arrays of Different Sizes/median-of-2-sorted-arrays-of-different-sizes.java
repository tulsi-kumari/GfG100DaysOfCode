//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        if(m<n){
            int[] temp=a;
            a=b;
            b=temp;
            int t=n;
            n=m;
            m=t;
        }
        int x=(n+m)/2;
        boolean isEven=true;
        if((n+m)%2!=0){
            isEven=false;
            x++;
        }
        int s=0;
        int e=n;
        int tl=n+m;
        while(s<=e){
            int mida=s+(e-s)/2;
            int midb=(tl+1)/2-mida;
            
            int ac=(mida==n)?Integer.MAX_VALUE:a[mida];
            int al=(mida==0)?Integer.MIN_VALUE:a[mida-1];
            int bc=(midb==m)?Integer.MAX_VALUE:b[midb];
            int bl=(midb==0)?Integer.MIN_VALUE:b[midb-1];
            //System.out.println(x+" "+ac+" "+al+" "+bc+" "+bl);
            if(al>bc){
                e=mida-1;
            }else if(bl>ac){
                s=mida+1;
            }else{
                if(isEven){
                    return (double)(Math.max(al*1.0,bl*1.0)+Math.min(ac*1.0,bc*1.0))/2.0;
                }else{
                    return (double)Math.max(al*1.0,bl*1.0);
                }
            }
        }
        return 0;
    }
}