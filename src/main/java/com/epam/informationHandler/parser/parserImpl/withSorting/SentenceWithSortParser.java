package com.epam.informationHandler.parser.parserImpl.withSorting;

import com.epam.informationHandler.composite.compositeImpl.withSorting.SentenceWithSortHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserImpl.SentenceParser;

public class SentenceWithSortParser extends SentenceParser {
    private final char symbol;

    public SentenceWithSortParser(char symbol) {
        this.symbol = symbol;
    }

    @Override
    protected TextCompositeJoint init() {
        return new SentenceWithSortHandler(symbol);
    }
}
