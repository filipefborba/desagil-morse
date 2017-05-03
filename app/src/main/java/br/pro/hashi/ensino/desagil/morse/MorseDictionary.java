package br.pro.hashi.ensino.desagil.morse;

/**
 * Created by Filipe Borba on 02/05/2017.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MorseDictionary {
    private static String[] treeToMorse = {null,"e","t","i","a","n","m","s","u","r","w","d","k","g","o",
            "h","v","f",null,"l",null,"p","j","b","x","c","y","z","q",
            null,null,"5","4",null,"3","é",null,null,"2",null,null,
            "+",null,null,"à",null,"1","6","=","/",null,"ç",null,null,
            null,"7",null,null,null,"8",null,"9","0",null,null,null,
            null,null,null,null,null,null,null,null,null,"?","_",
            null,null,null,null,null,null,null,".",null,null,null,
            "@",null,null,null,null,null,null,"-",null,null,null,
            null,null,null,null,null,";","!",null,null,null,null,null,null,
            null,",",null,null,null,null,":",null,null,null,null,null,null,
            null};

    public String decode(String morseCodeString) {
        Node[] nodes = new Node[127];

        for (int i = 0; i < treeToMorse.length; i++){
            nodes[i] = new Node(treeToMorse[i], null, null);
        }

        for(int i = nodes.length / 2 - 1; i >= 0; i--) {
            nodes[i] = new Node(treeToMorse[i], nodes[2 * i + 1], nodes[2 * i + 2]);
        }

        Node root = nodes[0];
        Stack<Node> stack = new Stack<>();
        String morseEncode = "";
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.peek();
            Node left = node.getLeft();
            Node right = node.getRight();
            if (morseEncode.equals(morseCodeString)) {
                System.out.println(node.getCharacter() + " " + morseEncode);
                String decodedCharacter = node.getCharacter();
                return decodedCharacter;
            }
            if(left != null && left.isOpen()) {
                morseEncode = morseEncode + ".";
                left.setOpen(false);
                stack.push(left);
            }
            else if(right != null && right.isOpen()) {
                morseEncode = morseEncode + "-";
                right.setOpen(false);
                stack.push(right);
            }
            else {
                stack.pop();
                if (!morseEncode.isEmpty()){
                    morseEncode = morseEncode.substring(0, (morseEncode.length() - 1));
                }
            }
        }
        return "";
    }

    public static LinkedList<String> romanToMorse(){
        Node[] nodes = new Node[127];


        for (int i = 0; i < treeToMorse.length; i++){
            nodes[i] = new Node(treeToMorse[i], null, null);
        }

        for(int i = nodes.length / 2 - 1; i >= 0; i--) {
            nodes[i] = new Node(treeToMorse[i], nodes[2 * i + 1], nodes[2 * i + 2]);
        }

        Node root = nodes[0];
        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<>();
        root.setOpen(false);
        queue.add(root);


        LinkedList<String> dicionario = new LinkedList<>();

        while (!queue.isEmpty()) {
            Node node = queue.element();
            Node left = node.getLeft();
            Node right = node.getRight();


            if (left != null && left.isOpen()) {
                left.setOpen(false);
                queue.add(left);
            } else if (right != null && right.isOpen()) {
                right.setOpen(false);
                queue.add(right);
            } else {
                Node actual_removed = queue.remove();

                if (actual_removed.getValue() != null && actual_removed != root) {
                    String codigo = "";
                    String removed = actual_removed.getValue();
                    while (actual_removed != root) {
                        if (actual_removed.getParent().getLeft() == actual_removed) {
                            codigo = codigo + ".";
                        } else {
                            codigo = codigo + "-";
                        }
                        actual_removed = actual_removed.getParent();
                    }
                    String novocodigo = new StringBuilder(codigo).reverse().toString();
                    dicionario.add(novocodigo + "  =  " + removed);
                }

            }
        }
        return dicionario;
    }

}