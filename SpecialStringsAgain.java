package main.java.com.hackerrank;

import java.util.Scanner;

public class SpecialStringsAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String input = scanner.next();
        SpecialStringsAgain specialStringsAgain = new SpecialStringsAgain();
        long count = specialStringsAgain.substrCount(length,input);
        System.out.println(count);
    }

    private long substrCount(int length, String input) {
        for(int i=0;i<length;i++){
            char start = input.charAt(i);
            int subLength = 1;
            
        }
        return 1L;
    }
}
