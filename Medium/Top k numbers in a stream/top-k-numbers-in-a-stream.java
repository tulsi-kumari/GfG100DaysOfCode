//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> sortedFrequencyMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;

            if (frequency > 1) {
                // Remove the old frequency from the TreeSet
                sortedFrequencyMap.get(frequency - 1).remove(num);
                if (sortedFrequencyMap.get(frequency - 1).isEmpty()) {
                    sortedFrequencyMap.remove(frequency - 1);
                }
            }

            // Update the frequency in the map
            frequencyMap.put(num, frequency);

            // Add the number to the TreeSet with the updated frequency
            sortedFrequencyMap.computeIfAbsent(frequency, k -> new TreeSet<>()).add(num);

            // Build the result list
            ArrayList<Integer> currentResult = new ArrayList<>();
            int count = 0;
            for (Map.Entry<Integer, TreeSet<Integer>> entry : sortedFrequencyMap.entrySet()) {
                for (int value : entry.getValue()) {
                    currentResult.add(value);
                    count++;
                    if (count == K) {
                        break;
                    }
                }
                if (count == K) {
                    break;
                }
            }

            result.add(new ArrayList<>(currentResult));
        }

        return result;
    }
}
        
