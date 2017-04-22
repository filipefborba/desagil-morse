package br.pro.hashi.ensino.desagil.morse;


import android.provider.Settings;

public class MorseTree {
    private SendActivity send;
    private String letter;
    public Node[] nodes;
    private String[] tree_to_morse = {null,"e","t","i","a","n","m","s","u","r","w","d","k","g","o",
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

    public MorseTree() {
        this.nodes = new Node[126];
        createNodes();

    }

    public char translate(String code) {
        int index;
        Node actual_node = nodes[0];
        for (index = 0; index < code.length(); ++index){
            char node_finder = code.charAt(index);
            if (node_finder == '.'){
                if (actual_node.getLeft() != null){
                    actual_node = actual_node.getLeft();
                //go to left
            }
            }
            if (node_finder == '-'){
                if (actual_node.getRight() != null){
                    actual_node = actual_node.getRight();
                //got to right
              }
            }
        }
        return 0;
    }



    public void createNodes() {
        int i;


        for(i = nodes.length - 1; i >= nodes.length / 2; i--) {
            nodes[i] = new Node(i, null, null);
        }

        for(i = nodes.length / 2 - 1; i >= 0; i--) {
            nodes[i] = new Node(i, nodes[2 * i + 1], nodes[2 * i + 2]);
        }



    }
}
