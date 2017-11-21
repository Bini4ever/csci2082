package edu.century.pa2.collections;

import edu.century.pa2.Course;
import edu.century.pa2.CourseNode;

// Course Collection class 
public class CourseCollection implements Cloneable
{
	private CourseNode head;
	private CourseNode tail;
	private int numberOfNodes;
	
	// Constractor method
	public CourseCollection() {
		head = null;
		tail = null;
	}
	
	/*********************************************************************
	 * addEnd method that adds a Course element to the end of the Node    * 
	 * ******************************************************************/
	public void addEnd(Course element) {
		CourseNode cursor;
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()){
			if (cursor.getLink() == null) {
				CourseNode node = new CourseNode(element, null);
				cursor.setLink(node);
			}
		}
	}
	
	/***************************************************************************
	 * addFirst method that adds a Course element to the beginning of the Node * 
	 * *************************************************************************/
	public void addFirst(Course element) {
		if(head == null){
			head = new CourseNode(element, null);
			tail = head;
			numberOfNodes++;
		}else {
			head = new CourseNode(element, head);
			numberOfNodes++;
		}
	}
	
	/*********************************************************************
	 * addEnd method that adds a Course element to the end of the Node   *
	 * ******************************************************************/
	public void addLast(Course element) {
		if (head == null) {
			head = new CourseNode(element, null);
			tail = head;
			numberOfNodes++;
		} else {
			CourseNode temp = new CourseNode(element, null);
			tail.setLink(temp);
			tail = tail.getLink();
			numberOfNodes++;
		}
	}
	
	
	/*********************************************************************
	 * isEmpty method that checks whether the Node is empty or not
	 * 
	 * ******************************************************************/
	public boolean isEmpty() {
		return (numberOfNodes == 0);
	}
	
	
	/*********************************************************************
	 * removeFirst method to remove the the first element in the Node
	 * 
	 * ******************************************************************/
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("Empty list");
			return;
		} 
		
		if (head.getLink() == null) {
			head = null;
			tail = null;
			numberOfNodes--;
		} else {
			head = head.getLink();
			numberOfNodes--;
		}
	}
	
	/*********************************************************************
	 * removeLast method to remove the last element in the Node
	 * 
	 * ******************************************************************/
	public void removeLast() {
		if (head != null && head == tail) {
			head = null;
			tail = head;
			numberOfNodes--;
		} else {
			CourseNode currentNode;
			CourseNode nodeBefore;
			
			for (currentNode = head, nodeBefore = null; currentNode != null; 
					nodeBefore = currentNode, currentNode = currentNode.getLink()) {
				
				if (currentNode == tail) {
					tail = nodeBefore;
					tail.setLink(null);
					numberOfNodes--;
				}
			}
		}
	}
	
	/*********************************************************************
	 * removeTarget to remove the target element
	 * 
	 * ******************************************************************/
	public void removeTarget(String target) {
			
		
			if (head.getData() != null && target.equals(head.getData().getCourseName())) {
				removeFirst();
				return;
			} else if (target.equals(tail.getData())) {
				removeLast();
				return;
			} else {
				CourseNode nodeBefore = getNodeBeforeTarget(target);
				
				if (nodeBefore != null) {
					nodeBefore.removeNodeAfter();
					numberOfNodes--;
				}
			}
		}
	
	/*********************************************************************
	 * addBeforeTarget method that adds element before the target element
	 * 
	 * ******************************************************************/
	public void addBeforeTarget(Course element, String targetElement) {
		
		if (head != null && head.getData().equals(targetElement)) {
			addFirst(element);
		} else {
			CourseNode nodeBefore = getNodeBeforeTarget(targetElement);
			nodeBefore.addNodeAfter(element);
			numberOfNodes++;
		}
	}
	
	/*********************************************************************
	 * addAfterTarget method that adds element after the target element
	 * 
	 * ******************************************************************/
	public void addAfterTarget(Course element, Course targetElement) {
		
		if (tail != null && targetElement.equals(tail.getData())) {
			addLast(element);
		} else {
			CourseNode node = getTargetNode(targetElement);
			node.addNodeAfter(element);
			numberOfNodes++;
		}
	}
		
	/*********************************************************************
	 * getTargetNode method that returns the target Node
	 * 
	 * ******************************************************************/
	public CourseNode getTargetNode(Course target) {
		
		CourseNode cursor;
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			Course element = cursor.getData();
			if (target.equals(element)); 
				return cursor;
		}
		
		return null;
		
	}
	
	/*********************************************************************
	 * GetNodeBeforeTarget method that returns the node of element before 
	 * target 
	 * ******************************************************************/
	public CourseNode getNodeBeforeTarget(String target) {
		CourseNode currentNode;
		CourseNode nodeBefore;
		
		for (currentNode = head, nodeBefore = null; currentNode != null; nodeBefore = currentNode, currentNode = currentNode.getLink()) {
			Course data = currentNode.getData();
			
			if (target.equals(data.getCourseName())) {
				return nodeBefore;
	
			}
		}
		
		return null;
	}
	
	/*********************************************************************
	 * getPosition method to get the position of the target element
	 * 
	 * ******************************************************************/
	public int getPosition(Course target) {
		CourseNode cursor;
		int position = 0;
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			
			position++;
			if (cursor.getData().equals(target)) {
				return position;
			}
			
		}
		
		return -1;
	}
	
	
	/*********************************************************************
	 * getTail method to get the tail									 * 
	 * ******************************************************************/
	public CourseNode getTail() {
		return tail;
	}
	
	/*********************************************************************
	 * getHead method to get the head                                    * 
	 * ******************************************************************/
	public CourseNode getHead() {
		return head;
	}
	
	/*********************************************************************
	 * Clone method that copies the CourseCollection to copy
	 * 
	 * ******************************************************************/
	@Override
	public Object clone()  {
		CourseCollection copy = null;
		
		try {
			copy = (CourseCollection) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		copy.head = CourseNode.listCopy(head);
		return copy;
	}
	
	/*********************************************************************
	 * getSize method that get the number of the Nodes
	 * 
	 * ******************************************************************/
	private int getSize() {
		return numberOfNodes;
	}
	
	/*********************************************************************
	 * toString method that displays the CourseCollection
	 * 
	 * ******************************************************************/
	public String toString() {
		
		
		CourseNode cursor;
		String ret = "";
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			ret += cursor.getData();
			if (cursor.getLink() != null)
				ret += "\n";
		}
		return ret;
	}

}
