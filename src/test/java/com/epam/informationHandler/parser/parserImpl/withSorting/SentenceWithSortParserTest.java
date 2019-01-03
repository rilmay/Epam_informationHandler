package com.epam.informationHandler.parser.parserImpl.withSorting;

import com.epam.informationHandler.composite.compositeImpl.TextHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserImpl.FiniteParser;
import com.epam.informationHandler.parser.parserImpl.LexemeParser;
import com.epam.informationHandler.parser.parserInterface.TextParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceWithSortParserTest {
    private TextCompositeJoint text;
    private TextParser parserChain;
    private String parsedString;

    @BeforeTest
    public void init() {
        text = new TextHandler();
        parsedString = "Hello my dear friend. This is Nikita.";
        parserChain = new SentenceWithSortParser('i');
        parserChain.linkWith(new LexemeParser()).linkWith(new FiniteParser());
        parserChain.parse(text, parsedString);
    }

    @Test
    public void testParse() {
        Assert.assertEquals(text.read(),"\tfriend Hello dear my. Nikita This is.");
    }

}
