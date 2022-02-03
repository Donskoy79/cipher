package final_project;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Scanner scr = new Scanner(System.in);

        boolean programmRun = true;
        while (programmRun) {
            System.out.println("\nWelcome to Caesar's Cipher\n");

            System.out.println("""
                    Please choice:
                      1.Encryption
                      2.Decryption
                      3.BruteForce
                      4.Statistic
                      5.Exit
                    """);
            int choice = scr.nextInt();
            boolean a = true;
            while (!a) {
                if (choice < 1 || choice > 5) {
                    System.out.println("Wrong number!");
                }
                break;
            }

            File cipherTextFile = new File("src/final_project/Metro.txt");
            ArrayList<String> cipherText = ReadWrite.readAll(cipherTextFile);


            if (choice == 1) {
                String encryptText = String.valueOf(cipherText);
                System.out.println("Enter encrypt key");
                int encryptKey = scr.nextInt();
                Encryption cipher = new Encryption(encryptText, encryptKey);
                String enciphered = Encryption.encipher(cipher);
                System.out.println(enciphered);
                System.out.println("\nEncryption SUCCES!\n");

//                System.out.println("Do you want continue (yes\\y no\\n)?\n");
//                System.out.println("Enter please");
//                String c = scr.nextLine();


                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("foo.txt");
                    fileOutputStream.write(enciphered.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (choice == 2) {
                File decryptTextFile = new File("foo.txt");
                ArrayList<String> decryptText = ReadWrite.readAll(decryptTextFile);

                String decryption = String.valueOf(decryptText);

                System.out.println("Enter decryption key");
                int decryptKey = scr.nextInt();

                Decryption cipher = new Decryption(decryption, decryptKey);
                String decipher = Decryption.decipher(cipher);
                System.out.println(decipher);

            } else if (choice == 3) {


            } else if (choice == 4) {

            } else if (choice == 5) {
                programmRun = false;

            }

        }
    }
}
