import java.util.Scanner;

public class SimAtbashCipher {

    public static String atbashCipher(String text) {
        // Initialize strings with uppercase and lowercase alphabets
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";

        // StringBuilder to store the encoded text
        StringBuilder encodedText = new StringBuilder();

        // Loop through each character in the input text
        for (char c : text.toCharArray()) {
            // Check if the character is an uppercase letter
            if (Character.isUpperCase(c)) {
                // Find the index of the character in the uppercase alphabet
                int index = alphabetUpper.indexOf(c);
                // Append the corresponding Atbash character by reversing the index
                encodedText.append(alphabetUpper.charAt(25 - index));
            }
            // Check if the character is a lowercase letter
            else if (Character.isLowerCase(c)) {
                // Find the index of the character in the lowercase alphabet
                int index = alphabetLower.indexOf(c);
                // Append the corresponding Atbash character by reversing the index
                encodedText.append(alphabetLower.charAt(25 - index));
            }
            // If it's not a letter, keep it as it is
            else {
                encodedText.append(c);
            }
        }

        // Return the final encoded text as a string
        return encodedText.toString();
    }

    public static void main(String[] args) {
        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt/decrypt with Atbash: ");
        String inputText = scanner.nextLine();  // User types in a word or sentence

        // Encrypt/Decrypt the input text using Atbash cipher
        String encodedText = atbashCipher(inputText);

        // Display the encoded/decoded result
        System.out.println("Result: " + encodedText);

        scanner.close();  // Close the scanner
    }
}

