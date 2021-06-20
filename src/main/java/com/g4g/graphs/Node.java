package com.g4g.graphs;

import java.util.Objects;

public class Node<E> {
    private final E name;

    public Node(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    @Override
    public String toString() {
        return (String)this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
