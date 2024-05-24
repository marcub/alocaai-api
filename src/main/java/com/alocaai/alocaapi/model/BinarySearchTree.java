package com.alocaai.alocaapi.model;

import java.util.Objects;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(TreeNode nodeToInsert) {

        if (this.root == null) {
            this.root = nodeToInsert;
        } else {
            recursiveInsert(this.root, nodeToInsert);
        }

    }


    public TreeNode search(Integer element) {

        return recursiveSearch(this.root, element);
    }

    public void remove(Integer element) {

        recursiveRemove(this.root, element);

    }

    public TreeNode getMinNode() {
        return recursiveGetMinNode(this.root);
    }

    public TreeNode getMaxNode() {
        return recursiveGetMaxNode(this.root);
    }

    private TreeNode recursiveGetMaxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.getRightNode() == null) {
            return root;
        }
        return recursiveGetMaxNode(root.getRightNode());
    }

    private TreeNode recursiveGetMinNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.getLeftNode() == null) {
            return root;
        }
        return recursiveGetMinNode(root.getLeftNode());
    }

    public TreeNode recursiveSearch(TreeNode root, Integer element) {

        if (root == null || Objects.equals(root.getValue(), element)) {
            return root;
        }

        if (root.getValue() < element) {
            return recursiveSearch(root.getRightNode(), element);
        }

        return recursiveSearch(root.getLeftNode(), element);

    }

    public TreeNode recursiveInsert(TreeNode root, TreeNode nodeToInsert) {

        if (root == null) {
            root = nodeToInsert;
            return root;
        }

        if (nodeToInsert.getValue() < root.getValue()) {
            root.setLeftNode(recursiveInsert(root.getLeftNode(), nodeToInsert));
        } else if (nodeToInsert.getValue() > root.getValue()) {
            root.setRightNode(recursiveInsert(root.getRightNode(), nodeToInsert));
        }

        return root;
    }

    public TreeNode recursiveRemove(TreeNode root, Integer element) {

        if (root == null) {
            return root;
        }

        if (root.getValue() > element) {
            root.setLeftNode(recursiveRemove(root.getLeftNode(), element));
        } else if (root.getValue() < element) {
            root.setRightNode(recursiveRemove(root.getRightNode(), element));
        }

        if (root.getLeftNode() == null) {
            TreeNode temp = root.getRightNode();
            return temp;
        } else if (root.getRightNode() == null) {
            TreeNode temp = root.getLeftNode();
            return temp;
        } else {
            TreeNode succParent = root;

            TreeNode succ = root.getRightNode();
            while (succ.getLeftNode() != null) {
                succParent = succ;
                succ = succ.getLeftNode();
            }

            if (succParent != root) {
                succParent.setLeftNode(succ.getRightNode());
            } else {
                succParent.setRightNode(succ.getRightNode());
            }

            root.setValue(succ.getValue());

            return root;
        }

    }





}
