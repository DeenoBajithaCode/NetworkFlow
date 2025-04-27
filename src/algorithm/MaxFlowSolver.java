package algorithm; /**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
import search.NetworkSearch;
import search.NetworkSearchBFS;
import search.NetworkSearchDFS;

import java.util.LinkedList;
import java.util.Queue;

import static algorithm.SearchType.BFS;
import static algorithm.SearchType.DFS;

public class MaxFlowSolver {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private int maxFlow;

    public Integer computeMaxFlow(FlowNetwork network, int s, int t, Enum<?> type) {
        maxFlow = 0;
        NetworkSearch networkSearch;
        if( type == BFS )
        {
            networkSearch = new NetworkSearchBFS();
        }
        else if( type == DFS )
        {
            networkSearch = new NetworkSearchDFS();
        }
        else
        {
            return null;
        }
        marked = new boolean[network.size()];
        edgeTo = new FlowEdge[network.size()];

        while (networkSearch.search(network, s, t, marked, edgeTo)) {
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
}
