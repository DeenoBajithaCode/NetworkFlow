/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
public class FlowNetwork {
    private final int V;
    private final List<FlowEdge>[] adj;

    public FlowNetwork(int V) {
        this.V = V;
        adj = (List<FlowEdge>[]) new List[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
    }

    public void addEdge(FlowEdge e) {
        adj[e.from].add(e);
        adj[e.to].add(e); // Add for residual graph handling
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public int size() {
        return V;
    }
}
