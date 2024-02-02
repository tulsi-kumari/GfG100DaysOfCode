//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	int i=0;
        int ans=0;
        boolean flag =false;
        if(str.charAt(i)=='-'){
            flag=true;
            i++;
        }
	// Your code here
	while(i<str.length()){
	    if(str.charAt(i)>'9'||str.charAt(i)<'0'){
	        return -1;
	    }
	    ans=ans*10+str.charAt(i)-'0';
	    i++;
	}
	if(flag){
	    return ans*-1;
	}
	return ans;
    }
}
