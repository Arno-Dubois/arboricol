package com.tree.binarytree;

public class BinaryTree<E extends Comparable<E>> {
    private BinaryNode<E> root;

    @SafeVarargs
    public final void add(final E... datas) {
        for (E data : datas) {
            this.add(data);
        }
    }

    public final void add(final E data) {
        if (this.root == null) {
            this.root = new BinaryNode<>(data);
        } else {
            this.root.add(data);
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + this.root +
                '}';
    }

    public final String toTreeString() {
        if (this.root == null) return "";
        return this.root.toTreeString();
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

        return this.root.lateral(sb).toString();
    }

    public final int getHeight() {
        if (this.root == null) return 0;
        return this.root.getDepth();
    }

    public boolean isAVL() {
        if (this.root == null) return true;
        return BinaryNode.isAVL(this.root);
    }
}













