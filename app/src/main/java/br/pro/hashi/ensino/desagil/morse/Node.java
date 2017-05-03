package br.pro.hashi.ensino.desagil.morse;


public class Node {
    private boolean open;
    private String character;
    private Node left;
    private Node right;
    private Node Parent;
    private char Character;




    public Node(String character, Node left, Node right, Node Parent, char Character) {
        open = true;
        this.character = character;
        this.left = left;
        this.right = right;
        this.Parent= Parent;
        this.Character = Character;


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
        return Parent;
    }
    public void SetParent(Node Parent){
        this.Parent = Parent;
    }
    public char getChar(){
        return Character;
    }


}