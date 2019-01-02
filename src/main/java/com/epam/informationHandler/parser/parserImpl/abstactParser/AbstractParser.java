package com.epam.informationHandler.parser.parserImpl.abstactParser;

import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.exception.WrongInputException;
import com.epam.informationHandler.parser.parserInterface.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {
    protected Parser nextParser;

    @Override
    public Parser linkWith(Parser parser) {
        this.nextParser = parser;
        return nextParser;
    }

    protected void parseAbstract(TextCompositeJoint parent, String parsedString, String PARSER_PATTERN) {
        if (parent == null){
            throw new WrongInputException("Null pointer accepted");
        }
        Pattern pattern = Pattern.compile(PARSER_PATTERN);
        Matcher matcher = pattern.matcher(parsedString);
        while (matcher.find()) {
            TextCompositeJoint newComponent = init();
            parent.addLeaf(newComponent);
            if (nextParser != null) {
                nextParser.parse(newComponent, matcher.group());
            }
        }
    }

    protected abstract TextCompositeJoint init();
}
