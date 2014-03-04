package com.pobla.intercom;

import com.pobla.intercom.tools.BFS;
import com.pobla.intercom.tools.Node;
import org.apache.log4j.Logger;

/**
 * Created by Pobla on 03/03/2014.
 */
public class SequenceWords {

    private static final Logger log = Logger.getLogger(SequenceWords.class);

    public String findSequence(String from, String to) {
        BFS bfs = new BFS();
        //bfs.doSearch(new Node(from), new Node(to));
        bfs.DFS(new Node(from), new Node(to));
        return ";";

    }


}
