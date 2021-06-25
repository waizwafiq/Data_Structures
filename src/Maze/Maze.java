package Maze;

import java.util.ArrayList;

public class Maze {

    private Node root;
    private Node lowestTail;

    public void addRow(int rowNum, String[] val) {
        Node current = new Node(rowNum, 0, val[0]);
        Node upper_row = lowestTail; //the upper row of the current node (start from right)

        if (root == null)
            root = current;

        //CONNECT LEFT-RIGHT NODES
        for (int i = 1; i < val.length; i++) {
            Node newNode = new Node(rowNum, i, val[i]);

            current.setRight(newNode); //connect current -> newNode
            newNode.setLeft(current); //connect newNode -> current

            current = current.getRight(); //go right
        }

        lowestTail = current;

        //CONNECT TOP-BOTTOM NODES
        while (rowNum != 0 && upper_row != null) {
            //start from right
            upper_row.setDown(current);  //connect upper row -> newNode
            current.setUp(upper_row);    //connect newNode -> upper row
            upper_row = upper_row.getLeft(); //go left for the upper row of current's row
            current = current.getLeft();
        }
    }

    public String search() {
        ArrayList<Node> path = new ArrayList<>();
        MyStack<Node> stack = new MyStack<Node>();
        stack.push(root); //start from root
        root.visit();

        Node current = root;
        while (!current.isGoal() && !stack.isEmpty()) {
            current = stack.pop();
            path.add(current);

            if (current.getLeft() != null) {
                if (current.getLeft().isVisitable())
                    stack.push(current.getLeft().visit());
            }
            if (current.getUp() != null) {
                if (current.getUp().isVisitable())
                    stack.push(current.getUp().visit());
            }
            if (current.getDown() != null) {
                if (current.getDown().isVisitable())
                    stack.push(current.getDown().visit());
            }
            if (current.getRight() != null) {
                if (current.getRight().isVisitable())
                    stack.push(current.getRight().visit());
            }
        }

        StringBuilder out = new StringBuilder();
        if(!stack.isEmpty()) {
            out.append("Path: ");
            for (int i = 0; i < path.size() - 1; i++)
                out.append(path.get(i)).append(" >> ");
            out.append(path.get(path.size() - 1)).append("\n");
        }else{
            out.append("No path found!");
        }

        return out.toString();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        Node current = root;

        while (current != null) {
            Node head = current.getDown();
            while (current != null) {
                out.append(current).append(" ");

                current = current.getRight();
            }
            out.append("\n");
            current = head;
        }
        return out.toString();
    }
}
