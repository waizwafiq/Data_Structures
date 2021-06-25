package Maze;

public class Node {
    private int row;
    private int col;
    private String val;
    private boolean visitable;
    private boolean goal;
    private Node up, left, down, right;

    public Node(int row, int col, String val) {
        this.row = row;
        this.col = col;
        this.val = val;
        goal = val.equalsIgnoreCase("C");
        visitable = val.equalsIgnoreCase("1") || goal;

        up = left = down = right = null;
    }

    public Node visit() {
        if (isVisitable()) {
            visitable = false;
            return this;
        }
        return null;
    }

    /*GETTERS*/
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVisitable() {
        return visitable;
    }

    public Node getUp() {
        return up;
    }

    public Node getLeft() {
        return left;
    }

    public Node getDown() {
        return down;
    }

    public Node getRight() {
        return right;
    }

    public String getVal() {
        return val;
    }

    public boolean isGoal() {
        return goal;
    }

    /*SETTERS*/

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "("+row+", "+col+")"/*" " + val + " "*/;
    }
}
