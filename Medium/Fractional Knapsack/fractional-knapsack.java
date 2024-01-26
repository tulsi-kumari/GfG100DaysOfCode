//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int capacity, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1,
                               Item item2)
            {
                double cpr1
                        = ((double)item1.value
                        / (double)item1.weight);
                double cpr2
                        = ((double)item2.value
                        / (double)item2.weight);

                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });

        double totalValue = 0d;

        for (Item i : arr) {

            int curWt = (int)i.weight;
            int curVal = (int)i.value;

            if (capacity - curWt >= 0) {

                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {

                // Item cant be picked whole
                double fraction
                        = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity
                        = (int)(capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }
}