package com.tree;

import lombok.Data;

@Data

public class BinaryNode<E extends Comparable<E>> {
    private E data;
    private BinaryNode<E> left = null;
    private BinaryNode<E> right = null;

    public BinaryNode(E data) {
        this(data, null, null);
    }

    public BinaryNode(final E data, final BinaryNode<E> left, final BinaryNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void insert(final E data) {
        if (data.compareTo(this.data) == 0) return;

        if (data.compareTo(this.data) > 0) {
            if (this.right == null) {
                this.right = new BinaryNode<>(data);
            } else {
                this.right.insert(data);
            }
        } else {
            if (this.left == null) {
                this.left = new BinaryNode<>(data);
            } else {
                this.left.insert(data);
            }
        }
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
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
}
