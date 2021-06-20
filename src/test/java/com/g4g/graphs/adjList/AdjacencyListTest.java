package com.g4g.graphs.adjList;

import com.g4g.graphs.Graph;
import com.g4g.graphs.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest {
    private Graph<Node<String>> graph;
    private Node<String> melbourne;
    private Node<String> act;
    private Node<String> sydney;
    private Node<String> brisbane;
    private Node<String> cairns;

    @BeforeEach
    void setUp() {
        this.graph = new AdjacencyList<>();
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
    void testToString() {
        this.graph.addEdge(melbourne, sydney, false);
        this.graph.addEdge(melbourne, act, false);
        this.graph.addEdge(act, brisbane, false);
        this.graph.addEdge(sydney, brisbane, false);
        this.graph.addEdge(brisbane, cairns, false);
        assertTrue(this.graph.hasEdge(melbourne, sydney));
        assertFalse(this.graph.hasEdge(sydney, melbourne));
    }

    @Test
    void testSearch() {
        this.graph.addEdge(melbourne, sydney, false);
        this.graph.addEdge(melbourne, act, false);
        this.graph.addEdge(act, brisbane, false);
        this.graph.addEdge(sydney, brisbane, false);
        this.graph.addEdge(brisbane, cairns, false);
        List<Node<String>> path = this.graph.search(melbourne);
        assertNotNull(path);
    }
}