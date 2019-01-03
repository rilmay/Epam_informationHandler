package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.ParagraphHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserImpl.abstactParser.AbstractParser;
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
        logger.info("Parsing: " + parsedString);
        parsedString = parsedString.replaceAll("[\n\r]", " ");
        parseAbstract(parent, parsedString, PARAGRAPH_PATTERN);
    }
}




