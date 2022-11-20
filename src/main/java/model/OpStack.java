package model;

public class OpStack {
    private Stack numStack = new Stack();

    public void push(Symbol symbolThatHasBeenPassed) {
        this.numStack.push(new Entry(symbolThatHasBeenPassed));
    }

    public Symbol pop() {
        return this.numStack.pop().getOther();
    }

    public boolean isEmpty() {
        if(this.numStack.getSize() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Stack getNumStack() {
        return numStack;
    }

}
