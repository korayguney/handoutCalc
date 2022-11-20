package model;

import model.exceptions.InvalidExpression;

public class StandartCalc implements Calculator {

    private OpStack operator;
    private RevPolishCalc rpCalc;

    @Override
    public float evaluate(String what) throws InvalidExpression {
        try {
            rpCalc = new RevPolishCalc();
            return rpCalc.evaluate(infixToRpn(what));
        } catch (InvalidExpression e) {
            throw new InvalidExpression(e.getMessage());
        }
    }

    private String infixToRpn(String exp) {
        if (exp == null)
            return null;
        String res = "";
        int len = exp.length();
        operator = new OpStack();
        StrStack strStack = new StrStack();
        //avoid checking empty
        operator.push(Symbol.ZERO);
        for (int i = 0; i < len; ) {
            //deal with space
            while (i < len && exp.charAt(i) == ' ')
                i++;
            if (i == len)
                break;
            //if is number
            if (isNum(exp.charAt(i))) {
                String num = "";
                while (i < len && isNum(exp.charAt(i)))
                    num += exp.charAt(i++);
                strStack.push(num);
                //is operator
            } else if (isOperator(exp.charAt(i))) {
                char op = exp.charAt(i);
                Symbol nextSymbol = decideOperatorSymbol(op);
                switch (nextSymbol) {
                    case LEFT_BRACKET:
                        operator.push(nextSymbol);
                        break;
                    case RIGHT_BRACKET:
                        while (operator.getNumStack().top().getOther() != Symbol.LEFT_BRACKET)
                            strStack.push(decideOperatorString(operator.pop()));
                        operator.pop();
                        break;
                    case PLUS:
                    case MINUS:
                        if (operator.getNumStack().top().getOther() == Symbol.LEFT_BRACKET)
                            operator.push(nextSymbol);
                        else {
                            while (operator.getNumStack().top().getOther() != Symbol.ZERO &&
                                    operator.getNumStack().top().getOther() != Symbol.LEFT_BRACKET)
                                strStack.push(decideOperatorString(operator.pop()));
                            operator.push(nextSymbol);
                        }
                        break;
                    case TIMES:
                    case DIVIDE:
                        if (operator.getNumStack().top().getOther() == Symbol.LEFT_BRACKET)
                            operator.push(nextSymbol);
                        else {
                            while (operator.getNumStack().top().getOther() != Symbol.ZERO
                                    && operator.getNumStack().top().getOther() != Symbol.PLUS
                                    && operator.getNumStack().top().getOther() != Symbol.MINUS
                                    && operator.getNumStack().top().getOther() != Symbol.LEFT_BRACKET)
                                strStack.push(decideOperatorString(operator.pop()));
                            operator.push(nextSymbol);
                        }
                        break;
                }
                i++;
            }
        }
        while (operator.getNumStack().top().getOther() != Symbol.ZERO)
            strStack.push(decideOperatorString(operator.pop()));
        while (strStack.isEmpty())
            res = res.length() == 0
                    ? strStack.pop() + res
                    : strStack.pop() + " " + res;
        return res;
    }

    private Symbol decideOperatorSymbol(char op) {
        switch (op) {
            case '(':
                return Symbol.LEFT_BRACKET;
            case ')':
                return Symbol.RIGHT_BRACKET;
            case '+':
                return Symbol.PLUS;
            case '-':
                return Symbol.MINUS;
            case '*':
                return Symbol.TIMES;
            case '/':
                return Symbol.DIVIDE;
            default:
                break;
        }
        return null;
    }

    private String decideOperatorString(Symbol symbol) {
        switch (symbol) {
            case LEFT_BRACKET:
                return "(";
            case RIGHT_BRACKET:
                return ")";
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case TIMES:
                return "*";
            case DIVIDE:
                return "/";
            default:
                break;
        }
        return null;
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    public boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    public static void main(String[] args) {
        String expression = "(5 * (6 + 7)) - 2";
        System.out.println(new StandartCalc().infixToRpn(expression));
        System.out.println(new StandartCalc().evaluate(expression));
    }
}
