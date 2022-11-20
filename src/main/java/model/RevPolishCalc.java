package model;

import model.exceptions.InvalidExpression;

public class RevPolishCalc implements Calculator {

    private NumStack stack = new NumStack();

    @Override
    public float evaluate(String expr) throws InvalidExpression {
        for (String token : expr.split("\\s+")) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    float divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Float.parseFloat(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        try {
            System.out.println(new RevPolishCalc().evaluate("5 6 7 + * 2 -"));
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
