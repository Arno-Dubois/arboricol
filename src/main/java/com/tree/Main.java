package com.tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> datas = List.of(5, 3, 7, 1, 9, 2, 8, 4, 6, 0);
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(datas);
        System.out.println(tree.prefix());
        System.out.println(tree.infix());
        System.out.println(tree.postfix());

    }
}