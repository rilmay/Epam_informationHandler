package com.epam.informationHandler.composite.compositeImpl.leaf;

import bsh.Interpreter;
import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.exception.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ExpressionHandler implements TextComposite {
    private final static Logger logger = LogManager.getLogger(ExpressionHandler.class);
    private String expression;

    @Override
    public String read() {
        return " "+expression;
    }

    public ExpressionHandler(String expression) {
        if(expression == null){
            logger.error("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        Interpreter interpreter = new Interpreter();
        try {
            interpreter.eval("result = " + expression);
            this.expression = interpreter.get("result").toString();
            logger.info("Successfully resolved expression: "+expression+" = "+this.expression);
        }catch (bsh.EvalError e){
            logger.warn("Failed to resolve expression: "+expression);
            this.expression = expression;
        }
    }
}
