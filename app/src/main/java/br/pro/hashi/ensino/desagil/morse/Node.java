package br.pro.hashi.ensino.desagil.morse;


public class Node {
    private boolean open;
    private String character;
    private Node left;
    private Node right;

    public Node(String character, Node left, Node right) {
        open = true;
        this.character = character;
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
}
