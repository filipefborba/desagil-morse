 Node root = nodes[0]; // Mesma coisa que o actual_node em cima
    // Busca em profundidade para traduçao Texto-Morse 

    Stack<Node> stack = new Stack<>();
        root.setOpen(false);

        stack.push(root);

        while(!stack.isEmpty()) {
        Node character = stack.peek();  
        Node left = Node.getLeft();
        Node right = Node.getRight();

        if(left != null && left.isOpen()) {
            left.setOpen(false);
            stack.push(left);
        }
        else if(right != null && right.isOpen()) {
            right.setOpen(false);
            stack.push(right);
        }
        else {
            System.out.print(" " + Node.getcharacter());
            stack.pop();
        }
    }
