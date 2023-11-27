package com.example.graphs;

import com.example.datastructures.Graph;
import java.util.*;


public class TopologicalSorting extends DFS {
    List<Integer> list;

    public TopologicalSorting(Graph graph) {
        super(graph);
        list = new ArrayList<>();
    }

    public List<Integer> topSort() {

        CycleDetection detector = new CycleDetection(graph);
        if(detector.hasCycle()) return null;

        Set<Integer> visited = new HashSet<>();

        for (Integer vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited);
            }
        }

        Collections.reverse(list);
        return list;
    }

    private void dfs(Integer vertex, Set<Integer> visited) {
        visited.add(vertex);

        for (Integer neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }

        list.add(vertex);
    }
}
