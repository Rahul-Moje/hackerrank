import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoStrings {

	// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	
    	//Making sure s1 always has the minimum length
    	Map<Character,Integer> hashMap = new HashMap<>();
    	String result = "NO";
    	for(int i=0;i<s1.length();i++)
    		hashMap.put(s1.charAt(i), i);
    	for(int j=0;j<s2.length();j++) {
    		if(hashMap.containsKey(s2.charAt(j))) {
    			result = "YES";
    			break;
    		}
    	}
    	
    	
    	return result;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }

}
