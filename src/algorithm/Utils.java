package algorithm; /**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
import java.io.*;
import java.util.*;

public class Utils {

    public static FlowNetwork loadNetworkFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int V = Integer.parseInt(br.readLine().trim());
        FlowNetwork network = new FlowNetwork(V);

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 3) continue;
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            network.addEdge(new FlowEdge(from, to, capacity));
        }

        br.close();
        return network;
    }

    public static List<File> getBenchmarkFiles(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null) return new ArrayList<>();
        return Arrays.asList(files);
    }
}
