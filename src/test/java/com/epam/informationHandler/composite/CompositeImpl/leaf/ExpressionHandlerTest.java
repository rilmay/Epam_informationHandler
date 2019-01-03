package com.epam.informationHandler.composite.CompositeImpl.leaf;

import com.epam.informationHandler.composite.compositeImpl.leaf.ExpressionHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpressionHandlerTest {
    ExpressionHandler expressionHandler;
    ExpressionHandler wrongExpressionHandler;

    @BeforeTest
    public void init() {
        expressionHandler = new ExpressionHandler("3<<6");
        wrongExpressionHandler = new ExpressionHandler("32<");
    }

    @Test
    public void testRead() {
        Integer temp = 3 << 6;
        Assert.assertEquals(" " + temp, expressionHandler.read());
    }

    @Test
    public void testReadWrongExpression(){
        Assert.assertEquals(" 32<",wrongExpressionHandler.read());
    }

}
