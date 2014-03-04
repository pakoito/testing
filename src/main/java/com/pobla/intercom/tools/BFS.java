package com.pobla.intercom.tools;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


public class BFS {


    public static List<Node> doSearch(Node start, Node end) {
        List<Node> path = new ArrayList<Node>();
        Queue<Node> nodes = new LinkedBlockingDeque<Node>();
        Set<Node> nodeSet = new HashSet<Node>();
        path.add(start);
        nodes.add(start);
        nodeSet.add(start);

        while (!nodes.isEmpty()) {
            Node currentNode = nodes.poll();
            if (currentNode != null && currentNode.getData().equals(end.getData())) {
                path.add(currentNode);
                System.out.println("END " + currentNode.getData() + " FOUND");
                return path;
            }
            for (Node neigh : getAdjacentList(currentNode)) {
                if (!nodeSet.contains(neigh)) {
                    nodeSet.add(neigh);
                    nodes.add(neigh);
                    //System.out.println("Node " + neigh.getData() + " added");
                }
            }
        }
        return path;

    }

    private static List<Node> getAdjacentList(Node currentNode) {
        List<Node> neighbours = new ArrayList<Node>();
        String nodeData = currentNode.getData();
        for (int i = 0; i < nodeData.length(); i++) {
            for (char j = 97; j < 123; j++) {
                if (nodeData.charAt(i) != j) {
                    StringBuilder myName = new StringBuilder(nodeData);
                    myName.setCharAt(i, j);
                    String result = myName.toString();
                    neighbours.add(new Node(result));
                }
            }
        }
        return neighbours;
    }

    public void DFS(Node start, Node goal) {
        HashSet<String> visited = new HashSet<String>(); // a visited array to mark which vertices have been visited while doing the DFS

        int numComponets = 0; // the number of components in the graph

        // do the DFS from each node not already visited
        for (Node node : getAdjacentList(start)) {
            if (!visited.contains(node.getData())) {
                ++numComponets;
                //System.out.printf("Starting a DFS for component %d starting at node %d%n", numComponets, i);

                node = DFS(node, visited, goal);
            }

            System.out.println("Encontre el node: " + node.getData());
            System.out.printf(String.format("Finished with DFS - found %d components", numComponets));
        }
    }

    // perform a DFS starting at node at (works recursively)

    public Node DFS(Node at, HashSet<String> visited, Node goal) {
//        System.out.printf("At node %d in the DFS%n", at);

        // mark that we are visiting this node
        visited.add(at.getData());

        // recursively visit every node connected to this that we have not already visited
        for (Node node : getAdjacentList(at)) {

            if (!visited.contains(node.getData())) {
                if (node.getData().equals(goal.getData())) {
                    return node;
                } else {
                    return DFS(node, visited, goal);
                }
            }

            //System.out.printf("Done processing node %d%n", at);
        }
        return null;

    }
}