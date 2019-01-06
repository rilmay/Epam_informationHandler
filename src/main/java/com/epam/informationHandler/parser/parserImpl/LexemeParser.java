package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.LexemeHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserImpl.abstactParser.AbstractParser;
import com.epam.informationHandler.utility.LoggerMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(LexemeParser.class);
    private final String LEXEME_PATTERN = "[^ ]+";

    @Override
    protected TextCompositeJoint init() {
        return new LexemeHandler();
    }

    @Override
    public void parse(TextCompositeJoint parent, String parsedString) {
        logger.info("Parsing: " + LoggerMessage.getShortMessage(parsedString));
        parsedString = parsedString.replaceAll("(( - )|\\.{3}|[.,;!?])", " $1 ");
        parseAbstract(parent, parsedString, LEXEME_PATTERN);
    }
}
