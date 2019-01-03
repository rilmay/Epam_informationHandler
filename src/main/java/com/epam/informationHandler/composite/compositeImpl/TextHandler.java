package com.epam.informationHandler.composite.compositeImpl;

import com.epam.informationHandler.composite.compositeImpl.abstractCompositeJoint.AbstractJointHandler;

public class TextHandler extends AbstractJointHandler {
    public TextHandler() {
        super();
    }

    @Override
    public String read() {
        return "\t" + super.read().trim();
    }
}
