package model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {
    private int size;
    private List<Entry> entries = new ArrayList<>();// contains the entries

    public void push(Entry entryThatHasBeenPassed) {
        entries.add(entryThatHasBeenPassed);
    }

    public Entry pop() {
        if (entries.size() > 0) {
            Entry a = entries.get(entries.size() - 1); // get newest entry
            this.getEntries().remove(entries.size() - 1); // remove newest entry
            return a; // return newest entry
        } else {
            throw new EmptyStackException();
        }
    }


    public Entry top() { // return the newest entry
        if (entries.size() > 0) { // if the size is 0 then shall return an empty stack exception
            return entries.get(entries.size() - 1);
        } else {
            throw new EmptyStackException();
        }
    }

    public int size() {
        if (entries.size() == 0) {
            return 0;
        } else {
            return entries.size();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> listEntryClass) {
        this.entries = listEntryClass;
    }
}

