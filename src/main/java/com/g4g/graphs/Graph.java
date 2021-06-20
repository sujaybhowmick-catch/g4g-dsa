package com.g4g.graphs;

import java.util.List;
import java.util.Set;

public interface Graph<T> {
    void addVertex(T s);

    void addEdge(T source, T destination, boolean bidirectional);

    int getVertexCount();

    int getEdgeCount(boolean bidirectional);

    boolean hasVertex(T s);

    List<T> getAdjacentList(T s);

    boolean hasEdge(T source, T destination);

    List<T> search(T source);


}
