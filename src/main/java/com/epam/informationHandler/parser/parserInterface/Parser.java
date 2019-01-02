package com.epam.informationHandler.parser.parserInterface;

import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;

public interface Parser {
    Parser linkWith(Parser parser);

    void parse(TextCompositeJoint parent, String parsedString);
}
