package com.epam.informationHandler.composite.CompositeImpl.leaf;

import com.epam.informationHandler.composite.compositeImpl.leaf.ExpressionHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpressionHandlerTest {
    private ExpressionHandler expressionHandler;
    private ExpressionHandler wrongExpressionHandler;

    @BeforeTest
    public void init() {
        expressionHandler = new ExpressionHandler("3<<6");
        wrongExpressionHandler = new ExpressionHandler("32<");
    }

    @Test
    public void testRead() {
        Integer temp = 3 << 6;
        Assert.assertEquals(expressionHandler.read(), " " + temp);
    }

    @Test
    public void testReadWrongExpression() {
        Assert.assertEquals(wrongExpressionHandler.read(), " 32<");
    }

}
