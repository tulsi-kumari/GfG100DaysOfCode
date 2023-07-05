//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
       List<String>[] arr=new ArrayList[s.length()];
        HashSet<String> set=new HashSet<>(dict);
        for(int i=0;i<s.length();i++){
            arr[i]=new ArrayList<>();
        }
        
        for(int i=0;i<s.length();i++){
            for(int j=i;j>=0;j--){
                String str=s.substring(j,i+1);
                if(dict.contains(str)){
                    if(j==0){
                        arr[i].add(str);
                    }else{
                        for(String temp:arr[j-1]){
                            arr[i].add(temp+" "+str);
                        }
                    }
                }
            }
        }
        return arr[s.length()-1];
        
    }
}