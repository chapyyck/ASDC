package Queue;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue<T> {
    Node<T> first;
    Node<T> last;

    boolean isEmpty() {
        return first == null;
    }

    void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
    }

    Node<T> getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first;
    }

    Node<T> getAndRemoveFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = first;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return temp;
    }
}