package br.pro.hashi.ensino.desagil.morse;


public class Node {
    private boolean open;
    private int value;
    private Node left;
    private Node right;

    public Node(int value, Node left, Node right) {
        open = true;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void print() {
        if(left != null) {
            left.print();
        }
        if(right != null) {
            right.print();
        }
        System.out.print(" " + value);
    }


    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public int getValue() {
        return value;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
}