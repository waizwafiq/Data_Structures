public class Graph<T extends Comparable<T>, N extends Comparable<N>> {

    private class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
        T vertexInfo;
        int indeg, outdeg;
        Vertex<T, N> nextVertex; // reference to next vertex/node
        Edge<T, N> firstEdge; // reference to the first edge node

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
        Vertex<T,N> toVertex;
        N weight;
        Edge<T,N> nextEdge;

        public Edge() {
            toVertex = null;
            weight = null;
            nextEdge = null;
        }

        public Edge(Vertex<T,N> destination, N weight, Edge<T,N> nextEdge){
            this.toVertex = destination;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }
}
