//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        HashMap<String,Long> map=new HashMap<>();
        long ans=0;
        int count0=0;
        int count1=0;
        int count2=0;
        map.put("0#0",1L);
        for(char ch:str.toCharArray()){
            if(ch=='0'){
                count0++;
            }else if(ch=='1'){
                count1++;
            }else{
                count2++;
            }
            String key=""+(count0-count1)+"#"+(count1-count2);
            if(map.containsKey(key)){
               ans+= map.get(key);
               map.put(key,map.get(key)+1);
            }else{
                map.put(key,1L);
            }
            
            
        }
        return ans;
    }
} 