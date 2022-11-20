package model;

public class StrStack {
    private Stack strStack;

    public void push(String stringThatHasBeenPassed) {
        if(strStack == null) {
            strStack = new Stack();
        }
        this.strStack.push(new Entry(stringThatHasBeenPassed));
    }

    public String pop() {
        return this.strStack.pop().getStr();
    }

    public boolean isEmpty() {
        if(this.strStack.getEntries().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
