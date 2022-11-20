package model;

public class NumStack {
    private Stack numStack;

    public void push(float valueThatHasBeenPassed) {
        if(numStack == null) {
            numStack = new Stack();
        }
        this.numStack.push(new Entry(valueThatHasBeenPassed));
    }

    public float pop() {
        if(numStack == null) {
            numStack = new Stack();
        }
        return this.numStack.pop().getValue();
    }

    public boolean isEmpty() {
        if(this.numStack.getSize() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
