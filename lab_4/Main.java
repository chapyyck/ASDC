public class Main {
    public static void main(String[] args) {
        GraphNode vertex1 = new GraphNode(10);
        GraphNode vertex2 = new GraphNode(20);
        GraphNode vertex3 = new GraphNode(30);
        GraphNode vertex4 = new GraphNode(40);

        vertex1.addNeighbor(vertex2);
        vertex1.addNeighbor(vertex3);
        vertex1.addNeighbor(vertex4);

        vertex2.addNeighbor(vertex3);

        vertex3.addNeighbor(vertex4);

        vertex4.addNeighbor(vertex1);

        System.out.println("Сумма значений соседних вершин для вершины vertex3: " + vertex1.sumOfNeighborValues());

        System.out.println("Проход в глубину методом DFS:");
        vertex3.DFS();

//        Закомментил т.к. флаги меняются после прохода DFS
//        System.out.println("Проход в ширину методом BFS:");
//        vertex4.BFS();
    }
}