public class HuffmanNode<T> implements Comparable<HuffmanNode<T>> {
    T character;
    int frequency;
    HuffmanNode<T> left;
    HuffmanNode<T> right;

    public HuffmanNode(T character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(HuffmanNode<T> node) {
        return this.frequency - node.frequency;
    }
}
