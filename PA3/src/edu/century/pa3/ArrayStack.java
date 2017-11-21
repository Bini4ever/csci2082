package edu.century.pa3;

import java.util.EmptyStackException;

public class ArrayStack<E> {
	private final int CAPACITY = 100;
	private int top;
	private E[] data;
	
	public ArrayStack(){
		top = 0;
		data = (E []) (new Object[CAPACITY]);
	}
	
	/**********************************************
	* empty method to check if the stack is empty
	**********************************************/
	public boolean empty() {
		return (top == 0);
	}
	
	/*****************************************************
	* push method to push an item to the top of the stack
	******************************************************/
	public void push (E  element){
		if (data.length == top){
			throw new EmptyStackException();
		}
		data[top] =element;
		top++;
	}
	
	/**********************************************
	* pop method to remove the object at the top of 
	* stack and returns that object.
	**********************************************/
	public E pop(){
		if (empty()) {
			throw new EmptyStackException();
		}
		E element = data[top - 1];
		top--;
		return element;
	}
	/**********************************************
	* to look at the object at the top of the stack
	*  without removing it from the stack
	**********************************************/
	public E peek(){
		if (empty()){
			throw new EmptyStackException();
		}
		return data[top-1];
	}
	
	/**********************************************
	* size method to find the size of the stack
	**********************************************/
	public int size(){
		return top;
	}
	
	/****************************************************
	* getCapacity method to find the length of the stack
	*****************************************************/
	public int getCapacity(){
		return data.length;
	}	
}
