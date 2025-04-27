package search;

import algorithm.FlowEdge;
import algorithm.FlowNetwork;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
public class NetworkSearchBFS implements NetworkSearch
{
    @Override
    public boolean search(FlowNetwork G, int s, int t, boolean[] marked, FlowEdge[] edgeTo ) {
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
