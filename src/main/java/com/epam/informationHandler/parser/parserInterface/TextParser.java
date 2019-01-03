package com.epam.informationHandler.parser.parserInterface;

import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;

public interface TextParser {
    TextParser linkWith(TextParser parser);

    void parse(TextCompositeJoint parent, String parsedString);
}
