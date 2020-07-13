package main.java.com.hackerrank;
import java.util.*;

public class SherlockValidString {

    static int[] alphabets = new int[26];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        for(int i=0;i<s.length();i++){
            alphabets[s.charAt(i)-'a']++;
        }
        Set<Integer> distinctCountSet = new HashSet<>();
        for(int i=0;i<alphabets.length;i++){
            if(alphabets[i]!=0)
            distinctCountSet.add(alphabets[i]);
        }
        if(distinctCountSet.size()<=1)
            return true;
        else if(distinctCountSet.size()>2)
            return false;
        else {
            int prevCount = 0;
            for(int i=0;i<alphabets.length;i++) {
                if(alphabets[i] > 0) {
                    prevCount = alphabets[i];
                    alphabets[i]--;
                }
                distinctCountSet.clear();
                for (int count:alphabets)
                    if(count!=0)
                    distinctCountSet.add(count);
                if (distinctCountSet.size() == 1)
                    return true;
                else
                   alphabets[i] = prevCount;
            }
            return false;
        }
    }


    private static boolean reduceCharByOne(int[] alphabets, int greater) {
        for (int i=0;i<alphabets.length;i++){
            if(alphabets[i]!=0 && alphabets[i]==greater){
                alphabets[i]--;
                break;
            }
        }
        greater--;
        for(int count:alphabets) {
            if(count!=0 && count!=greater)
                return false;
        }
        return true;
    }
}
