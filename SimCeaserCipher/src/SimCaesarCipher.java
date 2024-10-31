import java.util.Scanner;

public class SimCaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Makes you pick the text for encryption
        System.out.print("Enter text to encrypt: ");
        String inputText = scanner.nextLine();

        // Makes you choose the shift amount
        System.out.print("Enter shift amount: ");
        int shift = scanner.nextInt();

        // Encrypt the text you choose with your choice of a shift amount
        String encryptedText = encrypt(inputText, shift);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the encrypted text back to the original text
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close(); // Close the scanner
    }

    // Method to encrypt text with a Caesar cipher
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder(); // StringBuilder to build the encrypted text

        // Loop through each character in the input text
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) { // Check if the character is a letter
                // Determine if the character is lowercase or uppercase
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                // Apply Caesar shift and add the shifted character to the encrypted text
                char encryptedChar = (char) ((character - base + shift) % 26 + base);
                encryptedText.append(encryptedChar); // Append the encrypted character
            } else {
                // appending non-letter characters without modifications
                encryptedText.append(character);
            }
        }

        // Return the complete encrypted text
        return encryptedText.toString();
    }

    // Method to decrypt text by reversing the Caesar cipher
    public static String decrypt(String text, int shift) {
        // For decryption, shift backward by using (26 - shift) to reverse the original shift
        return encrypt(text, 26 - (shift % 26));
    }
}

