public class Main {
    public static void main(String[] args) throws Exception {
        FlowNetwork network = NetworkParser.parseFromFile("input/network.txt");
        int source = 0;
        int sink = network.n - 1;

        MaxFlowSolver solver = new MaxFlowSolver(network, source, sink);
        int maxFlow = solver.findMaxFlow();
        System.out.println("Maximum Flow: " + maxFlow);

        for (String step : solver.getSteps()) {
            System.out.println(step);
        }
    }
}
