package com.example.graphs;

import java.util.Set;

import com.example.datastructures.Graph;

public class IsConnected extends DFS {
    private Graph graph;

    public IsConnected(Graph graph) {
        super(graph);
        this.graph = graph;
    }

    public boolean isConnected() {
        search(graph.getVertices().iterator().next()); // Start DFS from any random vertex

        Set<Integer> graphVertices = graph.getVertices();

        return graphVertices.size() == visited.size(); // Return true if all vertices are visited
    }
}

