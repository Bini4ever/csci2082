package edu.century.pa2;

public class CourseNode 
{
	private Course data;
	private CourseNode link;
	
    //Initialize a node with a specified initial data and link to the next
	public CourseNode(Course initialData, CourseNode initialLink)
	{
		this.data = initialData;
		this.link = initialLink;
	}
	
	
	//Accessor method to get the data from this node.   
	public Course getData()
	{
		return this.data;
	}
	
	//Accessor method to get a reference to the next node after this node. 
	public CourseNode getLink()
	{
		return this.link;
	}
	
	//Modification method to set the data in this node.   
	public void setData(Course newData)   
	   {
	      this.data = newData;
	   }  
	
	//Modification method to set the link to the next node after this node.
	public void setLink(CourseNode newLink)
	   {                    
	      this.link = newLink;
	   }
	
	//Modification method to add a new node after this node.   
		public void addNodeAfter(Course item)
		{
			link = new CourseNode(item, link);
		}
		
		public void removeNodeAfter(){
			this.link = link.link;
		}
}
