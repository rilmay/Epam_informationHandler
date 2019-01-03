package com.epam.informationHandler.composite.CompositeImpl;

import com.epam.informationHandler.composite.compositeImpl.SentenceHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.WordHandler;
import com.epam.informationHandler.exception.WrongInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceHandlerTest {
    private SentenceHandler sentenceHandler;
    private WordHandler wordHandler;
    private WordHandler wordHandler2;
    private WordHandler wordHandler3;

    @BeforeTest
    public void init() {
        sentenceHandler = new SentenceHandler();
        wordHandler = new WordHandler("I");
        wordHandler2 = new WordHandler("am");
        wordHandler3 = new WordHandler("Nikita");
        sentenceHandler.addLeaf(wordHandler);
        sentenceHandler.addLeaf(wordHandler2);
    }

    @Test
    public void testAddLeaf() {
        sentenceHandler.addLeaf(wordHandler3);
        Assert.assertEquals(sentenceHandler.read(), " I am Nikita");
        sentenceHandler.deleteLeaf(wordHandler3);
    }

    @Test
    public void testDeleteLeaf() {
        sentenceHandler.deleteLeaf(wordHandler);
        Assert.assertEquals(sentenceHandler.read(), " am");
    }

    @Test(expectedExceptions = WrongInputException.class)
    public void testFailedAddLeaf() {
        sentenceHandler.addLeaf(null);
    }

    @Test(expectedExceptions = WrongInputException.class)
    public void testFailedDeleteLeaf() {
        sentenceHandler.deleteLeaf(wordHandler3);
    }

}
