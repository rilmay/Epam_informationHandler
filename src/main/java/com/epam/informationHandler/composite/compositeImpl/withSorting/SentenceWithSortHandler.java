package com.epam.informationHandler.composite.compositeImpl.withSorting;

import com.epam.informationHandler.composite.compositeImpl.abstractCompositeJoint.AbstractJointHandler;
import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.utility.LoggerMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SentenceWithSortHandler extends AbstractJointHandler {
    private final Logger logger = LogManager.getLogger(SentenceWithSortHandler.class);
    private final Comparator<TextComposite> compByAlphabet;
    private final Comparator<TextComposite> compBySymbol;
    private final char symbol;

    public SentenceWithSortHandler(char symbol) {
        this.symbol = symbol;
        compByAlphabet = Comparator.comparing(
                lex -> lex.read()
                        .replaceAll("[() ]", "")
                        .replaceAll("(?:(?!\\w)-(?!\\w))|[.,;?]", "ÿ"));
        compBySymbol = Comparator.comparing(
                lex -> lex.read()
                        .replaceAll("(?i)[^" + this.symbol + "](?-i)", "")
                        .length());
    }

    @Override
    public String read() {
        textCompositeList.sort(compBySymbol.reversed().thenComparing(compByAlphabet));
        String sorted = super.read();
        logger.info("Following sentence is sorted by \"" + symbol + "\": " + LoggerMessage.getShortMessage(sorted));
        return sorted;
    }
}
