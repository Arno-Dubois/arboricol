package com.tree;

import java.util.List;

public class BinaryTree<E extends Comparable<E>> {
    private BinaryNode<E> root;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(final BinaryNode<E> root) {
        this.root = root;
    }

    public void insert(final List<E> datas) {
        if (datas.isEmpty()) return;

        for (E data : datas) {
            if (this.root == null) {
                this.root = new BinaryNode<>(data);
            } else {
                this.root.insert(data);
            }

        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public String prefix() {
        StringBuilder sb = new StringBuilder();
        if (this.root == null) return sb.toString();

        return this.root.prefix(sb).toString();
    }

    public String infix() {
        StringBuilder sb = new StringBuilder();
        if (this.root == null) return sb.toString();

        return this.root.infix(sb).toString();
    }

    public String postfix() {
        StringBuilder sb = new StringBuilder();
        if (this.root == null) return sb.toString();

        return this.root.postfix(sb).toString();
    }
}
