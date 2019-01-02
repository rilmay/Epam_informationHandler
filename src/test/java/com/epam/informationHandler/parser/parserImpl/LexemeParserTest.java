package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.SentenceHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserInterface.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LexemeParserTest {
    Parser parserChain;
    String parsedString;
    TextCompositeJoint sentence;

    @BeforeTest
    public void init() {
        parserChain = new LexemeParser();
        parserChain.linkWith(new FiniteParser());
        parsedString = "Today is 3<<2 of february, 2038.";
        sentence = new SentenceHandler();
    }

    @Test
    public void testParse() {
        parserChain.parse(sentence, parsedString);
        Assert.assertEquals(sentence.read(), " Today is 12 of february, 2038.");
    }

    @Test
    public void testLinkWith() {
        Parser testParser = new ParagraphParser();
        Parser secondParser = new FiniteParser();
        Assert.assertEquals(testParser.linkWith(secondParser), secondParser);
    }
}
