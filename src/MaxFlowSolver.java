import java.util.*;

public class MaxFlowSolver {
    private final FlowNetwork network;
    private final int source, sink;
    private int maxFlow = 0;
    private List<String> steps = new ArrayList<>();

    public MaxFlowSolver(FlowNetwork network, int source, int sink) {
        this.network = network;
        this.source = source;
        this.sink = sink;
    }

    public int findMaxFlow() {
        while (true) {
            Edge[] parent = new Edge[network.n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (Edge e : network.getGraph()[u]) {
                    if (parent[e.to] == null && e.to != source && e.remainingCapacity() > 0) {
                        parent[e.to] = e;
                        queue.add(e.to);
                    }
                }
            }

            if (parent[sink] == null) break;

            int bottleNeck = Integer.MAX_VALUE;
            for (Edge e = parent[sink]; e != null; e = parent[e.from]) {
                bottleNeck = Math.min(bottleNeck, e.remainingCapacity());
            }

            for (Edge e = parent[sink]; e != null; e = parent[e.from]) {
                e.augment(bottleNeck);
            }

            maxFlow += bottleNeck;
            steps.add("Augmented path with bottleneck = " + bottleNeck + ", total flow = " + maxFlow);
        }
        return maxFlow;
    }

    public List<String> getSteps() {
        return steps;
    }
}
