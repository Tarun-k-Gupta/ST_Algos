package com.example.graphs;

import java.util.*;

import com.example.datastructures.Edge;
import com.example.datastructures.WeightedGraph;
import com.example.datastructures.UnionFind;

public class PrimsMST {

    private WeightedGraph graph;
    private UnionFind unionFind;
    public PrimsMST(WeightedGraph graph) {
        this.graph = graph;
        this.unionFind=new UnionFind(graph.size());
    }

    public List<Edge> getMST() {
        List<Edge> list = new ArrayList<>();
        PriorityQueue<Edge> q = new PriorityQueue<>(graph.getEdges());
        while (!q.isEmpty()){
            Edge minEdge=q.remove(); // remove min Edge and check if both vertices of this edge is connected
            if(!unionFind.connected(minEdge.getFrom(), minEdge.getTo())){
                list.add(minEdge);
                unionFind.union(minEdge.getFrom(), minEdge.getTo()); // make both vertices one component
            }
        }
        return list;
    }
}
