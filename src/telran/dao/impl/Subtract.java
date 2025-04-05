package telran.dao.impl;

import telran.dao.Operation;

public class Subtract implements Operation {

    public String getName() {
        return "Subtract";
    }

    public double execute(double n1, double n2) {
        return n1 - n2;
    }
}
