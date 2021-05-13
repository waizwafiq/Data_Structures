import java.util.ArrayList;

public class UnweightedGraph<T extends Comparable<T>> {

    private class Vertex<T extends Comparable<T>> {
        private T vertexInfo;
        private int indeg, outdeg; //the number of in-degrees and out-degrees
        private Vertex<T> nextVertex; //reference to the next vertex
        private Edge<T> firstEdge; //reference to the first edge node
        private boolean visited;

        public Vertex() {
            this.visited = false;
        }

        public Vertex(T vertexInfo, Vertex<T> nextVertex) {
            this.vertexInfo = vertexInfo;
            this.nextVertex = nextVertex;
        }

        public T visit() {
            this.visited = true;
            return vertexInfo;
        }

        public boolean isVisited() {
            return visited;
        }
    }

    private class Edge<T extends Comparable<T>> {
        private Vertex<T> toVertex; //the vertex the edge points to
        private Edge<T> nextEdge; //the next edge node after this (from the same source)

        public Edge() {
        }

        public Edge(Vertex<T> toVertex, Edge<T> nextEdge) {
            this.toVertex = toVertex;
            this.nextEdge = nextEdge;
        }
    }

    private Vertex<T> head; //the head of the graph
    private int size; //the number of vertices in the graph G<V,E>

    public UnweightedGraph() {
    }

    public int getSize() {
        //returns the number of vertices in the graph
        return size;
    }

    public T getHead() {
        return head.vertexInfo;
    }

    public Vertex<T> getHeadVertex() {
        return head;
    }

    public boolean hasVertex(T vertexInfo) {
        //checks if the vertex exists (based on the given element)
        if (head == null) //if the graph is empty
            return false;

        Vertex<T> currentVertex = head; //starting from head
        while (currentVertex != null) { //traverse the vertex nodes
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0)
                return true;

            currentVertex = currentVertex.nextVertex; //go to the next vertex node
        }

        return false;
    }

    public boolean hasEdge(T sourceInfo, T destinationInfo) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo))
            //if the graph is empty OR the source and destination vertices don't exist
            return false;

        Vertex<T> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                // traverse until it reaches the source vertex
                Edge<T> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    // go through all of the edges (outDegs) from the source vertex
                    if (currentEdge.toVertex.vertexInfo.compareTo(destinationInfo) == 0) {
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
        Vertex<T> currentVertex = head; // starting from the head of the graph

        while (currentVertex != null) { // traverse until the final vertex
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0)
                return currentVertex.indeg; // if the vertex is found, return the indeg value;

            currentVertex = currentVertex.nextVertex;
        }

        return -1; // not found
    }

    public int getOutDeg(T vertexInfo) {
        Vertex<T> currentVertex = head; // starting from the head of the graph

        while (currentVertex != null) { // traverse until the final vertex
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0)
                return currentVertex.outdeg; // if the vertex is found, return the outdeg value;

            currentVertex = currentVertex.nextVertex;
        }

        return -1; // not found
    }

    public boolean addVertex(T vertexInfo) {
        if (!hasVertex(vertexInfo)) {
            Vertex<T> currentVertex = head; // starting from head vertex

            Vertex<T> newVertex = new Vertex<>(vertexInfo, null);

            if (head == null) {
                // if the graph is empty, the new vertex is the head of the graph
                head = newVertex;
            } else {
                // if the graph is not empty
                while (currentVertex.nextVertex != null) // traverse until currentVertex is the final vertex
                    currentVertex = currentVertex.nextVertex;

                currentVertex.nextVertex = newVertex; // add the new vertex next to the final vertex
                // the new vertex is going to be the new final vertex
            }
            size++; // increase the number of vertices in the graph
            return true;
        } else
            return false;
    }

    public boolean addVertices(T[] verticesInfo) {
        boolean result = false;
        for (T v : verticesInfo)
            result = addVertex(v);

        return result;
    }

    public boolean addEdge(T sourceInfo, T destinationInfo) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo))
            //if the graph is empty OR the source and destination vertices don't exist
            return false;

        Vertex<T> sourceVertex = head;

        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                // traverse until it reaches the source vertex
                // search for destination vertex
                Vertex<T> destinationVertex = head;

                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destinationInfo) == 0) {
                        // traverse until destination vertex
                        Edge<T> currentEdge = sourceVertex.firstEdge;
                        Edge<T> newEdge = new Edge<>(destinationVertex, currentEdge);

                        sourceVertex.firstEdge = newEdge; // add the new edge connected from the source vertex to
                        // destination vertex
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

    public boolean addEdges(T[][] edges) {
        boolean result = false;
        for (T[] e : edges)
            result = addEdge(e[0], e[1]);

        return result;
    }

    public boolean addUndirectedEdge(T sourceInfo, T destinationInfo) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo))
            //if the graph is empty OR the source and destination vertices don't exist
            return false;

        Vertex<T> sourceVertex = head;

        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                // traverse until it reaches the source vertex
                // search for destination vertex
                Vertex<T> destinationVertex = head;

                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destinationInfo) == 0) {
                        // traverse until destination vertex
                        Edge<T> currentEdgeSource = sourceVertex.firstEdge;
                        Edge<T> newEdgeForward = new Edge<>(destinationVertex, currentEdgeSource); //edge to dest

                        Edge<T> currentEdgeDest = destinationVertex.firstEdge;
                        Edge<T> newEdgeBackward = new Edge<>(sourceVertex, currentEdgeDest); //edge to source

                        // add the new edge forward connected from the source vertex to destination vertex
                        sourceVertex.firstEdge = newEdgeForward;

                        //add the new edge backward connected from the destination vertex to sourceVertex
                        destinationVertex.firstEdge = newEdgeBackward;

                        sourceVertex.indeg++;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        destinationVertex.outdeg++;
                        return true;
                    }

                    destinationVertex = destinationVertex.nextVertex;
                }
            }

            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addUndirectedEdges(T[][] undirEdges) {
        boolean result = false;
        for (T[] e : undirEdges)
            result = addUndirectedEdge(e[0], e[1]);

        return result;
    }

    public boolean removeEdge(T sourceInfo, T destinationInfo) {
        if (head == null)
            //if the graph is empty
            return false;

        Vertex<T> currentVertex = head;
        while (currentVertex != null) {
            if (currentVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                //traverse until it reaches the source vertex
                Edge<T> currentEdge = currentVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destinationInfo) == 0) {
                        //traverse all edges from source until it points to dest
                        currentEdge.toVertex = null; //delete by pointing the edge towards null instead of dest vertex
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }

                return false; //if destination vertex not found (or no connection between source and dest
            }
            currentVertex = currentVertex.nextVertex;
        }
        return false; // if source vertex not found
    }

    public ArrayList<T> getNeighbours(T vertexInfo) {
        if (!hasVertex(vertexInfo))
            return null;

        ArrayList<T> neighbours = new ArrayList<>();

        Vertex<T> currentVertex = head;
        while (currentVertex != null) {
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0) {
                // traverse until given vertex
                Edge<T> currentEdge = currentVertex.firstEdge;

                while (currentEdge != null) {
                    // go through all of the edges (outDegs) from the given vertex
                    neighbours.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }

            currentVertex = currentVertex.nextVertex;
        }
        return neighbours;
    }

    public ArrayList<Vertex<T>> getNeighboursVertices(Vertex<T> vertex) {
        if (!hasVertex(vertex.vertexInfo))
            return null;

        ArrayList<Vertex<T>> neighbours = new ArrayList<>();

        Vertex<T> currentVertex = head;
        while (currentVertex != null) {
            if (currentVertex.vertexInfo.compareTo(vertex.vertexInfo) == 0) {
                // traverse until given vertex
                Edge<T> currentEdge = currentVertex.firstEdge;

                while (currentEdge != null) {
                    // go through all of the edges (outDegs) from the given vertex
                    neighbours.add(currentEdge.toVertex); //add the vertex (NOT THE VERTEXINFO)
                    currentEdge = currentEdge.nextEdge;
                }
            }

            currentVertex = currentVertex.nextVertex;
        }
        return neighbours;
    }

    public void printEdges() {
        Vertex<T> currentVertex = head;
        while (currentVertex != null) {
            System.out.print("# " + currentVertex.vertexInfo + " : ");
            Edge<T> currentEdge = currentVertex.firstEdge;

            while (currentEdge != null) {
                // go through all the edges from current vertex
                System.out.print("[" + currentVertex.vertexInfo + " ---> " + currentEdge.toVertex.vertexInfo + "]");

                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();

            currentVertex = currentVertex.nextVertex;
        }
    }

    public void BreadthFirstSearch(Vertex<T> startVertex) {
        if (startVertex == null || head == null)
            return;

        //Breadth-First Search uses FIFO protocol in the frontier.
        Queue<Vertex<T>> frontier = new Queue<>();
        frontier.enqueue(startVertex);

        while (!frontier.isEmpty()) {
            Vertex<T> currentVertex = frontier.dequeue();

            //check if the vertex in the frontier has been visited
            if (currentVertex.isVisited())
                continue;

            //if not, visit it
            System.out.print(currentVertex.visit() + " ");

            //get the current vertex's neighbours
            ArrayList<Vertex<T>> neighbours = getNeighboursVertices(currentVertex);

            //if there's no neighbours, skip
            if (neighbours == null)
                continue;

            //enqueue all neighbours into the frontier
            for (Vertex<T> v : neighbours)
                if (!v.isVisited())
                    frontier.enqueue(v);
        }

    }
}
