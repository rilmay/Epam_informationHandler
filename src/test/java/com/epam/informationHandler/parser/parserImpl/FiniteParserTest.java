package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.LexemeHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserInterface.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FiniteParserTest {
    Parser finiteParser;
    String parsedString;
    TextCompositeJoint lexeme;

    @BeforeTest
    public void init(){
        finiteParser = new FiniteParser();
        parsedString = "3<<2";
        lexeme = new LexemeHandler();
    }

    @Test
    public void testParse(){
        finiteParser.parse(lexeme,parsedString);
        Assert.assertEquals(" 12",lexeme.read());
    }

}
