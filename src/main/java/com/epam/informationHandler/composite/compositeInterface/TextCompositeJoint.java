package com.epam.informationHandler.composite.compositeInterface;

public interface TextCompositeJoint extends TextComposite {
    void addLeaf(TextComposite textComposite);
    void deleteLeaf(TextComposite textComposite);
}
