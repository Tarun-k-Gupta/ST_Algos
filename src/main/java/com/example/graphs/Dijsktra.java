package com.example.graphs;


import java.util.*;

import com.example.datastructures.Edge;
import com.example.datastructures.WeightedGraph;

public class Dijsktra {

    public Map<Integer, Double> distance;
    private WeightedGraph graph;

    public Dijsktra(WeightedGraph graph) {
        this.graph = graph;
        distance = new HashMap<>();
    }

    public void shortestPath(Integer source) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer vertex : graph.getVertices()) {
            distance.put(vertex, Double.POSITIVE_INFINITY);
        }
        distance.put(source, 0d);
        queue.add(new Node(source, 0d));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (visited.contains(currentNode.label)) {
                continue;
            }
            visited.add(currentNode.label);

            for (Edge edge : graph.getEdges()) {
                if (edge.getFrom().equals(currentNode.label)) {
                    double newPath = distance.get(edge.getFrom()) + edge.getWeight();

                    if (newPath < distance.get(edge.getTo())) {
                        distance.put(edge.getTo(), newPath);
                        queue.add(new Node(edge.getTo(), newPath));
                    }
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        Integer label;
        Double weight;

        Node(Integer label, Double weight) {
            this.label = label;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.weight, other.weight);
        }
    }
}