// Class Graph represents nodes and their connected edges
package Syju_119503_assignment1;

import java.util.*;

public class Graph {
    
    private HashMap<String, GermanCity> nodes;
    private HashMap<Integer, Edge> edges;
    //constructor to initialize all German city nodes
    public Graph(){
        this.nodes = new HashMap<String, GermanCity>();
        this.edges = new HashMap<Integer, Edge>();
    }
    
    //constructor for list of populated nodes in graph
    public Graph(ArrayList<GermanCity> nodes){
        this.nodes = new HashMap<String, GermanCity>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(GermanCity n: nodes){
            this.nodes.put(n.getLabel(), n);
        }
        
    }
    
    //checks an edge to graph
    public boolean addEdge(GermanCity sourceNode, GermanCity destinationNode){
        return addEdge(sourceNode, destinationNode, 1);
    }
    
    
    //checks if no edge already in graph
    public boolean addEdge(GermanCity sourceNode, GermanCity destinationNode, int weight){
        if(sourceNode.equals(destinationNode)){
            return false;   
        }
       
        //ensures the Edge is not in the Graph
        Edge e = new Edge(sourceNode, destinationNode, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
       
        //and that the Edge isn't already incident to one of the vertices
        else if(sourceNode.containsNeighbourNode(e) || destinationNode.containsNeighbourNode(e)){
            return false;
        }
            
        edges.put(e.hashCode(), e);
        sourceNode.addNeighbourNode(e);
        destinationNode.addNeighbourNode(e);
        return true;
    }
    
    //check weather edge existed or not in graph
    public boolean containsEdge(Edge e){
        if(e.getSourceNode() == null || e.getDestinationNode() == null){
            return false;
        }
        
        return this.edges.containsKey(e.hashCode());
    }
    
    
    //removes sepcific edge from graph
    public Edge removeEdge(Edge e){
       e.getSourceNode().removeNeighbourNode(e);
       e.getDestinationNode().removeNeighbourNode(e);
       return this.edges.remove(e.hashCode());
    }
    
    //checks specific node existed in graph or not
    public boolean containsNode(GermanCity node){
        return this.nodes.get(node.getLabel()) != null;
    }
    
    //get node with specific name
    public GermanCity getNode(String label){
        return nodes.get(label);
    }
    
    //add node to graph
    public boolean addGermanCity(GermanCity node, boolean isExisted){
        GermanCity current = this.nodes.get(node.getLabel());
        if(current != null){
            if(!isExisted){
                return false;
            }
            
            while(current.getNeighbourNodesCount() > 0){
                this.removeEdge(current.getNeighbourNode(0));
            }
        }
        nodes.put(node.getLabel(), node);
        return true;
    }
    
    //remove node from graph
    public GermanCity removeNode(String label){
        GermanCity n = nodes.remove(label);
        
        while(n.getNeighbourNodesCount() > 0){
            this.removeEdge(n.getNeighbourNode((0)));
        }
        
        return n;
    }
    
    //to avoid duplicate names of node
    public Set<String> nodeKeys(){
        return this.nodes.keySet();
    }
    
    //get edges of graph
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
    
}
