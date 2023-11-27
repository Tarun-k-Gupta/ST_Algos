package com.example.graphs;

import java.util.HashMap;
import java.util.Map;

import com.example.datastructures.Edge;
import com.example.datastructures.WeightedGraph;

/**
* This Bellman Ford shortest path algorithm. It works with negative edges and if there negative cycle
 * the algorithm reports. Time complexity is O(V*E) if E is V^2 , we can say that O(V^3).
 * This is slower than Dijkstra shortest path algorithm which works for only non-negative edges in O(VLogV)
 * with Fibonacci heap.
* */
public class BellmanFord {
    WeightedGraph graph;
    public Map<Integer, Double> distance;

    public BellmanFord(WeightedGraph graph) {
        this.graph = graph;
        distance = new HashMap<>();
    }

    public boolean shortestPath(Integer source) {
        for (Integer vertex : graph.getVertices()) {
            if (source.equals(vertex)) distance.put(vertex, 0d);
            else distance.put(vertex, Double.POSITIVE_INFINITY);
        }

        int verticesCount = graph.size();
        for (int i = 0; i < verticesCount - 1; i++) {
            for (Integer vertex : graph.getVertices()) {
                if (distance.get(vertex) == Double.POSITIVE_INFINITY) continue;
                for (Edge edge : graph.getEdges(vertex)) {
                    double newPath = distance.get(edge.getFrom()) + edge.getWeight();
                    if (distance.get(edge.getTo()) > newPath) {
                        distance.put(edge.getTo(), newPath);
                    }
                }
            }
        }

        for (Integer vertex : graph.getVertices()) {
            for (Edge edge : graph.getEdges(vertex)) {
                double newPath = distance.get(edge.getFrom()) + edge.getWeight();
                if (distance.get(edge.getFrom()) != Double.POSITIVE_INFINITY &&
                    distance.get(edge.getTo()) > newPath) {
                    System.out.println("Negative Cycle found");
                    return false; // Exit after detecting the negative cycle
                }
            }
        }
        System.out.println("No Negative Cycle found");
        return true;
    }
}