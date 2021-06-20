package com.g4g.graphs.adjList;

import com.g4g.graphs.BFSAlgorithm;
import com.g4g.graphs.Graph;

import java.util.*;

public class BFSAlgorithmImpl<T> implements BFSAlgorithm<T> {
    private final Map<T, Boolean> visited;
    private final Queue<T> queue;
    private final Graph<T> graph;

    public BFSAlgorithmImpl(Graph<T> graph) {
        this.visited = new HashMap<>();
        this.queue = new LinkedList<>();
        this.graph = graph;
    }

    public void initVertex(T s) {
        this.visited.put(s, false);
    }

    @Override
    public List<T> search(T source) {
        final List<T> path = new ArrayList<>();
        this.visited.put(source, true);
        this.queue.add(source);
        while(!this.queue.isEmpty()){
            T node = this.queue.poll();
            path.add(node);
            for (T s : this.graph.getAdjacentList(node)) {
                if (!this.visited.get(s)){
                    this.queue.add(s);
                    this.visited.put(s, true);
                }
            }
        }
        return path;
    }
}
