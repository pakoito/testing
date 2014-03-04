package com.pobla.intercom;

import java.util.HashSet;

import org.apache.log4j.Logger;

import com.pobla.intercom.tools.DepthFirstSearch;
import com.pobla.intercom.tools.Node;

/**
 * Created by Pobla on 03/03/2014.
 */
public class SequenceWords {

	private static final Logger log = Logger.getLogger(SequenceWords.class);

	public Node findSequence(String from, String to, HashSet<String> diccionary) {
		
		if(from == null || to == null){
			log.warn("Unable to look for null nodes");
			return null;
		}
		if(diccionary== null || diccionary.isEmpty()){
			log.warn("Unable generate graph");
			return null;
		}

		DepthFirstSearch dfs = new DepthFirstSearch(diccionary);

		Node result = dfs.search(new Node(from), new Node(to));
		if (result == null) {
			log.warn(String.format("Element %s couldn't be reached from %s", to, from));
			return null;
		}
		
		Node parent = result.getParent();
		StringBuffer sb = new StringBuffer();
		while (parent != null) {
			sb.insert(0, " -> ");
			sb.insert(0, parent.getData());
			parent = parent.getParent();
		}
		sb.append(result.getData());

		log.debug("Node found: " + result.getData());
		log.debug("Node path : " + sb.toString());
		return result;

	}

}
