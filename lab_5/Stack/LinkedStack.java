package Stack;

class Node<T> {
    T data;
    Node<T> previous;

    public Node(T data) {
        this.data = data;
        this.previous = null;
    }
}

public class LinkedStack<T> {
    Node<T> top;

    void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.previous = top;
        top = newNode;
    }

    boolean isEmpty() {
        return top == null;
    }

    T getLastElement() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.previous;
        return data;
    }
}