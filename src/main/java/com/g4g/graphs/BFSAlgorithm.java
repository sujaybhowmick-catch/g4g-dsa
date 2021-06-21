package com.g4g.graphs;

import java.util.*;

public class BFSAlgorithm<T> implements GraphSearch<T> {
    private final Map<T, Boolean> visited;
    private final Queue<T> queue;
    private final Graph<T> graph;

    public BFSAlgorithm(Graph<T> graph) {
        this.visited = new HashMap<>();
        this.queue = new LinkedList<>();
        this.graph = graph;
    }

    private void initVisited(){
        for (T s : this.graph.getAllVertices()) {
            this.visited.put(s, false);
        }
    }

    @Override
    public List<T> search(T source) {
        initVisited();
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
