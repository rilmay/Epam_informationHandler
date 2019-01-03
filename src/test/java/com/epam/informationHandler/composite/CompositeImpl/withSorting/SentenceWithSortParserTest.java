package com.epam.informationHandler.composite.CompositeImpl.withSorting;

import com.epam.informationHandler.composite.compositeImpl.leaf.SymbolHandler;
import com.epam.informationHandler.composite.compositeImpl.leaf.WordHandler;
import com.epam.informationHandler.composite.compositeImpl.withSorting.SentenceWithSortHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceWithSortParserTest {
    SentenceWithSortHandler sentenceWithSortHandler;

    @BeforeTest
    public void init(){
        sentenceWithSortHandler = new SentenceWithSortHandler('m');
        sentenceWithSortHandler.addLeaf(new WordHandler("truck"));
        sentenceWithSortHandler.addLeaf(new WordHandler("my"));
        sentenceWithSortHandler.addLeaf(new WordHandler("mimosa"));
        sentenceWithSortHandler.addLeaf(new WordHandler("muscle"));
        sentenceWithSortHandler.addLeaf(new SymbolHandler("."));
    }

    @Test
    public void testRead(){
        Assert.assertEquals(" mimosa muscle my truck.",sentenceWithSortHandler.read());
    }



}
