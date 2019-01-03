package com.epam.informationHandler.composite.compositeImpl;

import com.epam.informationHandler.composite.compositeImpl.abstractCompositeJoint.AbstractJointHandler;

public class ParagraphHandler extends AbstractJointHandler {
    public ParagraphHandler() {
        super();
    }

    @Override
    public String read() {
        return "\n\t" + super.read().trim();
    }
}
