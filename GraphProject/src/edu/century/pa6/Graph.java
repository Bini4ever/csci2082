package edu.century.pa6;

// File: Graph.java from the package EDU.colorado.graphs
// Complete documentation is available from the Graph link in
// http://www.cs.colorado.edu/~main/docs/

/******************************************************************************
* A <CODE>Graph</CODE> is a labeled graph with a fixed number of vertices.
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/Graph.java">
*   http://www.cs.colorado.edu/~main/EDU/colorado/collections/Graph.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
******************************************************************************/
public class Graph implements Cloneable
{
   // Invariant of the Graph class:
   //   1. The vertex numbers range from 0 to labels.length-1.
   //   2. For each vertex number i, labels[i] contains the label for vertex i.
   //   3. For any two vertices i and j, edges[i][j] is true if there is a
   //      vertex from i to j; otherwise edges[i][j] is false.  
   private boolean[ ][ ] edges;
   private Object[ ] labels;
   

   /**
   * Initialize a <CODE>Graph</CODE> with <CODE>n</CODE> vertices,
   * no edges, and null labels.
   * @param <CODE>n</CODE>
   *   the number of vertices for this <CODE>Graph<CODE>
   * <dt><b>Precondition:</b><dd>
   *   <CODE>n</CODE> is nonnegative.
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>Graph</CODE> has <CODE>n</CODE> vertices, numbered 
   *   <CODE>0<CODE> to <CODE>n-1</CODE>. It has no edges and all
   *   vertex labels are null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified number of nodes.
   * @exception NegativeArraySizeException
   *   Indicates that <CODE>n</CODE> is negative. 
   **/   
   public Graph(int n)
   {
      edges = new boolean[n][n];  // All values initially false
      labels = new Object[n];     // All values initially null
   }
   
   
   /**
   * Add a new edge to this <CODE>Graph</CODE>.
   * @param <CODE>source</CODE>
   *   the vertex number of the source of the new edge
   * @param <CODE>target</CODE>
   *   the vertex number of the target of the new edge
   * <dt><b>Precondition:</b><dd>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>Graph</CODE> has all the edges that it originally had plus
   *   another edge from the specified <CODE>source</CODE> to the specified
   *   <CODE>target</CODE>. (If the edge was already present, then this
   *   <CODE>Graph</CODE> is unchanged.)
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public void addEdge(int source, int target)   
   {
      edges[source][target] = true;
   }
   
      
   /**
   * Generate a copy of this <CODE>Graph</CODE>.
   * @param - none
   * @return
   *   The return value is a copy of this <CODE>Graph</CODE>. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to a <CODE>Graph</CODE> before it can be used.
   * @throws OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public Object clone( )
   {  // Clone a Graph object.
      Graph answer;
      
      try
      {
         answer = (Graph) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This would indicate an internal error in the Java runtime system
         // because super.clone always works for an Object.
         throw new InternalError(e.toString( ));
      }
      
      answer.edges = (boolean [ ][ ]) edges.clone( );
      answer.labels = (Object [ ]) labels.clone( );
      
      return answer;
   }
   


   
   
   /**
   * Accessor method to get the label of a vertex of this <CODE>Graph</CODE>. 
   * @param <CODE>vertex</CODE>
   *   a vertex number
   * <dt><b>Precondition:</b><dd>
   *   <CODE>vertex</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * @return
   *   the label of the specified vertex in this <CDOE>Graph</CODE>
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>vertex</CODE> was not a
   *   valid vertex number.
   **/
   public Object getLabel(int vertex)
   {
      return labels[vertex];
   }

 
   /**
   * Accessor method to determine whether this <CODE>Graph</CODE> contains
   * a specified edge.
   * @param <CODE>source</CODE>
   *   the vertex number of the source of the specified edge
   * @param <CODE>target</CODE>
   *   the vertex number of the target of the specified edge
   * <dt><b>Precondition:</b><dd>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * @return
   *   The return value is true if this <CODE>Graph</CODE> has an edge from the
   *   specified <CODE>source</CODE> to the specified <CODE>target</CODE>.
   *   Otherwise the return value is false.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public boolean isEdge(int source, int target)
   {
      return edges[source][target];
   }

   /**
   * Accessor method to obtain a list of neighbors of a specified vertex of
   * this <CODE>Graph</CODE>
   * @param <CODE>vertex</CODE>
   *   a vertex number
   * @param <CODE>target</CODE>
   *   a vertex number 
   * <dt><b>Precondition:</b><dd>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * <dt><b>Precondition:</b><dd>
   *   <CODE>vertex</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * @return
   *   The return value is an array that contains all the vertex numbers of
   *   vertices that are targets for edges with a source at the specified
   *   <CODE>vertex</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public int[ ] neighbors(int vertex)
   {
      int i;
      int count;
      int[ ] answer;
      
      // First count how many edges have the vertex as their source
      count = 0;
      for (i = 0; i < labels.length; i++)
      {
         if (edges[vertex][i])
            count++;
      }
           
      // Allocate the array for the answer
      answer = new int[count];
      
      // Fill the array for the answer
      count = 0;
      for (i = 0; i < labels.length; i++)
      {
         if (edges[vertex][i])
            answer[count++] = i;
      }
      
      return answer;
   }
              
   
   /**
   * Remove an edge from this <CODE>Graph</CODE>.
   * @param <CODE>source</CODE>
   *   the vertex number of the source of the removed edge
   * @param <CODE>target</CODE>
   *   the vertex number of the target of the removed edge
   * <dt><b>Precondition:</b><dd>
   *   Both <CODE>source</CODE> and <CODE>target</CODE> are nonnegative and
   *   less than <CODE>size()</CODE>.
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>Graph</CODE> has all the edges that it originally had minus
   *   the edge from the specified <CODE>source</CODE> to the specified
   *   <CODE>target</CODE>. (If the edge was not present, then this
   *   <CODE>Graph</CODE> is unchanged.)
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>source</CODE> or <CODE>target</CODE> was not a
   *   valid vertex number.
   **/
   public void removeEdge(int source, int target)   
   {
      edges[source][target] = false;
   }
   
   
   /**
   * Modification method to change the label of a vertex of this <CODE>Graph</CODE>. 
   * @param <CODE>vertex</CODE>
   *   a vertex number
   * @param <CODE>newLabel</CODE>
   *   a new label (which may be null)
   * <dt><b>Precondition:</b><dd>
   *   <CODE>vertex</CODE> is nonnegative and
   *   less than <CODE>size()</CODE>.
   * <dt><b>Postcondition:</b><dd>
   *   The label of the specified vertex in this <CDOE>Graph</CODE> has been
   *   changed to the <CODE>newLabel</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that the <CODE>vertex</CODE> was not a
   *   valid vertex number.
   **/
   public void setLabel(int vertex, Object newLabel)
   {
      labels[vertex] = newLabel;
   }   
   
   
   /**
   * Determine the number of vertices in this <CODE>Graph</CODE>.
   * @param - none
   * @return
   *   the number of vertices in this <CODE>Graph</CODE>
   **/ 
   public int size( )
   {
      return labels.length;
   }
	
}
        

           
