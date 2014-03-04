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

	private HashSet<String> diccionary = new HashSet<String>();

	public Node findSequence(String from, String to) {
		diccionary.add("dog");
		diccionary.add("cod");
		diccionary.add("cot");
		diccionary.add("cat");
		diccionary.add("dat");
		diccionary.add("qog");
		diccionary.add("wog");
		diccionary.add("eog");
		diccionary.add("rot");
		diccionary.add("tot");
		diccionary.add("yot");
		diccionary.add("czg");
		diccionary.add("cxg");
		diccionary.add("ccg");
		diccionary.add("cvg");
		diccionary.add("dow");
		diccionary.add("cog");
		diccionary.add("daw");
		diccionary.add("dqq");
		diccionary.add("cag");
		diccionary.add("dhe");
		diccionary.add("poi");
		diccionary.add("zxw");
		diccionary.add("wqx");
		diccionary.add("cat");
		diccionary.add("cat");
		diccionary.add("cyw");
		diccionary.add("cgq");
		diccionary.add("csg");
		diccionary.add("xod");
		diccionary.add("czw");
		diccionary.add("vat");
		diccionary.add("bog");

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
