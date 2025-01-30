package org.example;

public class DoubleSet {
    int key;
    String value;

    public DoubleSet(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + "'" + key + "'" + "," + "'" + value + "'" + ")";
    }
}
