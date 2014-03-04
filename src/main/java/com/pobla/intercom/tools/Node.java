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

    public Node(String string) {
        this.data = string;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Node) obj).data.equals(this.data);
    }
}
