package com.tree;

import com.tree.binarytree.BinaryTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> datas = List.of(5, 3, 7, 1, 9, 2, 8, 4, 6, 0);
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5, 3, 2, 4, 7, 6, 8, 9, 10);

        System.out.println(tree.toTreeString());
        System.out.println(tree.infix());
        System.out.println(tree.postfix());
        System.out.println(tree.lateral());
        System.out.println(tree.isAVL());

    }
}