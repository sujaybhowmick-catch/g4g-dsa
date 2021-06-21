package com.g4g.graphs;

import com.g4g.graphs.adjList.AdjacencyList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BFSAlgorithmTest {
    private Graph<Node<String>> graph;
    private GraphSearch<Node<String>> algorithm;
    private Node<String> melbourne;
    private Node<String> act;
    private Node<String> sydney;
    private Node<String> brisbane;
    private Node<String> cairns;

    @BeforeEach
    void setUp() {
        this.graph = new AdjacencyList<>();
        this.algorithm = new BFSAlgorithm<>(this.graph);
        melbourne = new Node<>("Melbourne");
        act = new Node<>("Canberra");
        sydney = new Node<>("Sydney");
        brisbane = new Node<>("Brisbane");
        cairns = new Node<>("Cairns");
    }

    @AfterEach
    void tearDown() {
        this.graph = null;
    }

    @Test
    void search() {
        this.graph.addEdge(melbourne, sydney, false);
        this.graph.addEdge(melbourne, act, false);
        this.graph.addEdge(act, brisbane, false);
        this.graph.addEdge(sydney, brisbane, false);
        this.graph.addEdge(brisbane, cairns, false);
        List<Node<String>> path = this.algorithm.search(this.melbourne);
        String bfs = path.stream()
                .map(Node::getName)
                .collect(Collectors.joining(", "));
        System.out.println(bfs);
    }
}
