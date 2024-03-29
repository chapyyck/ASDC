package LinkedLists_Queue;

class Node {
    int data;
    Node next;
    private static int totalNodes = 0;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class FindNodeResult {
    Node currentNode, previousNode;
    FindNodeResult(Node currentNode, Node previousNode) {
        this.currentNode = currentNode;
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        if (previousNode != null) {
            return "Значение currentNode = " + currentNode.data +
                    ", Значение previousNode = " + previousNode.data;
        }
        else {
            return "Значение currentNode = " + currentNode.data +
                    ", previousNode не существует";
        }
    }
}

public class SinglyLinkedList {

    Node firstNode, lastNode;
    public SinglyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public void addNodeToEnd(int value) {
        Node newNode = new Node(value);

        if (lastNode != null) {
            lastNode.next = newNode;
        }

        lastNode = newNode;

        if (firstNode == null) {
            firstNode = newNode;
        }
    }

    FindNodeResult find(int value) {
        Node current = firstNode;
        Node previous = null;

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        return new FindNodeResult(current, previous);
    }

    public boolean removeAfter(FindNodeResult node) {
        if (node == null || node.currentNode == null || node.currentNode.next == null) {
            return false;
        }

        Node nodeToDelete = node.currentNode.next;
        node.currentNode.next = nodeToDelete.next;

        if (nodeToDelete == lastNode) {
            lastNode = node.currentNode;
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.addNodeToEnd(10);
        list1.addNodeToEnd(20);
        list1.addNodeToEnd(30);
        list1.addNodeToEnd(40);
        list1.addNodeToEnd(50);

        FindNodeResult f1 = list1.find(10);
        if (f1.currentNode == null){
            System.out.println("\nЗапрашиваемый Нод не найден");
        }
        else {
            System.out.println(f1.toString());
        }

        boolean isDeleted = list1.removeAfter(f1);

        if (isDeleted) {
            System.out.println("\nЗапрашиваемый Нод был удален");
        }
        else {
            System.out.println("\nЗапрашиваемый Нод не был удален");
        }
    }
}