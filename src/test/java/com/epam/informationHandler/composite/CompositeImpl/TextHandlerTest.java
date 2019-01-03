package com.epam.informationHandler.composite.CompositeImpl;

import com.epam.informationHandler.composite.compositeImpl.TextHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.SymbolHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.WordHandler;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextHandlerTest {
    private TextCompositeJoint text;

    @BeforeTest
    public void init(){
        text = new TextHandler();
        text.addLeaf(new WordHandler("Ping"));
        text.addLeaf(new SymbolHandler("-"));
        text.addLeaf(new WordHandler("pong"));
        text.addLeaf(new SymbolHandler("."));
    }

    @Test
    public void testRead(){
        Assert.assertEquals(text.read(),"\tPing - pong.");
    }
}
