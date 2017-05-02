package br.pro.hashi.ensino.desagil.morse;

/**
 * Created by Filipe Borba on 02/05/2017.
 */
import java.util.Stack;

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

    public String encode() {
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
            if (morseEncode.equals("-----")) {
                System.out.println(node.getCharacter() + morseEncode);
                return morseEncode;
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
}
