package telran.dao.impl;

import telran.dao.Operation;

public class Add implements Operation {

    public double execute(double n1, double n2) {
        return n1 + n2;
    }
}
