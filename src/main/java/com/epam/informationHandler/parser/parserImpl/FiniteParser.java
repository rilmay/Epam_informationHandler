package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.leaf.ExpressionHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.SymbolHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.WordHandler;
import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.exception.WrongInputException;
import com.epam.informationHandler.parser.parserInterface.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiniteParser implements Parser {
    private final Logger logger = LogManager.getLogger(FiniteParser.class);
    private final String EXPRESSION_PATTERN = "(?>[0-9><|&()^]{3,})";
    private final String SYMBOL_PATTERN = "(?>[.]{3}|[,.;!?]|(^-$))";
    private Parser nextParser;

    @Override
    public Parser linkWith(Parser parser) {
        this.nextParser = parser;
        return nextParser;
    }

    private boolean parseAbstract(TextCompositeJoint parent, String parsedString, String regex, String whichType) {
        Pattern ExPattern = Pattern.compile(regex);
        Matcher matcher = ExPattern.matcher(parsedString);
        while (matcher.find()) {
            String newComponentString = matcher.group();
            logger.info("Successfully parsed " + whichType + ": " + newComponentString);
            parent.addLeaf(init(whichType, newComponentString));
            return true;
        }
        return false;
    }

    private TextComposite init(String whichType, String input) {
        if (whichType.equals("expression")) {
            return new ExpressionHandler(input);
        }
        return new SymbolHandler(input);
    }

    @Override
    public void parse(TextCompositeJoint parent, String parsedString) {
        if (parent == null) {
            logger.info("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        if (parseAbstract(parent, parsedString, EXPRESSION_PATTERN, "expression")) {
        } else {
            if (parseAbstract(parent, parsedString, SYMBOL_PATTERN, "symbol")) {
            } else {
                logger.info("Successfully parsed word: " + parsedString);
                parent.addLeaf(new WordHandler(parsedString));
            }
        }
    }
}