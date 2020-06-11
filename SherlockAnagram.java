import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagram {

	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int count = 0;
    	int length = s.length();
    	for(int i=1;i<length;i++) {
    		for(int j=0;j<=length-i;j++) {
    			String compare1 = s.substring(j,j+i);
    			for(int k=j+1;k<=length-i;k++) {
    				String compare2 = s.substring(k,k+i);
    				if(compareUsingMap(compare1,compare2))
    					count++;
    			}	
    		}
    	}
    	
    	return count;
    	
    }

    private static boolean compareUsingMap(String compare1, String compare2) {
		char compare1Arr[] = compare1.toCharArray();
		char compare2Arr[] = compare2.toCharArray();
		Map<Character,Integer> checkMap = new HashMap<Character,Integer>();
		for(char ch:compare1Arr) {
			if(checkMap.containsKey(ch))
				checkMap.put(ch,(checkMap.get(ch)+1));
			else
				checkMap.put(ch,1);
		}
		boolean anagram = true;
		for(char ch:compare2Arr) {
			if(checkMap.containsKey(ch) == false) {
				anagram = false;
				break;
			}
			else
			{
				checkMap.put(ch, (checkMap.get(ch)-1));
			}
		}
		if(!anagram)
			return anagram;
		for(char ch:compare1Arr) {
			if(checkMap.get(ch)!=0) {
				anagram = false;
				break;
			}
		}
		return anagram;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = 
        		new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
