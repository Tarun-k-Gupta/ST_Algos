package com.example.graphs;

import java.util.HashSet;
import java.util.Set;

import com.example.datastructures.Graph;

/**
 * To find if the given graph has cycle , We need to maintain one additional set of exited vertices and do dfs.
 * In any step if iteration if a vertex is already in visited set and yet not exited from recusion stack, then
 * we can return true. We can optimize using one array with 3 different values.
 */
public class CycleDetection {
    protected Graph graph;
    protected Set<Integer> visited;
    protected Set<Integer> exited;

    public CycleDetection(Graph graph) {
        this.graph = graph;
        visited = new HashSet<>();
        exited = new HashSet<>();
    }

    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> exited = new HashSet<>();
    
        for (Integer vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                if (dfs(vertex, visited, exited))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(Integer start, Set<Integer> visited, Set<Integer> exited) {
        visited.add(start);
    
        for (Integer neighbor : graph.getNeighbors(start)) {
            if (visited.contains(neighbor) && !exited.contains(neighbor))
                return true;
    
            if (!visited.contains(neighbor) && dfs(neighbor, visited, exited))
                return true;
        }
        exited.add(start);
        return false;
    }
    
}
