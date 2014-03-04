package com.pobla.intercom.tools;

/**
 * Created by Pobla on 04/03/2014.
 */
public class Node {

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private String data;
	private Node parent;

	public Node(String string) {
		this.data = string;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != this.getClass()) {
			return false;
		}
		Node newNode = (Node) object;
		return this.getData().equals(newNode.getData());
		
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Returns true if the number of different letters is 1, false otherwise.
	 * @param neighbor
	 * @return
	 */
	public boolean isValidNeighbor(String neighbor) {
		int result = 0;

		if (neighbor == null || neighbor.length() != data.length())
			return false;

		for (int i = 0; (i < data.length()) && (result <= 1); i++) {
			if (neighbor.charAt(i) - data.charAt(i) != 0) {
				result++;
			}
		}
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}
}
