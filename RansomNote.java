import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

	// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String,Integer> magazineMap = new HashMap<String,Integer>();
    	
    	for(String word : magazine) {
    		if(magazineMap.containsKey(word)) {
    			Integer count = magazineMap.get(word);
    			count++;
    			magazineMap.put(word,count);
    		}
    		else
    			magazineMap.put(word,1);
    	}
    	boolean flag = true;
    	for(String word : note) {
    		if(magazineMap.containsKey(word)) {
    			Integer count = magazineMap.get(word);
    			if(count == 0) {
    				flag = false;
    				break;
    			}
    			else
    			{
    				count--;
    				magazineMap.put(word,count);
    			}
    		}
    		else
    		{
    			flag = false;
    			break;
    		}
    	}
    	if(flag)
    		System.out.println("Yes");
    	else
    		System.out.println("No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }

}
