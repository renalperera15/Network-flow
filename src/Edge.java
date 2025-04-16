public class Edge {
    int from, to, capacity, flow;
    Edge residual;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int remainingCapacity() {
        return capacity - flow;
    }

    public void augment(int bottleNeck) {
        flow += bottleNeck;
        residual.flow -= bottleNeck;
    }
}