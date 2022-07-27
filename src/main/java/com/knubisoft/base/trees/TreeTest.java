package com.knubisoft.base.trees;


class Node
{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

public class TreeTest extends  TreeTasksImpl{
    public static boolean isSymmetric(Node X, Node Y)
    {
        // базовый случай: если оба дерева пусты
        if (X == null && Y == null) {
            return true;
        }

        // вернуть истину, если
        // 1. Оба дерева непусты, и
        // 2. Левое поддерево является зеркалом правого поддерева, и
        // 3. Правое поддерево является зеркалом левого поддерева
        return (X != null && Y != null) &&
                isSymmetric(X.left, Y.right) &&
                isSymmetric(X.right, Y.left);
    }

    // Функция для проверки, имеет ли данное бинарное дерево симметричную структуру или нет
    public static boolean isSymmetric(Node root)
    {
        // базовый вариант
        if (root == null) {
            return true;
        }

        // возвращаем true, если левое и правое поддеревья отражают друг друга
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args)
    {
        /* Построим следующее дерево
              1
            /   \
           /     \
          2       3
           \     /
            5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);

        if (isSymmetric(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }
    }
}
