public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        chainArray = new HashNode[M];
        this.M = M;
    }

    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if(chainArray[index] == null) {
            chainArray[index] = new HashNode<>(key, value);
        } else {
            HashNode<K, V> current = chainArray[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new HashNode<>(key, value);
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode current = chainArray[index];
        while (current != null){
            if (current.key == key) {
                return (V) current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode current = chainArray[index];
        HashNode last = null;
        if (current.next == null) {
            chainArray[index] = null;
            size--;
            return (V) current.value;
        }
        while (current != null) {
            if (current.key == key) {
                if (last == null) {
                    V value = chainArray[index].value;
                    chainArray[index] = null;
                    size--;
                    return value;
                }
                V value = chainArray[index].value;
                last.next = current.next;
                size--;
                return (V) value;
            }
            last = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < size; i++) {
            HashNode current = chainArray[i];
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < size; i++) {
            HashNode current = chainArray[i];
            while (current != null) {
                if (current.value == value) {
                    return (K) current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
}