import java.io.*;

public class NetworkParser {
    public static FlowNetwork parseFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int n = Integer.parseInt(reader.readLine());
            FlowNetwork network = new FlowNetwork(n);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);
                int capacity = Integer.parseInt(parts[2]);
                network.addEdge(from, to, capacity);
            }
            return network;
        }
    }
}
