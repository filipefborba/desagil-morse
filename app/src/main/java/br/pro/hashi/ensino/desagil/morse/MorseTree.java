package br.pro.hashi.ensino.desagil.morse;

import java.util.ArrayList;

import br.pro.hashi.ensino.desagil.morse.SendActivity;


public class MorseTree {
    private SendActivity send;

    public char translate(String code) {
        ArrayList letter = send.getLetter();
        int index;
        for (index = 0; index  < letter.size();++index){
            String node_finder = (String) letter.get(index);
            if (node_finder == "."){
                //go to left
            }
            if (node_finder == "-"){
                //got to right
            }
        }
        return 0;
    }

}
