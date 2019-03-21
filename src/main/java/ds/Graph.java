package ds;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Map<Vertex, List<Vertex>> graph;

    public Graph(){
        graph = new HashMap<>();
    }

    public void addVertex(String label){
        graph.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label){
        Vertex vertex = new Vertex(label);
        graph
                .values()
                .stream()
                .map(v -> v.remove(v))
                .collect(Collectors.toList());
        graph.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2){
        Vertex firstVertex = new Vertex(label1);
        Vertex secondVertex = new Vertex(label2);
        graph
                .get(firstVertex)
                .add(secondVertex);
        graph
                .get(secondVertex)
                .add(firstVertex);
    }

    public void removeEdge(String label1, String label2){
        Vertex firstVertex = new Vertex(label1);
        Vertex secondVertex = new Vertex(label2);
        List<Vertex> firstList = firstVertex.links;
        List<Vertex> secondList = secondVertex.links;
        if(firstList != null){
            firstList.remove(secondVertex);
        }
        if(secondList != null){
            secondList.remove(firstVertex);
        }
    }

    public void show(){
        for(Map.Entry<Graph.Vertex, List<Graph.Vertex>> entry : graph.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    public Map<Vertex, List<Vertex>> getGraph() {
        return graph;
    }

    public class Vertex{
        private String value;
        private ArrayList<Vertex> links;
        public Vertex(String value){
            this.value= value;
            links= new ArrayList<>();
        }
        @Override
        public String toString() {
            return value;
        }
    }
}
