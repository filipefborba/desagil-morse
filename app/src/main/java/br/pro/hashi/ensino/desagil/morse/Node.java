package br.pro.hashi.ensino.desagil.morse;


public class Node {
    private boolean open;
    private String character;
    private Node left;
    private Node right;
    private Node parent;



    public Node(String character, Node left, Node right) {
        open = true;
        this.character = character;
        this.left = left;
        this.right = right;
        this.parent = null;
    }


    public void print() {
        if (left != null) {
            left.print();
        }
        if (right != null) {
            right.print();
        }
        System.out.print(" " + character);
    }


    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getCharacter() {
        return character;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return null;
    }

    public Node getParent() {
        return parent;
    }

    public void setLeft(Node left){
        this.left = left;
        if(left != null) {
            left.setParent(this);
        }
    }
    public void setRight(Node right){
        this.right = right;
        if(right != null) {
            right.setParent(this);
        }
    }

    public void setParent(Node parent){
        this.parent = parent;
    }
}
