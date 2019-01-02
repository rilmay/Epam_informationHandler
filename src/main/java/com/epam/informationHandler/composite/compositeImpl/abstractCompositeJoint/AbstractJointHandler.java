package com.epam.informationHandler.composite.compositeImpl.abstractCompositeJoint;

import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.composite.compositeInterface.TextCompositeJoint;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractJointHandler implements TextCompositeJoint {
    protected List<TextComposite> textCompositeList = new LinkedList<>();

    public void addLeaf(TextComposite textComposite) {
        textCompositeList.add(textComposite);
    }

    public void deleteLeaf(TextComposite textComposite) {
        textCompositeList.remove(textComposite);
    }

    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        textCompositeList.forEach(c -> stringBuilder.append(c.read()));
        return stringBuilder.toString();
    }
}
