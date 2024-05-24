package com.alocaai.alocaapi.model;

public class TreeNode {

    private Double value;

    private SolucaoGulosa solucaoGulosa;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(Double value, SolucaoGulosa solucaoGulosa) {
        this.value = value;
        this.solucaoGulosa = solucaoGulosa;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    public SolucaoGulosa getSolucaoGulosa() {
        return solucaoGulosa;
    }

    public void setSolucaoGulosa(SolucaoGulosa solucaoGulosa) {
        this.solucaoGulosa = solucaoGulosa;
    }
}
