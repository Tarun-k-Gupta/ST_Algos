package com.example.graphs;

import java.util.HashMap;
import java.util.Map;

import com.example.datastructures.Graph;

public class IsBipartite extends BFS {

    private Map<Integer, Boolean> color = new HashMap<>();

    public IsBipartite(Graph graph) {
        super(graph);
    }
    public boolean isBipartite() {
        for (Integer vertex : graph.getVertices()) {
            if (!color.containsKey(vertex) && !bfs(vertex)) {
                return false; 
            }
        }
        return true; 
    }

    private boolean bfs(Integer start) {
        queue.clear();
        queue.add(start);
        color.put(start, true); 

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();

            for (Integer neighbor : graph.getNeighbors(currentVertex)) {
                if (!color.containsKey(neighbor)) {
                    color.put(neighbor, !color.get(currentVertex)); // Color the neighbor with the opposite color
                    queue.add(neighbor);
                } else if (color.get(neighbor) == color.get(currentVertex)) {
                    return false; 
                }
            }
        }
        return true; 
    }
}
