/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
import java.util.LinkedList;
import java.util.Queue;

public class MaxFlowSolver {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private int maxFlow;

    public int computeMaxFlow(FlowNetwork network, int s, int t) {
        maxFlow = 0;
        while (hasAugmentingPath(network, s, t)) {
            int bottle = Integer.MAX_VALUE;
            for (int v = t; v != s; v = edgeTo[v].from) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            for (int v = t; v != s; v = edgeTo[v].from) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            maxFlow += bottle;
        }
        return maxFlow;
    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        marked = new boolean[G.size()];
        edgeTo = new FlowEdge[G.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (FlowEdge e : G.adj(v)) {
                int w = (e.from == v) ? e.to : e.from;
                if (!marked[w] && e.residualCapacityTo(w) > 0) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
        return marked[t];
    }
}
