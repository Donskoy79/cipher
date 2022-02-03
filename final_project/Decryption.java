package final_project;

public class Decryption {
    private int cryptKey;
    private String decryptInput;

    public int getmKey() {
        return cryptKey;
    }

    public String getmstringInput() {
        return decryptInput;
    }

    public Decryption(String decryptInput, int decryptKey) {
        this.decryptInput = decryptInput;
        this.cryptKey = decryptKey;

    }

    public static String decipher(Decryption decryption) {

        if (decryption.cryptKey == 0) return decryption.decryptInput;
        StringBuilder sb = new StringBuilder(decryption.decryptInput.length());
        for (int i = 0; i < decryption.decryptInput.length(); i++) {
            int tmp = decryption.decryptInput.charAt(i);

            if (tmp >= 'А' && tmp <= 'Я') {
                tmp -= decryption.cryptKey;
                if (tmp > 'Я') tmp -= 32;
            } else if (tmp >= 'а' && tmp <= 'я') {
                tmp -= decryption.cryptKey;
                if (tmp > 'я') tmp -= 32;
            }

            sb.append((char) tmp);
        }
        return sb.toString();
    }
}