/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
public class FlowEdge {
    public final int from, to;
    public final int capacity;
    public int flow;

    public FlowEdge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int residualCapacityTo(int vertex) {
        if (vertex == to) return capacity - flow;
        else if (vertex == from) return flow;
        else throw new IllegalArgumentException();
    }

    public void addResidualFlowTo(int vertex, int delta) {
        if (vertex == to) flow += delta;
        else if (vertex == from) flow -= delta;
        else throw new IllegalArgumentException();
    }
}
