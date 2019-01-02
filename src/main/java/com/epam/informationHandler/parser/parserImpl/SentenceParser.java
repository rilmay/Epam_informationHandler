package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.SentenceHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserImpl.abstactParser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SentenceParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private final String SENTENCE_PATTERN = "[^.!?]+(?:[.]{3}|[.!?])";

    @Override
    protected TextCompositeJoint init() {
        return new SentenceHandler();
    }

    @Override
    public void parse(TextCompositeJoint parent, String parsedString) {
        logger.info("Parsing: "+parsedString);
        parseAbstract(parent, parsedString, SENTENCE_PATTERN);
    }
}
