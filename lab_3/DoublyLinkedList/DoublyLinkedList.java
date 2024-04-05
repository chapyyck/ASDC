package DoublyLinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node firstNode;
    Node lastNode;

    public DoublyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    void insertAfter(Node node, int value) {
        Node newNode = new Node(value);
        if (node == null) {
            if (firstNode == null) { // list пуст
                firstNode = newNode;
                lastNode = newNode;
            }
            else { // вставка после первого нода
                newNode.next = firstNode.next;
                if (firstNode.next != null) {
                    firstNode.next.prev = newNode;
                }
                firstNode.next = newNode;
                newNode.prev = firstNode;
                if (firstNode == lastNode) {
                    lastNode = newNode;
                }
            }
        }
        else {
            newNode.next = node.next;
            if (node.next != null) {
                node.next.prev = newNode;
            }
            node.next = newNode;
            newNode.prev = node;
            if (node == lastNode) {
                lastNode = newNode;
            }
        }
    }

    void insertBefore(Node node, int value) {
        Node newNode = new Node(value);
        if (node == null) {
            if (lastNode == null) {
                lastNode = newNode;
                firstNode = newNode;
            }
            else { // вставка перед последним нодом
                newNode.prev = lastNode.prev;
                if (lastNode.prev != null) {
                    lastNode.prev.next = newNode;
                }
                lastNode.prev = newNode;
                newNode.next = lastNode;
                if (firstNode == lastNode) {
                    firstNode = newNode;
                }
            }
        }
        else {
            newNode.prev = node.prev;
            if (node.prev != null) {
                node.prev.next = newNode;
            }
            node.prev = newNode;
            newNode.next = node;
            if (node == firstNode) {
                firstNode = newNode;
            }
        }
    }

    Node find(int value) {
        Node currentNode = firstNode;
        while (currentNode != null && currentNode.data != value) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    boolean remove(Node node) {
        if (node == null) {
            return false;
        }
        if (node == firstNode) {
            firstNode = node.next;
        }
        if (node == lastNode) {
            lastNode = node.prev;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAfter(list.lastNode, 10);
        list.insertAfter(list.lastNode, 20);

        list.insertBefore(list.lastNode, 123);
        list.insertBefore(list.lastNode, 456);

        Node found = list.find(20);
        if (found != null) {
            System.out.println("Найденный нод: " + found.data);
        }
        else {
            System.out.println("Нод с указанным значением не найден");
        }

        boolean to_remove = list.remove(found);
        if (to_remove) {
            System.out.println("Нод был удален");
        }
        else {
            System.out.println("Нод не был удален");
        }
    }
}