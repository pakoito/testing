package com.pobla.test.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Implementation of the Depth-first search algorithm in graphs.
 * The graphs is created using a provided dictionary and connecting thoses 
 * elements which only have one different letter. See {@link Node#isValidNeighbor(Node)}
 * @author Alberto Poblaci—n
 *
 */
public class DepthFirstSearch {

	private static final Logger log = Logger.getLogger(DepthFirstSearch.class);
	private HashSet<String> diccionary;


	public DepthFirstSearch(HashSet<String> diccionary) {
		this.diccionary = diccionary;
	}

	
	private List<Node> getAdjacentList(Node currentNode) {
		List<Node> neighbours = new ArrayList<Node>();

		Iterator<String> iterator = getDiccionary().iterator();
		while (iterator.hasNext()) {
			String data = iterator.next();
			if (currentNode.isValidNeighbor(data)) {
				Node neighbor = new Node(data);
				neighbor.setParent(currentNode);
				neighbours.add(neighbor);
			}
		}
		return neighbours;
	}

	/**
	 * Do a search using the diccionary provided, and trying to reach the goal node from the start one.
	 * @param start
	 * @param goal
	 * @return
	 */
	public Node search(Node start, Node goal) {
		// Set for keeping visited nodes
		HashSet<String> visited = new HashSet<String>();

		// Do the DFS from each node not already visited
		for (Node node : getAdjacentList(start)) {
			if (!visited.contains(node.getData())) {
				node = DFS(node, visited, goal);
				if (node == null) {
					log.debug("Solution is not reacheble, use other path");
				} else{
					return node;
				}
			}
		}

		return null;
	}

	// perform a DFS starting at node at (works recursively)
	private Node DFS(Node current, HashSet<String> visited, Node goal) {
		// Mark node as visited
		visited.add(current.getData());

		// recursively visit every node in the adjacent list to the current one and check if it is the goal
		for (Node node : getAdjacentList(current)) {

			if (!visited.contains(node.getData())) {
				if (node.equals(goal)) {
					return node;
				} else {
					return DFS(node, visited, goal);
				}
			}
		}
		return null;

	}

	public HashSet<String> getDiccionary() {
		return diccionary;
	}

	public void setDiccionary(HashSet<String> diccionary) {
		this.diccionary = diccionary;
	}
}