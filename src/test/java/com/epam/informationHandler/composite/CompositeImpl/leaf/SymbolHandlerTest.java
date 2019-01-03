package com.epam.informationHandler.composite.CompositeImpl.leaf;

import com.epam.informationHandler.composite.compositeImpl.leaf.SymbolHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SymbolHandlerTest {

    SymbolHandler symbolHandler;

    @BeforeTest
    public void init() {
        symbolHandler = new SymbolHandler("-");
    }

    @Test
    public void testRead() {
        Assert.assertEquals(" -", symbolHandler.read());
    }
}
