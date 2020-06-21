import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	static long countTriplets(List<Long> arr, long r) {

		Map<Long,Long> hashMap = new HashMap<>();
		for(long value:arr)
            if(hashMap.containsKey(value))
                hashMap.put(value,hashMap.get(value)+1);
            else
                hashMap.put(value,1L);
        long count=0L;
        for(long currIndex:arr) {
        	hashMap.put(currIndex, hashMap.get(currIndex)-1);
        	if(hashMap.containsKey(currIndex*r) && hashMap.containsKey(currIndex*r*r)) {
        		
        	}
        	
        		
        }
        return count;
					
				

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();
        
    }

}
