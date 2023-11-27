package com.example.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.example.datastructures.Edge;
import com.example.datastructures.UnionFind;
import com.example.datastructures.WeightedGraph;

public class KruskalsMST {

    private WeightedGraph graph;
    private UnionFind unionFind;
    public KruskalsMST(WeightedGraph graph) {
        this.graph = graph;
        this.unionFind=new UnionFind(graph.size());
    }

    public List<Edge> getMST() {
        List<Edge> list = new ArrayList<>();
        PriorityQueue<Edge> q = new PriorityQueue<>(graph.getEdges());
        while (!q.isEmpty()){
            Edge minEdge=q.remove(); 
            if(!unionFind.connected(minEdge.getFrom(), minEdge.getTo())){
                list.add(minEdge);
                unionFind.union(minEdge.getFrom(), minEdge.getTo()); 
            }
        }
        return list;
    }
}

