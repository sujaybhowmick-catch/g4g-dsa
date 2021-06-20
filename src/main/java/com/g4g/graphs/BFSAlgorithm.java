package com.g4g.graphs;

import java.util.List;

public interface BFSAlgorithm<T> {
    void initVertex(T s);

    List<T> search(T source);
}
