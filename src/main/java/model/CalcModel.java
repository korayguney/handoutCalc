package model;

public class CalcModel {

    private Calculator revPolish;
    private Calculator standart;

    public float evaluate(String expr, boolean infix) {
        if (infix) {
            return this.standart.evaluate(expr);
        } else {
            return this.revPolish.evaluate(expr);
        }
    }

}
