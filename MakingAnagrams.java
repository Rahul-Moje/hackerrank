package main.java.com.hackerrank;

import java.util.Scanner;

public class MakingAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int result = makeAnagram(a,b);
        System.out.println(result);
    }

    private static int makeAnagram(String a, String b) {
        StringBuffer first = new StringBuffer(a);
        StringBuffer second = new StringBuffer(b);
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(second.indexOf(ch+"") != -1){
                int index = first.indexOf(ch+"");
                first.deleteCharAt(index);
                index = second.indexOf(ch+"");
                second.deleteCharAt(index);
            }
        }
        return (first.length() + second.length());
    }
}
