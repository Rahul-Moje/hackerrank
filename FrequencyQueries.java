import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FrequencyQueries {
	
	// Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
    	Map<Integer,Integer> hashMap = new HashMap<>();
    	List<Integer> results = new ArrayList<Integer>();
    	int quantities[] = new int[queries.length+1];
    	
    	for(int i=0;i<queries.length;i++) {
    		int key = queries[i][1];
    		int option = queries[i][0];
    		if(option == 1) {
    			if(null != hashMap.get(key))
    			{
    				hashMap.put(key, hashMap.get(key)+1);
    				int count = hashMap.get(key);
    				quantities[count]++;
    				quantities[count-1]--;
    					
    			}
    			else {
    				hashMap.put(key, 1);
    				quantities[1]++;
    			}
    		}
    		else if(option == 2) {
    			if (null != hashMap.get(key)) {
    				hashMap.put(key, hashMap.get(key)-1);
    				int count = hashMap.get(key);
    				quantities[count]++;
    				quantities[count+1]--;
    				if(hashMap.get(key) == 0) {
    					hashMap.remove(key);
    				}
    			}	
    		}
    		else if(option ==3) {
    			if(key < quantities.length && quantities[key]>0)
    				results.add(1);
    			else
    				results.add(0);
    		}
    	}
    	return results;
    }

    public static void main(String[] args) throws IOException {
    	try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {
        
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        int[][] queries = new int[q][2];
       
        for (int i = 0; i < q; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            queries[i][0] = Integer.parseInt(query[0]);
            queries[i][1] = Integer.parseInt(query[1]);
        }
      
        List<Integer> ans = freqQuery(queries);
      
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {
        
            bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(Collectors.joining("\n")) + "\n");
        	}
    	}
    }
}   
 
