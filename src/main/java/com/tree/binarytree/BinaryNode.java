package com.tree.binarytree;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNode<E extends Comparable<E>> {
    private static final String GAP_START_LEFT = "╭";
    private static final String GAP_START_RIGHT = "╰";
    private static final String GAP = " ";
    private static final String GAP_END = "─";

    @Getter
    private E data;
    @Getter
    private int balanceFactor;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    BinaryNode(E data) {
        this(data, null, null);
    }

    BinaryNode(final E data, final BinaryNode<E> left, final BinaryNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.balanceFactor = 0;
    }

    private static <E extends Comparable<E>> int getDepth(final BinaryNode<E> node) {
        if (node == null) return 0;
        return node.getDepth();
    }

    public static <E extends Comparable<E>> boolean isAVL(final BinaryNode<E> node) {
        if (node == null) return true;
        return node.isAVL();
    }

    private boolean isAVL() {
        if (Math.abs(this.balanceFactor) > 1) return false;
        return BinaryNode.isAVL(this.left) && BinaryNode.isAVL(this.right);
    }

    void add(final E data) {
        switch (data.compareTo(this.data)) {
            case 1 -> this.right = this.add(this.right, data);
            case -1 -> this.left = this.add(this.left, data);

        }
    }

    private BinaryNode<E> add(final BinaryNode<E> node, final E data) {
        if (node == null) return new BinaryNode<>(data);
        node.add(data);
        this.calculateBalanceFactor();
        return node;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + this.getData() +
                ", left=" + this.left +
                ", right=" + this.right +
                '}';
    }


    String toPrettyString() {
        return "[" + this.data +
                (((this.left == null) && (this.right == null)) ? "" :
                        "(" + ((this.left == null) ? "-" : this.left.toPrettyString()) +
                                ", " + ((this.right == null) ? "-" : this.right.toPrettyString()) + ")") + "]";
    }

    String toTreeString() {
        return this.toTreeString(0, true);
    }

    String toTreeString(final int gap, final boolean isLeft) {
        StringBuilder stringBuilder = new StringBuilder();


        if (this.left != null) stringBuilder.append(this.left.toTreeString(gap + 1, true));
        if (gap >= 1) {
            stringBuilder.append(BinaryNode.GAP.repeat((gap - 1) * 2));
            stringBuilder.append(isLeft ? BinaryNode.GAP_START_LEFT : BinaryNode.GAP_START_RIGHT);
            stringBuilder.append(BinaryNode.GAP_END);
        }
        stringBuilder.append(this.data);
        stringBuilder.append("(").append(this.balanceFactor).append(")");
        stringBuilder.append("\n");
        if (this.right != null) stringBuilder.append(this.right.toTreeString(gap + 1, false));

        return stringBuilder.toString();
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

    public StringBuilder lateral(final StringBuilder sb) {
        if (this.data == null) return sb;

        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            BinaryNode<E> node = queue.poll();
            sb.append(node.getData()).append(" ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

        }
        return sb;
    }

    public StringBuilder postfix(final StringBuilder sb) {
        if (this.left != null) this.left.postfix(sb);
        if (this.right != null) this.right.postfix(sb);
        sb.append(this.data).append(" ");

        return sb;
    }

    int getDepth() {
        return 1 + Math.max(BinaryNode.getDepth(this.left), BinaryNode.getDepth(this.right));
    }

    private void calculateBalanceFactor() {
        this.balanceFactor = BinaryNode.getDepth(this.left) - BinaryNode.getDepth(this.right);

    }
}
