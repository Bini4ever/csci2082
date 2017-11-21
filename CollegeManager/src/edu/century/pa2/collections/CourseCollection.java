package edu.century.pa2.collections;

import edu.century.pa2.Course;
import edu.century.pa2.CourseNode;

public class CourseCollection 
{
	private CourseNode head;
	private CourseNode tail;
	private int numberOfNodes;
	
	public CourseCollection() {
		head = null;
		tail = null;
	}
	
	public void addEnd(Course element) {
		CourseNode cursor;
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()){
			if (cursor.getLink() == null) {
				CourseNode node = new CourseNode(element, null);
				cursor.setLink(node);
			}
		}
	}
	
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
	
	
	public boolean isEmpty() {
		return (numberOfNodes == 0);
	}
	
	
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
	
	public void addBeforeTarget(Course element, String targetElement) {
		
		if (head != null && head.getData().equals(targetElement)) {
			addFirst(element);
		} else {
			CourseNode nodeBefore = getNodeBeforeTarget(targetElement);
			nodeBefore.addNodeAfter(element);
			numberOfNodes++;
		}
	}
	
	public void addAfterTarget(Course element, Course targetElement) {
		
		if (tail != null && targetElement.equals(tail.getData())) {
			addLast(element);
		} else {
			CourseNode node = getTargetNode(targetElement);
			node.addNodeAfter(element);
			numberOfNodes++;
		}
	}
		
	public CourseNode getTargetNode(Course target) {
		
		CourseNode cursor;
		
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			Course element = cursor.getData();
			if (target.equals(element)); 
				return cursor;
		}
		
		return null;
		
	}
	
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
	
	public CourseNode getTail() {
		return tail;
	}
	
	public CourseNode getHead() {
		return head;
	}
	
	private int getSize() {
		return numberOfNodes;
	}
	
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
