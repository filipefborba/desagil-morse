package br.pro.hashi.ensino.desagil.morse;


import android.provider.Settings;
import java.util.List;

public class MorseTree {
    private SendActivity send;
    private String letter;
    private Node[] nodes;
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

    public MorseTree() {
        this.nodes = new Node[126];
        createNodes();
    }

    public void createNodes() {
        int i;

        Node[] nodes = new Node[127];
        for (i = 0; i < treeToMorse.length; i++){
            nodes[i] = new Node(treeToMorse[i], null, null);
        }

        for(i = nodes.length / 2 - 1; i >= 0; i--) {
            nodes[i] = new Node(treeToMorse[i], nodes[2 * i + 1], nodes[2 * i + 2]);
        }
    }

    public String translate(List<String> morse){
        String character = "";

        return character;
    }
}
