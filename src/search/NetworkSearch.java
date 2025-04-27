package search;

import algorithm.FlowEdge;
import algorithm.FlowNetwork;

/**
 * Name: Deeno Bajitha
 * Student ID: w1959883
 * Module: 5SENG003W - Data structures and Algorithms
 **/
public interface NetworkSearch
{
    boolean search(FlowNetwork G, int s, int t, boolean[] marked, FlowEdge[] edgeTo );
}
