package com.knubisoft.base.trees;

import java.util.ArrayList;
import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return isSameTree(node1.right, node2.right) &&
                isSameTree(node1.left, node2.left);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = node;
        TreeNode result;
        // проверка левой ветки, если она не имеет значений, идем на правую ветку
        while (current !=null){
            if (current.left == null){
                list.add(current.val);
                current = current.right;
            }

            // Проверка левой ветки, и её последователей.
            else
            {
                result = current.left;
                while (result.right != null){
                    result = result.right;
                }

                result.right = current;
                TreeNode treeNode = current;
                current = current.left;
                treeNode.left = null;
            }
        }
        return list;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {

        if (node == null) {
            return true;
        }


     return isSameTree(node.left,node.right);
    }

    @Override
    public int maxDepth(TreeNode node) {
//        if (node == null){
//            return -1;
//        }
//        else {
//           int leftTree = maxDepth(node.left);
//           int rightTree = maxDepth(node.right);
//
//           if (leftTree > rightTree)
//               return (leftTree +1);
//           else
//               return (rightTree +1);
//        }

        if(node==null) return 0;

        return 1+Math.max(maxDepth(node.left),maxDepth(node.right));

    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null)
            return false;
        if (node.val == targetSum && (node.left == null && node.right == null))
            return true;

        return hasPathSum(node.left, targetSum - node.val)
                || hasPathSum(node.right, targetSum - node.val);
    }

    @Override
    public TreeNode invertTree(TreeNode node) {
        return null;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
        return -1;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        return null;
    }
}
