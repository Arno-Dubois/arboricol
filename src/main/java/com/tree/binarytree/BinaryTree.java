package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> {
    private BinaryNode<E> root;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(final BinaryNode<E> root) {
        this.root = root;
    }

    public void add(final E... datas) {
        for (E data : datas) {
            this.add(data);
        }
    }

    public void add(final E data) {
        if (this.root == null) this.root = new BinaryNode<>(data);
        else this.root.add(data);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + this.root +
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

    public String lateral() {
        StringBuilder sb = new StringBuilder();
        if (this.root == null) return sb.toString();

        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.poll();
            sb.append(node.getData()).append(" ");
            if (node.getLeft() != null) queue.add(node.getLeft());
            if (node.getRight() != null) queue.add(node.getRight());

        }
        return sb.toString();
    }

    public int depth() {
        if (this.root == null) return 0;
        return this.root.depth();
    }

    /*public int balanceFactor() {
        if (this.root == null) return 0;
        return this.root.balanceFactor;
    }*/
}













