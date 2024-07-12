import java.util.Map;

public class HuffmanCompressor {
    public static <T> String compress(String text, Map<T, String> huffmanCodes) {
        StringBuilder compressed = new StringBuilder();
        try {
            for (char c : text.toCharArray()) {
                compressed.append(huffmanCodes.get((T) Character.valueOf(c)));
            }
            return compressed.toString();
        }
        catch(Exception e) {
            System.out.println("Error - " + e);
            return null;
        }
        
    }

    public static <T> String decompress(String compressedText, HuffmanNode<T> root) {
        StringBuilder decompressed = new StringBuilder();
        HuffmanNode<T> currentNode = root;
        for (char bit : compressedText.toCharArray()) {
            currentNode = bit == '0' ? currentNode.left : currentNode.right;
            if (currentNode.left == null && currentNode.right == null) {
                decompressed.append(currentNode.character);
                currentNode = root;
            }
        }
        return decompressed.toString();
    }
}
