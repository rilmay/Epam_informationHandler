package com.epam.informationHandler.composite.CompositeImpl.leaf;

import com.epam.informationHandler.composite.compositeImpl.leaf.ExpressionHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.WordHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorHandlerTest {
    WordHandler wordHandler;

    @BeforeTest
    public void init() {
        wordHandler = new WordHandler("Hello");
    }

    @Test
    public void testRead() {
        Assert.assertEquals(" Hello", wordHandler.read());
    }
}
