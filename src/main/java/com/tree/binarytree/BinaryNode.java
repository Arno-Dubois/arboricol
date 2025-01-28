package com.tree.binarytree;

import lombok.Data;

@Data
class BinaryNode<E extends Comparable<E>> {
    private E data;
    private BinaryNode<E> left = null;
    private BinaryNode<E> right = null;

    BinaryNode(E data) {
        this(data, null, null);
    }

    BinaryNode(final E data, final BinaryNode<E> left, final BinaryNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    BinaryNode<E> add(final E data) {
        switch (data.compareTo(this.data)) {
            case 1 -> {
                this.right = this.add(this.right, data);
                return this.right;
            }
            case -1 -> {
                this.left = this.add(this.left, data);
                return this.left;
            }
        }
        return this;
    }

    private BinaryNode<E> add(final BinaryNode<E> node, final E data) {
        if (node == null) return new BinaryNode<>(data);
        node.add(data);
        return node;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + this.getData() +
                ", left=" + this.getLeft() +
                ", right=" + this.getRight() +
                '}';
    }

    public StringBuilder prefix(final StringBuilder sb) {
        sb.append(this.data).append(" ");
        if (this.left != null) this.left.prefix(sb);
        if (this.right != null) this.right.prefix(sb);

        return sb;
    }

    public StringBuilder infix(final StringBuilder sb) {
        if (this.left != null) this.left.infix(sb);
        sb.append(this.data).append(" ");
        if (this.right != null) this.right.infix(sb);

        return sb;
    }

    public StringBuilder postfix(final StringBuilder sb) {
        if (this.left != null) this.left.postfix(sb);
        if (this.right != null) this.right.postfix(sb);
        sb.append(this.data).append(" ");

        return sb;
    }

    public int depth() {
        if (this.left == null && this.right == null) return 1;
        if (this.left == null) return 1 + this.right.depth();
        if (this.right == null) return 1 + this.left.depth();

        return 1 + Math.max(this.left.depth(), this.right.depth());
    }

    /*public int balanceFactor() {
    }*/
}
