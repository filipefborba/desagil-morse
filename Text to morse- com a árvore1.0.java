 public String translateTM(List<String> morse) { // Texto-morse
        String character;
        Node actual_node = nodes[0];
        for (int i = 0; i < morse.size(); i++) {
            if (actual_node != null){
                if (morse.get(i) == "e") {
                    actual_node = actual_node.getLeft();
                    // go to left
                }
                else if (morse.get(i) == "t") {
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