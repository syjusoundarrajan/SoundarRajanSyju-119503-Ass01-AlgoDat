
//This java Class called GermanCity represents the required node of ourgraph

package Syju_119503_assignment1;

import java.util.ArrayList;

public class GermanCity {

    private ArrayList<Edge> neighbourNode;
    private String label;
    
    //The required specific city name has been labeled to as the node
    public GermanCity(String label){
        this.label = label;
        this.neighbourNode = new ArrayList<Edge>();
    }
    
    // This part creates an edge if node has no edge with the next node
    public void addNeighbourNode(Edge edge){
        if(this.neighbourNode.contains(edge)){
            return;
        }
        
        this.neighbourNode.add(edge);
    }
    
    //This part of our code checks whether edge is present or not with our neighbour node
    public boolean containsNeighbourNode(Edge other){
        return this.neighbourNode.contains(other);
    }
    
    //Retrieve or get the index our node
    public Edge getNeighbourNode(int index){
        return this.neighbourNode.get(index);
    }
    
    // This part removes the specific indexed node
    Edge removeNeighbourNode(int index){
        return this.neighbourNode.remove(index);
    }
    
    // This part removes the specific edge between our nodes
    public void removeNeighbourNode(Edge e){
        this.neighbourNode.remove(e);
    }
    
    //This part helps us to get the number of neighbour nodes present
    public int getNeighbourNodesCount(){
        return this.neighbourNode.size();
    }
    
    //The the name or the label of the node
    public String getLabel(){
        return this.label;
    }
    
    //City name as visible in the output
    public String toString(){
        return "German City " + label;
    }
    
    //This part helps in labelling the node
    public int hashCode(){
        return this.label.hashCode();
    }
    
    //This part of the code compares whether the two nodes labels are equal or not
    public boolean equals(Object other){
        if(!(other instanceof GermanCity)){
            return false;
        }
        
        GermanCity v = (GermanCity)other;
        return this.label.equals(v.label);
    }
    
    //This part helps us to get the list of our neighbour nodes
    public ArrayList<Edge> getNeighbourNodes(){
        return new ArrayList<Edge>(this.neighbourNode);
    }
    
}
