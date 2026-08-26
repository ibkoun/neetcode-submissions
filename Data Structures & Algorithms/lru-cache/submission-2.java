class LRUCache {
    private final int capacity;
    private Node head;
    private Node tail;
    private final Map<Integer, Node> lookup;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookup = new HashMap<>();
    }

    public int get(int key) {
        if (lookup.containsKey(key)) {
            var node = lookup.get(key);
            update(node);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!lookup.isEmpty()) {
            if (lookup.containsKey(key)) {
                var node = lookup.get(key);
                node.setValue(value); // Update the value of the node
                update(node);
            } else {
                var node = new Node(key, value);
                lookup.put(key, node);
                append(node);

                // Remove the head if the capacity is exceeded
                if (lookup.size() > capacity) {
                    lookup.remove(head.getKey());
                    head = head.getNext();
                    head.setPrevious(null);
                }
            }
        } else {
            // Initialization
            var node = new Node(key, value);
            lookup.put(key, node);
            head = node;
            tail = node;
        }
    }

    private void update(Node node) {
        // There is nothing to do if there is only a single node to update
        if (lookup.size() > 1) {
            if (node.getKey() != head.getKey() && node.getKey() != tail.getKey()) {
                // If the current node is neither the head nor the tail, connect the previous node to the next one
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                append(node);
            } else if (node.getKey() == head.getKey()) {
                // If the current node is the head, designate the next node as the head
                head = head.getNext();
                head.setPrevious(null);
                append(node);
            }
        }
    }

    // Add a node to the end of the linked list
    private void append(Node node) {
        node.setPrevious(tail);
        node.setNext(null);
        tail.setNext(node);
        tail = tail.getNext();
    }
}

class Node {
    private Node previous;
    private Node next;
    private int key;
    private int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node node) {
        previous = node;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
