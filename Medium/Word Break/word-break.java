//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        // HashSet<String> set=new HashSet<>();
        // for(int i=0;i<B.size();i++){
        //     set.add(B.get(i));
        // }
        //code here
        boolean[] dp =new boolean[A.length()];
        for(int i=0;i<A.length();i++){
            for(int j=i;j>=0;j--){
                
                String str=A.substring(j,i+1);
                //System.out.println(str);
                if(B.contains(str)){
                    if(j==0){
                        dp[i]=true;
                    }else{
                        dp[i]=dp[j-1];
                    }
                }
                if(dp[i]==true){
                    j=-1;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        if(!dp[A.length()-1]){
            return 0;
        }
        return 1;
    }
}