package sait.sll.utility;

import java.io.Serializable;

/**
 * 
 * This class inherits LinkedListADT and Serializable. And It shows functions of LinkedList.
 * @author Hong and Kim
 * @version 21-07-2020
 *
 *
 */
public class SLL implements LinkedListADT, Serializable{
	
	//attribute
	private Node head;
	private int size;

	public SLL() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Checks if the list is empty.
	 * @return True if it is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}
	/**
	 * Clears the list.
	 */
	@Override
	public void clear() {
		this.head = null;

	}
	/**
	 * Adds to the end of the list.
	 * @param data Data to append.
	 */
	@Override
	public void append(Object data) {
		Node newNode = new Node(data);
		Node currentNode = this.head;
		// case of size 0
		if (this.size == 0) {
			prepend(data);
			return;
		}
		// find last node
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		// set the new Node's address into previous last Node.
		currentNode.setNext(newNode);
		this.size++;

	}
	/**
	 * Prepends (adds to beginning) data to the list.
	 * @param data Data to store inside element.
	 */
	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);
		newNode.setNext(this.head);
		this.head = newNode;
		this.size++;

	}
	/**
	 * Adds a new element at a specific position.
	 * @param data Data that element is to contain.
	 * @param index Index to add new element at.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
	 */
	@Override
	public void insert(Object data, int index){
		// according to index, it can throw exception.
		if(index < 0 || index >=this.size) {
			throw new IndexOutOfBoundsException();
		}
		//case of index 0
		if (index == 0) {
			prepend(data);
			return;
		// case of last index 
		} else if (index == this.size - 1) {
			append(data);
			return;
		}
		// case of middle index
		Node prevNode = this.head;
		Node newNode = new Node(data);
		// find index position
		for (int i = 0; i < index - 1; i++) {
			prevNode = prevNode.getNext();
		}
		// connecting previous Node and next Node with new Node.
		newNode.setNext(prevNode.getNext());
		prevNode.setNext(newNode);
		this.size++;

	}
	/**
	 * Replaces the data  at index.
	 * @param data Data to replace.
	 * @param index Index of element to replace.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	@Override
	public void replace(Object data, int index){
		// according to index, it can throw exception.
		if(index < 0 || index >=this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node prevNode = this.head;
		//case of size 0
		if (this.size == 0) {
			return;
		// case of index 0
		} else if (index == 0) {

			prevNode.setData(data);
			return;
		}
		// find index position
		for (int i = 0; i < index; i++) {
			prevNode = prevNode.getNext();
		}
		prevNode.setData(data);
		return;

	}
	/**
	 * Gets the number of elements in the list.
	 * @return Size of list (0 meaning empty)
	 */
	@Override
	public int size() {
		return this.size;
	}
	/**
	 * Removes element at index from list, reducing the size.
	 * @param index Index of element to remove.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size - 1.
	 */
	@Override
	public void delete(int index){
		// according to index, it can throw exception.
		if(index < 0 || index >=this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node prevNode = this.head;
		Node currentNode;
		// case of size 0
		if (this.size == 0) {
			return;
		} 
		// case of index 0
		if (index == 0) {
			this.head = prevNode.getNext();
			prevNode.setNext(null);
			this.size--;
		// case of last index	
		} else if (index == this.size - 1) {
			while (prevNode.getNext().getNext() != null) {
				prevNode = prevNode.getNext();
			}
			prevNode.setNext(null);
			this.size--;
		// case of middle index	
		} else {
			// find previous index position
			for (int i = 0; i < index - 1; i++) {
				prevNode = prevNode.getNext();
			}
			// connect next Node to previous Node and then delete current Node.
			currentNode = prevNode.getNext();
			prevNode.setNext(currentNode.getNext());
			currentNode.setNext(null);
			this.size--;
		}

	}
	/**
	 * Gets the data at the specified index.
	 * @param index Index of element to get.
	 * @return Data in element or null if it was not found.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of the list.
	 */
	@Override
	public Object retrieve(int index) {
		// according to index, it can throw exception.
		if(index < 0 || index >=this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node currentNode = this.head;
		// case of size 0
		if(this.size == 0) {
			return null;
		}
		// case of index 0
		if(index == 0) {
			return currentNode.getData();
		// case of last index
		}else if(index == this.size -1) {
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getData();
		// case of middle index	
		}else {
			for(int i=0; i< index; i++) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getData();
		}
	}
	/**
	 * Gets the first index of element containing data.
	 * @param data Data object to find the first index of.
	 * @return First of index of element with matching data or -1 if not found.
	 */
	@Override
	public int indexOf(Object data) {
		Node currentNode = this.head;
		// case of size 0
		if (this.size() == 0) {
			return -1;
		}
		// find Node which has same data
		for (int i = 0; i < this.size(); i++) {
			if (currentNode.getData().equals(data)) {
				return i;
			}
			currentNode = currentNode.getNext();
		}

		return -1;
	}
	/**
	 * Go through elements and check if we have one with data.
	 * @param data Data object to search for.
	 * @return True if element exists with value.
	 */
	@Override
	public boolean contains(Object data) {
		Node currentNode = this.head;
		int count = 0;
		// find Node which has same data, then add count
		for(int i=0; i< this.size; i++) {
			if(currentNode.getData().equals(data)) {
				count ++;
			}
			currentNode = currentNode.getNext();
		}
		return count > 0 ? true : false;

	}

}
