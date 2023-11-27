package com.example.graphs;

import java.util.*;

import com.example.datastructures.Graph;

public class DFS {
    protected Graph graph;
    protected Set<Integer> visited;
    protected List<Integer> path;

    public DFS(Graph graph) {
        this.graph = graph;
        visited = new HashSet<>();
        path = new LinkedList<>();
    }

    public void search(Integer source) {

        visited.add(source);
        processVertex(source);

        for (Integer neighbor : graph.getNeighbors(source))
            if (!visited.contains(neighbor)) {
                search(neighbor);
            }
    }

    public void processVertex(Integer source) {
        path.add(source);
    }

    public List<Integer> getPathFrom(Integer source) {

        if (source == null || !graph.getVertices().contains(source))
            return null;
        search(source);
        return path;
    }


}
