package SinglyLinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
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

    SinglyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    void addNodeToEnd(int value) {
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

    boolean removeAfter(Node node) {
        if (node == null) {
            if (firstNode != null) {
                Node nodeToDelete = firstNode;
                firstNode = firstNode.next;

                if (nodeToDelete == lastNode) {
                    lastNode = null;
                }
                System.out.println("\nБыл удален первый нод списка");
                return true;
            }
            System.out.println("\nСписок пуст");
            return false;
        }
        else if (node.next != null) {
            Node nodeToDelete = node.next;
            node.next = nodeToDelete.next;

            if (nodeToDelete == lastNode) {
                lastNode = node;
            }
            System.out.println("\nЗапрашиваемый Нод был удален");
            return true;
        }
        System.out.println("\nОшибка. Запрашиваемый нод - последний");
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addNodeToEnd(10);
        list.addNodeToEnd(20);
        list.addNodeToEnd(30);

        FindNodeResult f1 = list.find(20);
        if (f1.currentNode == null){
            System.out.println("\nЗапрашиваемый Нод не найден");
        }
        else {
            System.out.println(f1.toString());
        }

        list.removeAfter(f1.currentNode);
    }
}