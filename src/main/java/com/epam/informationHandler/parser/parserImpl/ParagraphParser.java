package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.ParagraphHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserImpl.abstactParser.AbstractParser;
import com.epam.informationHandler.utility.LoggerMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParagraphParser.class);
    private final String PARAGRAPH_PATTERN = "[^\t]+";

    protected TextCompositeJoint init() {
        return new ParagraphHandler();
    }

    @Override
    public void parse(TextCompositeJoint parent, String parsedString) {
        parsedString = parsedString.replaceAll("[\n\r]", " ");
        logger.info("Parsing: " + LoggerMessage.getShortMessage(parsedString));
        parseAbstract(parent, parsedString, PARAGRAPH_PATTERN);
    }
}




