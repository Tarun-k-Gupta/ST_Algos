package com.example.datastructures;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph implements Graph{
    Set<Edge> edges = new HashSet<>();
    private boolean Undirected = false;
    private Map<Integer, Set<Edge>> map = new HashMap<>();
    private Map<Integer, Set<Integer>> vertexMap = new HashMap<>();


    public WeightedGraph(boolean Undirected) {
        this.Undirected = Undirected;
    }

    @Override
    public boolean addVertex(Integer v) {
        map.put(v, new HashSet<Edge>());
        vertexMap.put(v, new HashSet<Integer>());
        return true;
    }

    @Override
    public boolean addEdge(Integer v1, Integer v2, Double weight) {
        if(!map.containsKey(v1) || !map.containsKey(v2))return false;
        
        Edge edge = new Edge(v1, v2, weight);

        map.get(v1).add(edge);
        vertexMap.get(v1).add(v2);
        edges.add(edge);

        if(Undirected) {
            Edge edge2 = new Edge(v2, v1, weight);
            vertexMap.get(v2).add(v1);
            map.get(v2).add(edge2);
            edges.add(edge2);
        }

        return true;
    }

    @Override
    public boolean removeVertex(Integer v) {
        return true;
    }

    @Override
    public Double addEdge(Integer v1, Integer v2) {
        return 0d;
    }

    @Override
    public boolean removeEdge(Integer v1, Integer v2) {
        if (!vertexMap.containsKey(v1)) return false;
        if (!vertexMap.containsKey(v2)) return false;
        if (!vertexMap.get(v1).contains(v2)) return false;
        vertexMap.get(v1).remove(v2);
        return true;
    }

    @Override
    public Set<Integer> getNeighbors(Integer ver) {
        return vertexMap.get(ver);
    }

    @Override
    public Set<Integer> getVertices() {
        return new HashSet<>(map.keySet());
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Edge> getEdges(Integer ver) {
        return map.get(ver);
    }

    public int size() {
        return map.size();
    }
}
