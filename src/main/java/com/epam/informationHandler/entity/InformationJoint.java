package com.epam.informationHandler.entity;

import com.epam.informationHandler.composite.compositeImpl.leaf.informationType.InformationType;

import java.util.Objects;

public class InformationJoint {
    private String data;
    private InformationType informationType;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public InformationType getInformationType() {
        return informationType;
    }

    public void setInformationType(InformationType informationType) {
        this.informationType = informationType;
    }

    public InformationJoint() {
    }

    public InformationJoint(String data, InformationType informationType) {
        this.data = data;
        this.informationType = informationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationJoint that = (InformationJoint) o;
        return Objects.equals(data, that.data) &&
                informationType == that.informationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, informationType);
    }

    @Override
    public String toString() {
        return data;
    }
}
