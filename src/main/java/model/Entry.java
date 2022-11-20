package model;

import model.exceptions.BadType;

public class Entry {
    private float number;
    private Symbol other;
    private String str;
    private Type type;

    public Entry(float value) {
        this.number = value;
        this.type = Type.NUMBER;
    }

    public Entry(Symbol which) {
        this.other = which;
        this.type = Type.SYMBOL;
    }

    public Entry(String str) {
        this.str = str;
        this.type = Type.STRING;
    }

    public float getValue() throws BadType {
        return number;
    }

    public Symbol getOther() throws BadType {
        return other;
    }

    public String getStr() throws BadType {
        return str;
    }

    public Type getType() {
        return type;
    }
}
