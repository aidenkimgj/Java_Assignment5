package sait.sll.utility;

import java.io.Serializable;

/**
 * This class create and modify the Node also it is serializable.
 * 
 * @author Hong and Kim
 * @version 21-07-2020
 * 
 *
 */
public class Node implements Serializable {
	// attribute
	private Object data;
	private Node next;
	
	/**
	 * This is Node class constructor, it can set the data in the Node.
	 * @param data - in order to store data into Node
 	 */
	public Node(Object data) {
		this.data = data;
	}

	/**
	 * This method return the data from Node.
	 * @return data - get the data from Node.
	 */
	public Object getData() {
		return data;
	}

	/**
	 * This method set the data into Node.
	 * @param data - set the data to Node.
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * This method return the next Node's address.
	 * @return next - get the next Node's address.
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * This method set the next Node's address.
	 * @param next - set the next Node's address.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
