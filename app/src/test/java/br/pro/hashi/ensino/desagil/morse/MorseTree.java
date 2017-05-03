package br.pro.hashi.ensino.desagil.morse;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class MorseTree {
    private SendActivity send;
    private String[] treeToMorse = {null,"e","t","i","a","n","m","s","u","r","w","d","k","g","o",
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
    Node[] nodes = new Node[127];


    public MorseTree() {
        createNodes();
    }

    public void createNodes() {

        for (int i = 0; i < treeToMorse.length; i++){
            nodes[i] = new Node(treeToMorse[i], null, null ,null ,' ');
        }

        for(int i = nodes.length / 2 - 1; i >= 0; i--) {
                nodes[i] = new Node(treeToMorse[i], nodes[2 * i + 1], nodes[2 * i + 2],null,' ');
        }
    }
    public Node[] getNodes() {
        return nodes;
    }

    public class MorseToRoman {
        private HashMap<String, String> treeToMorse;
        public MorseToRoman() {
            treeToMorse = new HashMap<>();
            MorseTree tree = new MorseTree();
            Node[] nodes = tree.getNodes();
            Queue<Node> fila = new LinkedList<>();

            fila.add(nodes[0]);

            for(int i = 0; i < nodes.length; i++){
            String seq = "";
            fila.add(fila.peek().getLeft());
            fila.add(fila.peek().getRight());
            Node current = fila.peek();
            while(fila.peek().getParent() != null) {
                try {
                    if (current.getParent().getLeft() == current) {
                        seq = seq + ".";
                        current = current.getParent();
                    } else if(current.getParent().getRight() == current){
                        seq = seq + "-";
                        current = current.getParent();
                    }
                } catch (NullPointerException e){
                    break;
                }
            }

            String revseq = new StringBuilder(seq).reverse().toString();
            if (fila.peek().getChar() == '_') {
                treeToMorse.put(revseq,fila.peek().getCharacter());
                }
                System.out.println("letra: " + fila.peek().getCharacter() + " | morse: "+ revseq);
                fila.remove(fila.peek());
        }

            System.out.println(treeToMorse.entrySet());
    }
}

















    public String translate(List<String> morse) { // Morse-Texto
        String character;
        Node actual_node = nodes[0];
        for (int i = 0; i < morse.size(); i++) {
            if (actual_node != null){
                if (morse.get(i) == ".") {
                    actual_node = actual_node.getLeft();
                    // go to left
                }
                else if (morse.get(i) == "-") {
                    actual_node = actual_node.getRight();
                    // go to right
                }
            }
        }
        if ( actual_node != null){
            character = actual_node.getCharacter();
            return character;
        }
        else {
            return "";
        }
    }

    }



