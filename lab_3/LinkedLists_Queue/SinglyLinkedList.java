package LinkedLists_Queue;

class Node {
    int data, ID;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.ID = 1;
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

    private Node firstNode, lastNode;
    public SinglyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public void addNodeToEnd(int value) {
        Node newNode = new Node(value);

        if (lastNode != null) {
            newNode.ID = lastNode.ID + 1;
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
    public boolean removeAfter(int targetID) {
        Node current = firstNode;
        Node previous = null;

        // Если хотим удалить самый первый узел.
        if (targetID == 0){
            firstNode = current.next;
            return true;
        }

        while (current != null && current.ID != targetID) {
            previous = current;
            current = current.next;
        }

        if (current != null && current.next != null) {
            // Удаляем узел после узла с заданным ID
            current.next = current.next.next;

            // Если удалили последний узел, обновляем lastNode
            if (current.next == null) {
                lastNode = current;
            }
            return true;
        }
        return false;
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


        boolean isDeleted = list1.removeAfter(3); // Удаляем с ID: 4

        if (isDeleted) {
            System.out.println("\nЗапрашиваемый Нод был удален");
        }
        else {
            System.out.println("\nЗапрашиваемый Нод не был удален");
        }


        FindNodeResult f2 = list1.find(40); // Пытаемся найти с ID: 4
        if (f2.currentNode == null){
            System.out.println("\nЗапрашиваемый Нод не найден");
        }
        else {
            System.out.println(f2.toString());
        }
    }
}


