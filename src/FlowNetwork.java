import java.util.*;

public class FlowNetwork {
    int n;
    List<Edge>[] graph;

    public FlowNetwork(int n) {
        this.n = n;
        graph = (List<Edge>[]) new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
    }

    public void addEdge(int from, int to, int capacity) {
        Edge e1 = new Edge(from, to, capacity);
        Edge e2 = new Edge(to, from, 0);
        e1.residual = e2;
        e2.residual = e1;
        graph[from].add(e1);
        graph[to].add(e2);
    }

    public List<Edge>[] getGraph() {
        return graph;
    }
}