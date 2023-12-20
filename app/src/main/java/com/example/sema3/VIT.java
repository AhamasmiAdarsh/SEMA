package com.example.sema3;

import java.lang.reflect.Array;

public class VIT {
    private Number V, I, T;

    public VIT() {

    }

    public VIT(Number V, Number I, Number T) {
        this.V = V;
        this.I = I;
        this.T = T;
    }

    public Number getV() {
        return V;
    }

    public void setV(Number v) {
        V = v;
    }

    public Number getI() {
        return I;
    }

    public void setI(Number i) {
        I = i;
    }

    public Number getT() {
        return T;
    }

    public void setT(Number t) {
        T = t;
    }

    public Number[] getVITArray() {
        Number[] vitArray = {V, I, T};
        return vitArray;
    }
}
