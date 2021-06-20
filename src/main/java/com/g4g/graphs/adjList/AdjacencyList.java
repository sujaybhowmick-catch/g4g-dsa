package com.g4g.graphs.adjList;

import com.g4g.graphs.BFSAlgorithm;
import com.g4g.graphs.Graph;

import java.util.*;

public class AdjacencyList<T> implements Graph<T> {
    private final Map<T, List<T>> graph;
    private final BFSAlgorithm<T> bfsAlgorithm;

    public AdjacencyList() {
        this.graph = new HashMap<>();
        this.bfsAlgorithm = new BFSAlgorithmImpl(this);
    }

    @Override
    public void addVertex(T s) {
        this.graph.put(s, new LinkedList<>());
        this.bfsAlgorithm.initVertex(s);
    }

    @Override
    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!this.graph.containsKey(source)) {
            this.addVertex(source);
        }
        if (!this.graph.containsKey(destination)) {
            this.addVertex(destination);
        }
        this.graph.get(source).add(destination);
        if(bidirectional) {
            this.graph.get(destination).add(source);
        }
    }

    @Override
    public int getVertexCount() {
        return this.graph.keySet().size();
    }

    @Override
    public int getEdgeCount(boolean bidirectional) {
        int count = 0;
        for (T v : this.graph.keySet()){
            count += this.graph.get(v).size();
        }
        if(bidirectional){
            count = count / 2;
        }
        return count;
    }

    @Override
    public boolean hasVertex(T s) {
        return this.graph.containsKey(s);
    }

    @Override
    public List<T> getAdjacentList(T s) {
        return this.graph.get(s);
    }

    @Override
    public boolean hasEdge(T source, T destination) {
        return this.graph.get(source).contains(destination);
    }

    @Override
    public List<T> search(T source) {
       return  this.bfsAlgorithm.search(source);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T v : this.graph.keySet()) {
            sb.append(v.toString()).append(": ");
            for (T e : this.graph.get(v)) {
                sb.append(e.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
