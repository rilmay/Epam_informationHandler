package com.epam.informationHandler.composite.compositeImpl.leaf;

import bsh.Interpreter;
import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.entity.InformationJoint;
import com.epam.informationHandler.exception.WrongInputException;
import com.epam.informationHandler.composite.compositeImpl.leaf.informationType.InformationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExpressionHandler implements TextComposite {
    private final static Logger logger = LogManager.getLogger(ExpressionHandler.class);
    private InformationJoint expression;

    private String solve(String input){
        Interpreter interpreter = new Interpreter();
        String result = input;
        try {
            interpreter.eval("result = " + input);
            result = interpreter.get("result").toString();
            logger.info("Successfully resolved expression: " + input + " = " + result);
        } catch (bsh.EvalError e) {
            logger.warn("Failed to resolve expression: " + input);
        }
        return result;
    }

    @Override
    public String read() {
        return " " + expression.getData();
    }

    public ExpressionHandler(String input) {
        if (input == null) {
            logger.error("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        expression = new InformationJoint(solve(input), InformationType.EXPRESSION);
    }
}
