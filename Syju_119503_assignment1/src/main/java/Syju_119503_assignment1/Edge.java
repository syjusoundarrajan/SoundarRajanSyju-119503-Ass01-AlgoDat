

//Class Edge defined for connections among city nodes
package Syju_119503_assignment1;

public class Edge implements Comparable<Edge> {

    private GermanCity sourceNode, destinationNode;
    private int weight;
    
    //constructor for undirected graph to define edge between source node and edge node with some fixed weight/distance
    public Edge(GermanCity sourceNode, GermanCity destinationNode){
        this(sourceNode, destinationNode, 1);
    }
    
  //constructor for undirected graph to define edge between source node and edge node with some weight/distance
    public Edge(GermanCity sourceNode, GermanCity destinationNode, int weight){
        this.sourceNode = (sourceNode.getLabel().compareTo(destinationNode.getLabel()) <= 0) ? sourceNode : destinationNode;
        this.destinationNode = (this.sourceNode == sourceNode) ? destinationNode : sourceNode;
        this.weight = weight;
    }
    
    
    //neighbour node of current edge
    public GermanCity getNeighbour(GermanCity current){
        if(!(current.equals(sourceNode) || current.equals(destinationNode))){
            return null;
        }
        
        return (current.equals(sourceNode)) ? destinationNode : sourceNode;
    }
    
    //return source node
    public GermanCity getSourceNode(){
        return this.sourceNode;
    }
    
    //return destination node
    public GermanCity getDestinationNode(){
        return this.destinationNode;
    }
    
    //return weight/distance value of edge
    public int getWeight(){
        return this.weight;
    }
    
    //set new weight/distance value for edge
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    //compare edge values
    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
    
    //string represent edge
    public String toString(){
        return "({" + sourceNode + ", " + destinationNode + "}, " + weight + ")";
    }
    
    //return hash code of edge
    public int hashCode(){
        return (sourceNode.getLabel() + destinationNode.getLabel()).hashCode(); 
    }
    
    //return true if edge with some nodes happened
    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        
        Edge e = (Edge)other;
        
        return e.sourceNode.equals(this.sourceNode) && e.destinationNode.equals(this.destinationNode);
    }   
}
