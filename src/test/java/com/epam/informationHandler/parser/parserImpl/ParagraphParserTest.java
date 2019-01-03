package com.epam.informationHandler.parser.parserImpl;

import com.epam.informationHandler.composite.compositeImpl.ParagraphHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import com.epam.informationHandler.parser.parserInterface.TextParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParagraphParserTest {
    private String parsedString;
    private TextCompositeJoint textCompositeJoint;
    private TextParser parserChain;

    @BeforeTest
    public void init() {
        parsedString = "\tIt has survived - not only (five) centuries, but also the leap into 13<<2 electronic " +
                "typesetting, remaining 3>>5 essentially 6&9|(3&4) unchanged. It was popularised in the " +
                "5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem " +
                "Ipsum passages, and more recently with desktop publishing software like Aldus " +
                "PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using " +
                "(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal " +
                "distribution of letters, as opposed to using (Content here), content here, making it look " +
                "like readable English.\n" +
                "\tIt is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a " +
                "page when looking at its layout.\n" +
                "\tBye.";
        textCompositeJoint = new ParagraphHandler();
        parserChain = new ParagraphParser();
        parserChain.linkWith(new SentenceParser()).linkWith(new LexemeParser()).linkWith(new FiniteParser());
    }

    @Test
    public void testParse() {
        parserChain.parse(textCompositeJoint, parsedString);
        Assert.assertEquals(textCompositeJoint.read(), "\n\tIt has survived - not only (five) centuries, " +
                "but also the leap into 52 electronic typesetting, remaining 0 essentially 0 unchanged. It was " +
                "popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more " +
                "recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable content of a page " +
                "when looking at its layout. The point of using 79 Ipsum is that it has a more-or-less normal " +
                "distribution of letters, as opposed to using (Content here), content here, making it look like " +
                "readable English.\n" +
                "\tIt is a 1213 established fact that a reader will be of a page when looking at its layout.\n" +
                "\tBye.");
    }
}
