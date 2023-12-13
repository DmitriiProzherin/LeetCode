package org.behemoth.Easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
//        tree2str();
    }

    public static String tree2str(TreeNode root){
            if (root == null) return "()";
            
            tree2str(root.left);
            tree2str(root.right);
            return "";
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


