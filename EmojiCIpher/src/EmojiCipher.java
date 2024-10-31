import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmojiCipher {

    // Map to hold the letter-to-emoji substitution
    private static final Map<Character, String> emojiMap = new HashMap<>();

    // Static block to initialize the emoji map
    static {
        emojiMap.put('A', "🍎");
        emojiMap.put('B', "🍌");
        emojiMap.put('C', "🌊");
        emojiMap.put('D', "🍩");
        emojiMap.put('E', "🥚");
        emojiMap.put('F', "🐸");
        emojiMap.put('G', "🍇");
        emojiMap.put('H', "🏠");
        emojiMap.put('I', "🍦");
        emojiMap.put('J', "🤹");
        emojiMap.put('K', "🔑");
        emojiMap.put('L', "🍋");
        emojiMap.put('M', "🌕");
        emojiMap.put('N', "🍜");
        emojiMap.put('O', "🦉");
        emojiMap.put('P', "🍕");
        emojiMap.put('Q', "👑");
        emojiMap.put('R', "🌈");
        emojiMap.put('S', "🐍");
        emojiMap.put('T', "🌮");
        emojiMap.put('U', "☂️");
        emojiMap.put('V', "🍇");
        emojiMap.put('W', "🌊");
        emojiMap.put('X', "❌");
        emojiMap.put('Y', "🌱");
        emojiMap.put('Z', "⚡");
    }

    public static String emojiCipher(String text) {
        StringBuilder encodedText = new StringBuilder();

        for (char c : text.toUpperCase().toCharArray()) {
            // Substitute each letter with an emoji if it exists in the map
            if (emojiMap.containsKey(c)) {
                encodedText.append(emojiMap.get(c));
            } else {
                // Keep non-alphabet characters as they are
                encodedText.append(c);
            }
        }

        return encodedText.toString();
    }

    public static void main(String[] args) {
        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encode with emojis: ");
        String inputText = scanner.nextLine();  // User input text

        // Encode the input text using the emoji cipher
        String encodedText = emojiCipher(inputText);

        // Display the encoded result
        System.out.println("Encoded text: " + encodedText);

        scanner.close();  // Close the scanner
    }
}

