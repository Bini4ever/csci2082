package edu.century.pa6;

/************************************************************
 * LabeledGraph is a derived class from Graph
 * @author biniamlemma
 *
 ************************************************************/
public class LabeledGraph extends Graph{
	// Invariant of the Graph class:
	private boolean[][] edges;
	private Object[] labels;
	
	//Constructor to Initialize a LabledGraph as well as the parent class
	public LabeledGraph(int n) {
		super(n);
		edges = new boolean[n][n];
		labels = new Object[n];
	}
	
	//Add a new adge to LabeledGraph
	 public void addEdge(int source, int target)   
	   {
	     this.edges[source][target] = true;
	   }
	
	 //clone method
	 public Object clone(){
		 return super.clone();
	 }

	 // Accessor method to determine whether the labeledGraph cpmtaoms 
	 // a specofided ade.
	 public boolean isEdge(int source, int target)
	   {
	      return this.edges[source][target];
	   }
	 
	 // Accessor method to obtain a list of neighbors of a specified vertx 
	 // of the labeledGraph
	 public int[] neighbors(int vertex){
		  int i;
		  int count;
		  int[ ] answer;
		  
		  // First count how many edges have the vertex as their source
		  count = 0;
		  for (i = 0; i < this.labels.length; i++)
		  {
		     if (this.edges[vertex][i])
		        count++;
		  }
		       
		  // Allocate the array for the answer
		  answer = new int[count];
		  
		  // Fill the array for the answer
		  count = 0;
		  for (i = 0; i < this.labels.length; i++)
		  {
		     if (this.edges[vertex][i])
		        answer[count++] = i;
		  }
		  
		  return answer;
	 }
	 
	 
	 // Remove an edge from the labeledGraph
	 public void removeEdge(int source, int target)   
	   {
	     this.edges[source][target] = false;
	   }
	 
	// Accessor method to get the labeld of a vertex of the labeledGraph
	public Object[] getLabels(int vertex) {
		return (Object[]) labels[vertex];
	}

	// Modification method to change the labeld of a vertex of the labeledGraph
	public void setLabels(int vertex, Object[] labels) {
		this.labels[vertex] = labels;
	}
	
	// Determine the number of vertices in the labledGraph
	public int size(){
		return this.labels.length;
	}
	
	
	
	
	
	
}
