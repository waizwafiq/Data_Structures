public class Graph<T extends Comparable<T>, N extends Comparable<N>> {

    private class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
        private T vertexInfo;
        private int indeg, outdeg;
        private Vertex<T, N> nextVertex; // reference to next vertex/node
        private Edge<T, N> firstEdge; // reference to the first edge node

        public Vertex() {
            vertexInfo = null;
            indeg = outdeg = 0;
            nextVertex = null;
            firstEdge = null;
        }

        public Vertex(T vertexInfo, Vertex<T, N> nextVertex) {
            this.vertexInfo = vertexInfo;
            indeg = outdeg = 0;
            this.nextVertex = nextVertex;
            firstEdge = null;
        }

    }

    private class Edge<T extends Comparable<T>, N extends Comparable<N>> {
        private Vertex<T, N> toVertex;
        private N weight;
        private Edge<T, N> nextEdge;

        public Edge() {
            toVertex = null;
            weight = null;
            nextEdge = null;
        }

        public Edge(Vertex<T, N> destination, N weight, Edge<T, N> nextEdge) {
            this.toVertex = destination;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }

    private Vertex<T, N> head;
    private int size;

    public Graph() {
        head = null;
        size = 0;
    }

    public int getSize() {
        // get the number of vertices in the graph
        return size;
    }

    public boolean hasVertex(T vertexInfo) {
        if (head == null) // if the graph is empty
            return false;

        Vertex<T, N> temp = head; // starting from the head of the graph
        while (temp != null) { // traverse until the final vertex
            if (temp.vertexInfo.compareTo(vertexInfo) == 0)
                return true; // but if the vertex is found, return true

            temp = temp.nextVertex;
        }
        return false;
    }

    public int getInDeg(T vertexInfo) {
        if (hasVertex(vertexInfo)) {
            Vertex<T, N> temp = head; // starting from the head of the graph

            while (temp != null) { // traverse until the final vertex
                if (temp.vertexInfo.compareTo(vertexInfo) == 0)
                    return temp.indeg; // if the vertex is found, return the indeg value;

                temp = temp.nextVertex;
            }
        }
        return -1; // not found
    }

    public int getOutDeg(T vertexInfo) {
        if (hasVertex(vertexInfo)) {
            Vertex<T, N> temp = head; // starting from the head of the graph

            while (temp != null) { // traverse until the final vertex
                if (temp.vertexInfo.compareTo(vertexInfo) == 0)
                    return temp.outdeg; // if the vertex is found, return the outdeg value;

                temp = temp.nextVertex;
            }
        }
        return -1; // not found
    }

    public boolean addVertex(T vertexInfo) {
        if (!hasVertex(vertexInfo)) {
            Vertex<T, N> temp = head; // starting from head vertex

            Vertex<T, N> newVertex = new Vertex<>(vertexInfo, null);

            if (head == null) {
                // if the graph is empty, the new vertex is the head of the graph
                head = newVertex;
            } else {
                // if the graph is not empty
                while (temp.nextVertex != null) // traverse until temp is the final vertex
                    temp = temp.nextVertex;

                temp.nextVertex = newVertex; // add the new vertex next to the final vertex
            }
            size++; // increase the number of vertices in the graph
            return true;
        } else
            return false;
    }
}
