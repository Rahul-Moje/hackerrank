package main.java.com.hackerrank;

import java.util.Scanner;

public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        AlternatingCharacters characters = new AlternatingCharacters();
        int result = characters.alternatingCharacters(input);
        System.out.println(result);
    }

    private int alternatingCharacters(String input) {
        int count = 0;
        for (int i=0;i<input.length()-1;i++){
            if(input.charAt(i) == input.charAt(i+1))
                count++;
        }
        return count;
    }
}
