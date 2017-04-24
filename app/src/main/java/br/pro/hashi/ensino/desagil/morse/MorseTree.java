package br.pro.hashi.ensino.desagil.morse;


import android.provider.Settings;
import android.widget.Toast;

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
        int i;
        for (i = 0; i < treeToMorse.length; i++){
            nodes[i] = new Node(treeToMorse[i], null, null);
        }

        for(i = nodes.length / 2 - 1; i >= 0; i--) {
                nodes[i] = new Node(treeToMorse[i], nodes[2 * i + 1], nodes[2 * i + 2]);
        }
    }

    public String translate(List<String> morse) {
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
