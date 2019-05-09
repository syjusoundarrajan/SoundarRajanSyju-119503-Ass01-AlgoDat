//Class GraphDemo represent complete graph by execute all graph methods
package Syju_119503_assignment1;

public class GraphPrint {
   
   public static void main(String[] args){
       Graph graph = new Graph();
       //choose number of cities to implement a graph
       GermanCity[] nodes = new GermanCity[5];
       String[] germanCityNames = {"Augsburg","Berlin","Cologne","Dusseldorf","Essen"};
       for(int i = 0; i < nodes.length; i++){
           nodes[i] = new GermanCity(germanCityNames[i]);
           graph.addGermanCity(nodes[i], true);
       }
       
       //add edges among nodes
       for(int i = 0; i < nodes.length - 1; i++){
           for(int j = i + 1; j < nodes.length; j++){
              graph.addEdge(nodes[i], nodes[j]);
              graph.addEdge(nodes[i], nodes[j]);
              graph.addEdge(nodes[j], nodes[i]);
           }
       }
       
       //display adjucent nodes
       for(int i = 0; i < nodes.length; i++){
           System.out.println(nodes[i]);
           
           for(int j = 0; j < nodes[i].getNeighbourNodesCount(); j++){
               System.out.println(nodes[i].getNeighbourNode(j));
           }
           
           System.out.println();
       }
       
       //overwrite existed node with specific node
       graph.addGermanCity(new GermanCity("FrankFurt"), true);
       for(int i = 0; i < nodes.length; i++){
           System.out.println(nodes[i]);
           
           for(int j = 0; j < nodes[i].getNeighbourNodesCount(); j++){
               System.out.println(nodes[i].getNeighbourNode(j));
           }
           
           System.out.println();
       }
       
       System.out.println("In the graph node 5 is : " + graph.getNode("Essen")); //null
       System.out.println("In the graph node 3 is : " + graph.getNode("Cologne")); //Vertex 3
       
       //true
       System.out.println("Connection between AUGSBURG and BERLIN BEfore Removing edge: " +
               graph.containsEdge(new Edge(graph.getNode("Augsburg"), graph.getNode("Berlin"))));
       
       //true
       System.out.println(graph.removeEdge(new Edge(graph.getNode("Augsburg"), graph.getNode("Berlin")))); 
       
       //false
       System.out.println("Connection between AUGSBURG and BERLIN After Removing edge:  " + graph.containsEdge(new Edge(graph.getNode("Augsburg"), graph.getNode("Berlin"))));
       
       //false
       System.out.println("Graph Contains edge {2, 3} " + graph.containsEdge(new Edge(graph.getNode("Berlin"), graph.getNode("Cologne"))));
       System.out.println("Is Graph contains AUGSBURG city????");
       System.out.println(graph.containsNode(new GermanCity("Augsburg"))); //true
       System.out.println("Is Graph contains GELSENKIRCHEN city????");
       System.out.println(graph.containsNode(new GermanCity("Gelsenkirchen"))); //false
       System.out.println(graph.removeNode("Berlin")); //Vertex 2
       System.out.println("Graph when removed BERLIN City");
       System.out.println(graph.nodeKeys()); //[3, 1, 0, 4]
       
   }
}
