package com.castro;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
    private static final String VOCALS = "aeiou";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!#$%&/()=?¡¿'_-:;,.|<>@$*";
    private static final int NUM_PAIR_LETTERS = 4;
    private static final int NUM_NUMBERS = 2;
    private static final int NUM_SYMBOLS = 2;
    private static  final String REPEAT = "Y";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String res;
        do {
            String password = "";
            for (int i = 0; i < NUM_PAIR_LETTERS; i++) {
                password += generatePair();
            }
            for (int i = 0; i < NUM_NUMBERS; i++) {
                password += getRandom(NUMBERS);
            }
            for (int i = 0; i < NUM_SYMBOLS; i++) {
                password += getRandom(SYMBOLS);
            }
            System.out.println("The password generated is: " + password + "\nif you want other pass press "+ REPEAT + ", if not any key");

            res = scanner.next();
        }while (res.equalsIgnoreCase(REPEAT));
        scanner.close();
    }

    private static char getRandom(@NotNull String option){
        int pos = (int)(Math.random() * option.length());
        System.out.println("pos es igual a: "+ pos + " y option.length() es: "+option.length()+"y Math.random()"+ Math.random());
        return option.charAt(pos);
    }

    private static @NotNull String generatePair(){
        String pair = "";
        if (Math.random() < 0.5){
            pair += getRandom(VOCALS);
            pair += getRandom(CONSONANTS);

        }else {
            pair += getRandom(CONSONANTS);
            pair += getRandom(VOCALS);
        }
        return pair;
    }


}
