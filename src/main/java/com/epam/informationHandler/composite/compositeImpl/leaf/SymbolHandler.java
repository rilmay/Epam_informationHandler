package com.epam.informationHandler.composite.compositeImpl.leaf;

import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.exception.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolHandler implements TextComposite {
    private final static Logger logger = LogManager.getLogger(SymbolHandler.class);
    private String symbol;

    @Override
    public String read() {
        return symbol.equals("-") ? " " + symbol : symbol;
    }

    public SymbolHandler(String symbol) {
        if (symbol == null) {
            logger.error("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        this.symbol = symbol;
    }
}
