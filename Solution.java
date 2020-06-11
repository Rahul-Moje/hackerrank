import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	/*
	 * Implemented based on the concept of prefix sum of array
	 */
	
	// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	
    	long arr[] = new long[n];
    	for(int i=0;i<queries.length;i++) {
    		int start  = queries[i][0] - 1;
    		int end = queries[i][1] - 1;
    		int values = queries[i][2];
    		arr[start] += values;
    		if(end != arr.length-1)
    			arr[end+1] -= values;
    	}
    	long min = Long.MIN_VALUE;
    	long initialSum = 0;
    	for(int i=0;i<arr.length;i++)
    	{
    		arr[i] += initialSum;
    		initialSum = arr[i];
    		if(arr[i] > min)
    			min = arr[i];
    	}
    	return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
