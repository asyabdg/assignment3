public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V data;
        private Node left, right;
        public Node(K key, V data) {
            this.key = key;
            this.data = data;
            left = right = null;
        }
    }

    public void put(K key, V data) {
        root = put(root, key, data);
    }

    public Node put(Node current, K key, V data) {
        if (current == null) {
            return new Node(key, data);
        }
        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            current.left = put(current.left, key, data);
        } else if (cmp > 0) {
            current.right = put(current.right, key, data);
        }
        return current;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int k = key.compareTo(node.key);
        if (k < 0) {
            return get(node.left, key);
        } else if (k > 0) {
            return get(node.right, key);
        }
        return node.data;
    }


    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }
        int cmp = current.key.compareTo(key);

        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            Node smallestValue = findSmallestValue(current.left);
            current.data = smallestValue.data;
            current.key = smallestValue.key;
            current.left = delete(current.left, smallestValue.key);
        }
        return current;
    }

    private Node findSmallestValue(Node node) {
        return node.right == null ? node: findSmallestValue(node.right);
    }
    public Iterable<K> iterator() { return null; }
}git add .