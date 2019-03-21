import ds.Graph;

public class App {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Daniel");
        graph.addVertex("Olchik");
        graph.addVertex("Den");
        graph.addEdge("Daniel", "Olchik");
        graph.show();
    }
}
