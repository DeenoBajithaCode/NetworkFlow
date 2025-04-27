package search;

import algorithm.FlowEdge;
import algorithm.FlowNetwork;

import java.util.Stack;

/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
public class NetworkSearchDFS implements NetworkSearch
{
    @Override
    public boolean search(FlowNetwork flowNetwork, int s, int t, boolean[] marked, FlowEdge[] edgeTo) {
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        marked[s] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();

            for (FlowEdge e : flowNetwork.adj(v)) {
                int w = (e.from == v) ? e.to : e.from;
                if (!marked[w] && e.residualCapacityTo(w) > 0) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    stack.push(w);
                }
            }
        }
        return marked[t];
    }
}
