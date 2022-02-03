package final_project;

import java.util.ArrayList;

public class Encryption {
    private String inputText;
    private int cryptKey;
    public String getInputText() {
        return inputText;
    }

    public int getCryptKey() {
        return cryptKey;
    }

    public Encryption(String inputText, int cryptKey) {
        this.inputText = inputText;
        this.cryptKey = cryptKey;
    }

    public static String encipher(Encryption encryption) {


        if (encryption.cryptKey == 0) {
            return encryption.inputText;
        }


        StringBuilder sb = new StringBuilder(encryption.inputText.length());
        for (int i = 0; i < encryption.inputText.length(); i++) {
            int c = encryption.inputText.charAt(i);

            if (c >= 'А' && c <= 'Я') {
                c += encryption.cryptKey;
                if (c > 'Я') c -= 32;
            } else if (c >= 'а' && c <= 'я') {
                c += encryption.cryptKey;
                if (c > 'я') c -= 32;
            }

            sb.append((char) c);
        }
        //System.out.println(sb);
        return sb.toString();
    }
}