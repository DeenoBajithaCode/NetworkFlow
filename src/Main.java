/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
**/
import algorithm.FlowNetwork;
import algorithm.MaxFlowSolver;
import algorithm.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static algorithm.SearchType.BFS;

public class Main {
    public static void main(String[] args) throws IOException {
        String folderPath = "benchmarks"; // adjust if needed
        List<File> benchmarkFiles = Utils.getBenchmarkFiles(folderPath);

        FileWriter writer = new FileWriter("results.csv");
        writer.write("Filename,MaxFlow,TimeMillis\n");

        for (File file : benchmarkFiles) {
            System.out.println("Processing: " + file.getName());

            FlowNetwork network = Utils.loadNetworkFromFile(file);
            MaxFlowSolver solver = new MaxFlowSolver();

            long start = System.currentTimeMillis();
            int maxFlow = solver.computeMaxFlow(network, 0, network.size() - 1, BFS);
            long end = System.currentTimeMillis();

            long duration = end - start;

            System.out.printf("→ %s | Max Flow: %d | Time: %d ms%n", file.getName(), maxFlow, duration);
            writer.write(String.format("%s,%d,%d\n", file.getName(), maxFlow, duration));
        }

        writer.close();
        System.out.println("Results saved to results.csv");
    }
}
