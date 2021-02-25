package List;

public class LinkedList {

    private Node head;
    private static int length;

    public LinkedList() { /*Empty constructor*/ }

    public void add(Object data) {
        /*Adding data into the linked list*/

        if (head == null) head = new Node(data); //data is 1st elem for initialization

        Node temp = new Node(data); //create a temporary node for the data
        Node current = head;

        if (current != null) { //avoiding NullPointer Exception
            //Starting at head node, traverse to the end, then add new node.
            while (current.getNext() != null)
                current = current.getNext();

            //place the new node at the last node
            current.setNext(temp);
        }
        incrementLength();
    }

    public void add(Object data, int idx){
        /*Adding data into the linked list with specified index*/

        Node temp = new Node(data); //create a temporary node for the data
        Node current = head;

        if(current != null) { //avoiding NullPointer Exception
            //Starting at head node, traverse to the specified index, then add new node.
            for(int i=0; i<idx && current.getNext()!=null; i++)
                current = current.getNext();
        }

        temp.setNext(current.getNext()); //set a reference to the current node's next-node reference
        current.setNext(temp); //add the new node

        incrementLength();
    }

    public Object get(int idx){
        /*Get data from the specified index in the linked list.*/

        if(idx < 0) return null;
        Node current = null; //initialize current variable

        if(head != null){ //if linked list isn't empty
            current = head.getNext();
            for(int i=0; i<idx; i++){
                //traverse through the linked list until idx-1
                if(current.getNext() == null) return null;

                current = current.getNext();
            }
            return current.getData(); //get data from the current node
        }
        return current;
    }

    /*Length methods*/
    private static int getLength() {
        return length;
    }

    private static void incrementLength() {
        length++;
    }

    private static void decrementLength() {
        length--;
    }


    private class Node{
        /*THE NODE CLASS*/

        //This is a reference to the next node in the chain (null if none)
        Node next;

        //Data carried by this particular node (Object means any data type such as String, int, etc.)
        Object data;

        //Node constructor
        public Node(Object data) {
            next = null;
            this.data = data;
        }

        //Another constructor to refer which node to point to (not null)
        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }

        //Accessor methods
        public Node getNext() {
            return next;
        }

        public Object getData() {
            return data;
        }

        //Mutator methods
        public void setNext(Node next) {
            this.next = next;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

}
