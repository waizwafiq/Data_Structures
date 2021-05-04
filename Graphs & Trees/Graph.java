import java.util.ArrayList;

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

    public boolean hasEdge(T sourceInfo, T destinationInfo) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo)) // if the graph is empty OR the
                                                                                   // source and destination vertices
                                                                                   // don't exist
            return false;

        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                // traverse until it reaches the source vertex
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destinationInfo) == 0) {
                        // traverse from source vertex until destination vertex
                        return true;
                    }

                    currentEdge = currentEdge.nextEdge;
                }
            }

            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public int getInDeg(T vertexInfo) {
        Vertex<T, N> temp = head; // starting from the head of the graph

        while (temp != null) { // traverse until the final vertex
            if (temp.vertexInfo.compareTo(vertexInfo) == 0)
                return temp.indeg; // if the vertex is found, return the indeg value;

            temp = temp.nextVertex;
        }

        return -1; // not found
    }

    public int getOutDeg(T vertexInfo) {
        Vertex<T, N> temp = head; // starting from the head of the graph

        while (temp != null) { // traverse until the final vertex
            if (temp.vertexInfo.compareTo(vertexInfo) == 0)
                return temp.outdeg; // if the vertex is found, return the outdeg value;

            temp = temp.nextVertex;
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
                // the new vertex is going to be the new final vertex
            }
            size++; // increase the number of vertices in the graph
            return true;
        } else
            return false;
    }

    public boolean addEdge(T sourceInfo, T destinationInfo, N weight) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo)) // if the graph is empty OR the
                                                                                   // source and destination vertices
                                                                                   // don't exist
            return false;

        Vertex<T, N> sourceVertex = head;

        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                // traverse until it reaches the source vertex
                // search for destination vertex
                Vertex<T, N> destinationVertex = head;

                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destinationInfo) == 0) {
                        // traverse until destination vertex
                        Edge<T, N> currentEdge = sourceVertex.firstEdge;
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, weight, currentEdge);

                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }

                    destinationVertex = destinationVertex.nextVertex;
                }
            }

            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public N getEdgeWeight(T sourceInfo, T destinationInfo) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo)) // if the graph is empty OR the
                                                                                   // source and destination vertices
                                                                                   // don't exist
            return null;

        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            // traverse until it reaches the source vertex
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destinationInfo) == 0) //traverse until destination vertex
                        return currentEdge.weight;

                    currentEdge = currentEdge.nextEdge;
                }
            }

            sourceVertex = sourceVertex.nextVertex;
        }
        return null;
    }

    public ArrayList<T> getNeighbours(T vertexInfo){
        if(!hasVertex(vertexInfo))
            return null;

        ArrayList<T> neighbours = new ArrayList<>();

        Vertex<T,N> temp = head;
        while(temp != null){
            if(temp.vertexInfo.compareTo(vertexInfo) == 0){
                //traverse until given vertex
                Edge<T,N> currentEdge = temp.firstEdge;

                while(currentEdge != null){
                    neighbours.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }

            temp = temp.nextVertex;
        }
        return neighbours;
    }
}
