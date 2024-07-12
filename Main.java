import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "ata la jaca a la estaca";
        
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        HuffmanTree<Character> huffmanTree = new HuffmanTree<>(frequencies);
        
        Map<Character, String> huffmanCodes = huffmanTree.generateCodes();
        
        System.out.println("Huffman Codigo: " + huffmanCodes);

        String compressedText = HuffmanCompressor.compress(text, huffmanCodes);
        System.out.println("Texto comprimido: " + compressedText);

        String decompressedText = HuffmanCompressor.decompress(compressedText, huffmanTree.getRoot());
        System.out.println("Texto descomprimido: " + decompressedText);
    }
}
