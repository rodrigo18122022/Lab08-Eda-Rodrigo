import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree<T> {
    private HuffmanNode<T> root;

    public HuffmanTree(Map<T, Integer> frequencies) {
        PriorityQueue<HuffmanNode<T>> priorityQueue = new PriorityQueue<>();
        
        for (Map.Entry<T, Integer> entry : frequencies.entrySet()) {
            priorityQueue.add(new HuffmanNode<>(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode<T> left = priorityQueue.poll();
            HuffmanNode<T> right = priorityQueue.poll();
            HuffmanNode<T> newNode = new HuffmanNode<>(null, left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }

        this.root = priorityQueue.poll();
    }

    public Map<T, String> generateCodes() {
        Map<T, String> codes = new HashMap<>();
        generateCodes(this.root, "", codes);
        return codes;
    }

    private void generateCodes(HuffmanNode<T> node, String code, Map<T, String> codes) {
        if (node != null) {
            if (node.character != null) {
                codes.put(node.character, code);
            }
            generateCodes(node.left, code + "0", codes);
            generateCodes(node.right, code + "1", codes);
        }
    }

    public HuffmanNode<T> getRoot() {
        return root;
    }
}
