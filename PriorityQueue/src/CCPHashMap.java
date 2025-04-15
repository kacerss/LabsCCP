/**
 * Hash Map Implementation.
 */
public class CCPHashMap {

    // The internal data.
    // We can make a simple linked list with just data Nodes.
    // You can modify this if you want.
    private Node[] store;
    private int size = 0;

    /*
     * Returns the value to which the specified key is mapped.
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or zero if this
     * map contains no mapping for the key.
     */
    public int get(String key) {
        //Calculate the index
        int index = makeHash(key, store.length);

        //Start at the head of the linked list at that bucket
        Node current = store[index];

        //Traverse the linked list
        while (current != null){
            // Check if the current node's key matches the key you're looking for.
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        // If no matching key is found, return 0
        return 0;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is
     * replaced by the specified value. (A map m is said to contain a mapping
     * for a key k if and only if m.containsKey(k) would return true.)
     * @param key - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with key, or zero if there was no
     * mapping for key.
     */
    public int put(String key, int value) {
        // Compute bucket index.
        int index = makeHash(key, store.length);

        //Check first if bucket empty, add a new node.
        if (store[index] == null) {
            store[index] = new Node(key, value);
            size++;
            if (load() > 1) {
                resize();
            }
            return 0;
        }

        Node curr = store[index];


        // Traverse the linked list.
        while (curr.next != null ){
            if (curr.key.equals(key)) {
                // Key exists, update value.
                int oldValue = curr.value;
                curr.value = value;
                return oldValue;
            }
            curr = curr.next;
        }
        if (curr.key.equals(key)) {
            int oldValue = curr.value;
            curr.value = value;
            return oldValue;
        }
        // Key not found, insert a new node at the end.
        curr.next = new Node(key, value);
        size++;
        if (load() > 1){
            resize();
        }
        return 0;
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * More formally, returns true if and only if this map contains a mapping
     * for a key k such that (key==null ? k==null : key.equals(k)).
     * (There can be at most one such mapping.)
     * @param key - key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key
     */
    public boolean containsKey(String key) {
        int index = makeHash(key, store.length);

        Node curr = store[index];

        // Traverse the linked list.
        while (curr != null ){
            if (curr.key.equals(key)) {
                // Key exists, return true
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    /**
     * @return The ratio of elements in the map to the length of the internal store.
     */
    public double load() {
        return (double) this.size / (double) this.store.length;
    }

    /**
     * Resize the map. The map should never exceed a load of 1.
     */
    private void resize() {
        Node[] newStore = new Node[this.store.length * 2];

        // Loop over each bucket in the old store
        for (Node node : store) {
            Node curr = node;
            while (curr != null) {
                // Save next pointer to reassign curr.next
                Node next = curr.next;
                // Rehash the key to get the new index in newStore
                int newIndex = makeHash(curr.key, newStore.length);
                // Insert curr node at the head of the chain in newStore
                curr.next = newStore[newIndex];
                newStore[newIndex] = curr;
                // Move to next node
                curr = next;
            }
        }
        store = newStore;
    }

    /**
     * @param key - The key to be hashed.
     * @param size - The size of the array into which the hash must fit.
     * @return - The hashed value of the key for the given size.
     */
    private int makeHash(String key, int size) {
        int hash = 0;
        int prime = 31; // Prime number multiplier
        for (int i = 0; i < key.length(); i++){
            // Multiply the current hash by the prime and add character value
            hash = hash * prime + key.charAt(i);
        }
        return Math.abs(hash) % size;
    }

    public CCPHashMap() {
        // Start with 4 items.
        this.store  = new Node[4];
    }

    /**
     * @return all the keys of the map as an array.
     */
    public String[] keys() {
        String[] s = new String[this.size()];
        int index = 0; // Keep track of index in the array

        //Loop through each bucket in the store array.
        for (Node node : store) {
            // Traverse the linked list at this bucket
            while (node != null) {
                s[index] = node.key;
                index++;
                node = node.next;
            }
        }
        return s;
    }

    private static class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        // Feel free to add constructors or methods as desired.
    }

}
