public class BSTTest {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        bst.put(2, 2);
        bst.put(6, 6);
        bst.inOrder();
        bst.delete(3);
        bst.inOrder();
        System.out.println(bst.get(3));
        System.out.println(bst.get(2));
    }
}