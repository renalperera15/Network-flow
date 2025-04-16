import java.util.*;

public class FlowNetwork {
    int n;
    List<List<Edge>> graph;

    public FlowNetwork(int n) {
        this.n = n;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
    }

    public void addEdge(int from, int to, int capacity) {
        Edge e1 = new Edge(from, to, capacity);
        Edge e2 = new Edge(to, from, 0);
        e1.residual = e2;
        e2.residual = e1;
        graph.get(from).add(e1);
        graph.get(to).add(e2);
    }

    public List<List<Edge>> getGraph() {
        return graph;
    }
}