/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author dangvu.vn
 */
public class BinaryTreeTraversal {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param nodes: [1, 2, 3, 4, 0, 5, 6, 0, 0, 0, 0, 7, 8, 0, 0]
     *
     * Tree visualize: 
     *         1 
     *        / \ 
     *        2 3 
     *       / / \ 
     *       4 5 6 
     *        / \ 
     *        7 8
     */
    public TreeNode createTree(int[] nodes) {
        TreeNode root = null;
        if (nodes != null && nodes.length > 0) {
            root = makeNode(nodes, 0);
        }
        return root;
    }

    public List<String> preOrderTraversal(TreeNode root) {
        TreeNode tmpRoot = root;

        List<String> traverseOrder = new ArrayList<>();
        if (tmpRoot == null) {
            return traverseOrder;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(tmpRoot);

        while (!stack.isEmpty()) {

            TreeNode head = stack.pop();

            traverseOrder.add(head.val + "");

            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        return traverseOrder;
    }

    public List<String> postOrderTraversal(TreeNode root) {
        List<String> traverseOrder = new ArrayList<>();
        
        TreeNode tmpRoot = root;
        // Check whether a node is visited ?
        Set<Integer> isPassed = new HashSet<Integer>();

        
        if (tmpRoot == null) {
            return traverseOrder;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(tmpRoot);
        isPassed.add(tmpRoot.val);
        
        while (!stack.isEmpty()) {

            TreeNode head = stack.pop();
            
            /**
             * Check if a node is a leaf node or all of its children has been 
             * visited before.
             * true: push it to result list.
             * false: push that node, its right child, its left child into stack
             * in that order to make sure we will pop their out of stack in the
             * reverse order
             */
            
            TreeNode left = head.left;
            TreeNode right = head.right;
            
            if (left != null && isPassed.contains(left.val)) {
                left = null;
            }
            
            if (right != null && isPassed.contains(right.val)) {
                right = null;
            }
            
            if (left == null && right == null) {
                traverseOrder.add(head.val + "");
            }
            
            if (left != null || right != null) {
                stack.push(head);
                if (right != null) {
                    stack.push(right);
                    isPassed.add(right.val);
                }
                if (left != null) {
                    stack.push(left);
                    isPassed.add(left.val);
                }
            }

        }

        return traverseOrder;
    }

    public List<String> inorderTraversal(TreeNode root) {
        
        Set<Integer> traverseLeft = new HashSet<Integer>();
        
        List<String> traverseOrder = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode tmp = root;
        while (tmp != null) {
            /**
             * Check if the left child of a node has been visited:
             * if its haven't been visited before, visit its left child, push 
             * the current node into stack and at the same time mark this node
             * as has been visited its left child.
             * Else put its value into result list then visit it right child.
             */
            if (!traverseLeft.contains(tmp.val)) {

                TreeNode left = tmp.left;
                
                traverseLeft.add(tmp.val);
                
                stack.push(tmp);
                tmp = left;

            } else {
                traverseOrder.add(tmp.val + "");
                tmp = tmp.right;
            }

            if (tmp == null && !stack.isEmpty()) {
                tmp = stack.pop();
            }
        }

        return traverseOrder;
    }
    
    
    private TreeNode makeNode(int[] nodes, int rootIdx) {
        int leftIdx = 2 * rootIdx + 1;
        int rightIdx = 2 * rootIdx + 2;

        TreeNode root = new TreeNode(nodes[rootIdx]);

        if (leftIdx < nodes.length && nodes[leftIdx] > 0) {
            TreeNode left = makeNode(nodes, leftIdx);
            root.left = left;
        }

        if (rightIdx < nodes.length && nodes[rightIdx] > 0) {
            TreeNode right = makeNode(nodes, rightIdx);
            root.right = right;
        }

        return root;
    }

}
