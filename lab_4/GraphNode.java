import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphNode {
    int value;
    boolean visited;
    ArrayList<GraphNode> neighbors;

    GraphNode(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
        this.visited = false;
    }

    void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }

    int sumOfNeighborValues() {
        int sum = 0;
        for (GraphNode neighbor : this.neighbors) {
            sum += neighbor.value;
        }
        return sum;
    }

    void DFS() {
        this.visited = true;
        System.out.print(this.value + " ");

        for (GraphNode neighbor : this.neighbors) {
            if (!neighbor.visited) {
                neighbor.DFS();
            }
        }
    }

    void BFS() {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(this);
        this.visited = true;

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            System.out.print(current.value + " ");

            for (GraphNode neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }
}