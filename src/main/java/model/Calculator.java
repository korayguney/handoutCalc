package model;

import model.exceptions.InvalidExpression;

public interface Calculator {
    float evaluate(String what) throws InvalidExpression;
}
