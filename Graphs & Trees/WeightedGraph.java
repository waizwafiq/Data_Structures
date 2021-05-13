import java.util.ArrayList;

public class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>> {

    private class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
        private T vertexInfo;
        private int indeg, outdeg; //the number of in-degrees and out-degrees
        private Vertex<T, N> nextVertex; //reference to the next vertex
        private Edge<T, N> firstEdge; //reference to the first edge node

        public Vertex() {
        }

        public Vertex(T vertexInfo, Vertex<T, N> nextVertex) {
            this.vertexInfo = vertexInfo;
            this.nextVertex = nextVertex;
        }
    }

    private class Edge<T extends Comparable<T>, N extends Comparable<N>> {
        private Vertex<T, N> toVertex; //the vertex the edge points to
        private N weight; //the weight of this edge
        private Edge<T, N> nextEdge; //the next edge node after this (from the same source)

        public Edge() {
        }

        public Edge(Vertex<T, N> toVertex, N weight, Edge<T, N> nextEdge) {
            this.toVertex = toVertex;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }

    private Vertex<T, N> head; //the head of the graph
    private int size; //the number of vertices in the graph G<V,E>

    public WeightedGraph() {
    }

    public int getSize() {
        //returns the number of vertices in the graph
        return size;
    }

    public T getHead() {
        return head.vertexInfo;
    }

    public boolean hasVertex(T vertexInfo) {
        //checks if the vertex exists (based on the given element)
        if (head == null) //if the graph is empty
            return false;

        Vertex<T, N> currentVertex = head; //starting from head
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

        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                // traverse until it reaches the source vertex
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
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
        Vertex<T, N> currentVertex = head; // starting from the head of the graph

        while (currentVertex != null) { // traverse until the final vertex
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0)
                return currentVertex.indeg; // if the vertex is found, return the indeg value;

            currentVertex = currentVertex.nextVertex;
        }

        return -1; // not found
    }

    public int getOutDeg(T vertexInfo) {
        Vertex<T, N> currentVertex = head; // starting from the head of the graph

        while (currentVertex != null) { // traverse until the final vertex
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0)
                return currentVertex.outdeg; // if the vertex is found, return the outdeg value;

            currentVertex = currentVertex.nextVertex;
        }

        return -1; // not found
    }

    public boolean addVertex(T vertexInfo) {
        if (!hasVertex(vertexInfo)) {
            Vertex<T, N> currentVertex = head; // starting from head vertex

            Vertex<T, N> newVertex = new Vertex<>(vertexInfo, null);

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

    public boolean addEdge(T sourceInfo, T destinationInfo, N weight) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo))
            //if the graph is empty OR the source and destination vertices don't exist
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

    public boolean addUndirectedEdge(T sourceInfo, T destinationInfo, N weight) {
        if (head == null || !hasVertex(sourceInfo) || !hasVertex(destinationInfo))
            //if the graph is empty OR the source and destination vertices don't exist
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
                        Edge<T, N> currentEdgeSource = sourceVertex.firstEdge;
                        Edge<T, N> newEdgeForward = new Edge<>(destinationVertex, weight, currentEdgeSource); //edge to dest

                        Edge<T, N> currentEdgeDest = destinationVertex.firstEdge;
                        Edge<T, N> newEdgeBackward = new Edge<>(sourceVertex, weight, currentEdgeDest); //edge to source

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

    public boolean removeEdge(T sourceInfo, T destinationInfo) {
        if (head == null)
            //if the graph is empty
            return false;

        Vertex<T, N> currentVertex = head;
        while (currentVertex != null) {
            if (currentVertex.vertexInfo.compareTo(sourceInfo) == 0) {
                //traverse until it reaches the source vertex
                Edge<T, N> currentEdge = currentVertex.firstEdge;
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
                    // go through all of the edges (outDegs) from the source vertex
                    if (currentEdge.toVertex.vertexInfo.compareTo(destinationInfo) == 0) // if there's an edge
                        // connecting to destination
                        // vertex
                        return currentEdge.weight;

                    currentEdge = currentEdge.nextEdge;
                }
            }

            sourceVertex = sourceVertex.nextVertex;
        }
        return null;
    }

    public ArrayList<T> getNeighbours(T vertexInfo) {
        if (!hasVertex(vertexInfo))
            return null;

        ArrayList<T> neighbours = new ArrayList<>();

        Vertex<T, N> currentVertex = head;
        while (currentVertex != null) {
            if (currentVertex.vertexInfo.compareTo(vertexInfo) == 0) {
                // traverse until given vertex
                Edge<T, N> currentEdge = currentVertex.firstEdge;

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

    public void printEdges() {
        Vertex<T, N> currentVertex = head;
        while (currentVertex != null) {
            System.out.print("# " + currentVertex.vertexInfo + " : ");
            Edge<T, N> currentEdge = currentVertex.firstEdge;

            while (currentEdge != null) {
                // go through all the edges from current vertex
                System.out.print("[" + currentVertex.vertexInfo + " --" + currentEdge.weight + "--> " + currentEdge.toVertex.vertexInfo + "]");

                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();

            currentVertex = currentVertex.nextVertex;
        }
    }
}
